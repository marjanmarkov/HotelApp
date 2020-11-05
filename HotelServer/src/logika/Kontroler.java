/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;//server

import businesslogic.systemoperation.OpstaSO;
import businesslogic.systemoperation.SOAzurirajGosta;
import businesslogic.systemoperation.SOAzurirajIzdavanjeSobe;
import businesslogic.systemoperation.SOAzurirajSobu;
import businesslogic.systemoperation.SOFiltrirajGoste;

import businesslogic.systemoperation.SOFiltrirajSobe;
import businesslogic.systemoperation.SOObrisiGosta;

import businesslogic.systemoperation.SOPronadjiRecepcionera;
import businesslogic.systemoperation.SOUcitajListuIzdavanja;
import businesslogic.systemoperation.SOUcitajListuRecepcionera;
import businesslogic.systemoperation.SOUcitajPodatkeOGostu;
import businesslogic.systemoperation.SOVratiGoste;
import businesslogic.systemoperation.SOVratiMaxIDGosta;
import businesslogic.systemoperation.SOVratiMaxIDRacuna;
import businesslogic.systemoperation.SOVratiSobe;
import businesslogic.systemoperation.SOZapamtiGosta;
import businesslogic.systemoperation.SOZapamtiIzdavanjeSobe;
import businesslogic.systemoperation.SOZapamtiRacun;
import database.DBBroker;
import domen.Gost;
import domen.IzdavanjeSobe;
import domen.Racun;
import domen.Recepcioner;
import domen.Soba;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marjan
 */
public class Kontroler {

    private static Kontroler instanca;
    private List<Recepcioner> listaRecepcioneraIzBaze;
    List<Recepcioner> listaUlogovanih = new ArrayList<>();

    private Kontroler() {
        try {
            listaRecepcioneraIzBaze = vratiRecepcionere();
        } catch (Exception ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static Kontroler getInstanca() {
        if (instanca == null) {
            instanca = new Kontroler();
        }
        return instanca;
    }

    public List<Recepcioner> getListaRecepcioneraIzBaze() {
        return listaRecepcioneraIzBaze;
    }

    public void setListaRecepcioneraIzBaze(List<Recepcioner> listaRecepcioneraIzBaze) {
        this.listaRecepcioneraIzBaze = listaRecepcioneraIzBaze;
    }

    private List<Recepcioner> vratiRecepcionere() throws Exception {
        try {
            SOUcitajListuRecepcionera so = new SOUcitajListuRecepcionera(new DBBroker());
            so.execute(null);
            return so.getRecepcioneri();
        } catch (Exception e) {
            throw new Exception("Greska kod metode vratiRecepcionere()");
        }

    }

    public void sacuvajGosta(Gost g) throws Exception {
        DBBroker dbBroker = new DBBroker();
        OpstaSO so = new SOZapamtiGosta(dbBroker);
        so.execute(g);
    }

    public Recepcioner nadjiRecepcionera(Object parametar) throws Exception {
        SOPronadjiRecepcionera so = new SOPronadjiRecepcionera(new DBBroker());
        so.execute(parametar);
        return so.getRecepcioner();
    }

    public boolean loginRecepcionera(Recepcioner r) {
        for (Recepcioner recepcioner : listaRecepcioneraIzBaze) {
            if (recepcioner.equals(r)) {
                if (!listaUlogovanih.contains(recepcioner)) {
                    listaUlogovanih.add(recepcioner);
                    recepcioner.set("status", "online");
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public int vratiMaxIDGosta() throws Exception {
        SOVratiMaxIDGosta so = new SOVratiMaxIDGosta(new DBBroker());
        so.execute(null);
        int max = so.getId();
        return max + 1;
    }

    public List<Gost> vratiGoste() throws Exception {
        try {
            SOVratiGoste so = new SOVratiGoste(new DBBroker());
            so.execute(null);
            return so.getGosti();
        } catch (Exception e) {
            throw new Exception("Greska kod izvrsavanja metode vratiGoste()");

        }
    }

    public List<Gost> vratiGosteFilter(Object parametar) throws Exception {
        SOFiltrirajGoste so = new SOFiltrirajGoste(new DBBroker());
        so.execute(parametar);
        return so.getGosti();

    }

    public void obrisiGosta(Gost gBrisanje) throws Exception {
        DBBroker dBBroker = new DBBroker();
        OpstaSO so = new SOObrisiGosta(dBBroker);
        so.execute(gBrisanje);

    }

    public Gost nadjiGosta(Object parametar) throws Exception {
        SOUcitajPodatkeOGostu so = new SOUcitajPodatkeOGostu(new DBBroker());
        so.execute(parametar);
        return so.getGost();
    }

    public void izmeniGosta(Gost izmeniGost) throws Exception {
        SOAzurirajGosta so = new SOAzurirajGosta(new DBBroker());
        so.execute(izmeniGost);
    }

    public boolean logoutRecepcionera(Recepcioner recepc) throws Exception {
        for (Recepcioner r : listaRecepcioneraIzBaze) {
            if (r.equals(recepc)) {
                if (listaUlogovanih.contains(r)) {
                    listaUlogovanih.remove(r);
                    r.set("status", "offline");
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public List<Soba> vratiSobe() throws Exception {
        try {
            SOVratiSobe so = new SOVratiSobe(new DBBroker());
            so.execute(null);
            return so.getSobe();
        } catch (Exception ex) {
            throw new Exception("Greska kod izvrsavanja metode vratiSobe()");
        }

    }

    public List<Soba> vratiSobeFilter(Object parametar) throws Exception {

        SOFiltrirajSobe so = new SOFiltrirajSobe(new DBBroker());
        so.execute(parametar);
        return so.getSobe();

    }

    public List<IzdavanjeSobe> vratiIzdavanja() throws Exception {
        try {
            SOUcitajListuIzdavanja so = new SOUcitajListuIzdavanja(new DBBroker());
            so.execute(null);
            return so.getIzdavanja();
        } catch (Exception e) {
            throw new Exception("greska kod metode vratiIzdavanja()");
        }

    }

    public void izmeniSobu(Soba izmeniSoba) throws Exception {
        OpstaSO so = new SOAzurirajSobu(new DBBroker());
        so.execute(izmeniSoba);

    }

    public void sacuvajIzdavanje(IzdavanjeSobe iS) throws Exception {
        OpstaSO so = new SOZapamtiIzdavanjeSobe(new DBBroker());
        so.execute(iS);
    }

   

    public int vratiMaxIDRacuna() throws Exception {
        SOVratiMaxIDRacuna so = new SOVratiMaxIDRacuna(new DBBroker());
        so.execute(null);
        int max = so.getId();
        return max + 1;
    }

    public void sacuvajRacun(Racun r) throws Exception {
        OpstaSO so = new SOZapamtiRacun(new DBBroker());
        so.execute(r);
    }



    public void izmeniIzdavanje(IzdavanjeSobe izmeniIzdavanje) throws Exception {
        OpstaSO so = new SOAzurirajIzdavanjeSobe(new DBBroker());
        so.execute(izmeniIzdavanje);
    }

}
