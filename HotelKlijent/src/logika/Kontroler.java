/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;//klijent

import domen.Gost;
import domen.IzdavanjeSobe;
import domen.Racun;
import domen.Recepcioner;
import domen.Soba;
import forme.FDetaljiGosta;
import forme.FGenerisiRacun;
import forme.FGlavna;
import forme.FLogin;
import forme.FPretragaGostiju;
import forme.FPretragaSoba;
import forme.FUnosNovogGosta;
import forme.FUnosNovogIzdavanjaSobe;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modeli.ModelTabeleGosti;
import modeli.ModelTabeleSobe;
import session.Session;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;
import util.EnumResponseStatus;
import util.Operacije;

/**
 *
 * @author Marjan
 */
public class Kontroler {

    private static Kontroler instanca;

    List<Gost> gosti;
    List<Soba> sobe;

    private Kontroler() {
    }

    public static Kontroler getInstanca() {
        if (instanca == null) {
            instanca = new Kontroler();
        }
        return instanca;

    }

    public List<Gost> getGosti() {
        return gosti;
    }

    public void uloguj(Recepcioner logovaniRecepcioner, FLogin fl) throws IOException {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.LOGIN);
        kz.setParametar(logovaniRecepcioner);

        Socket socket = Session.getInstanca().getSocket();
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(kz);

        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        try {
            ServerskiOdgovor so = (ServerskiOdgovor) ois.readObject();
            if (so.getResponseStatus() == EnumResponseStatus.OK) {
                fl.uspesno(so, logovaniRecepcioner);
            } else {
                fl.neuspesno(so);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Recepcioner pronadjiRecepcioneraLogin(Recepcioner r) throws IOException {
        Recepcioner recepcioner = null;
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.NADJI_RECEPCIONERA);
        kz.setParametar(r);

        Socket socket = Session.getInstanca().getSocket();
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(kz);

        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

        try {
            ServerskiOdgovor so = (ServerskiOdgovor) ois.readObject();
            recepcioner = (Recepcioner) so.getParametar();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return recepcioner;
    }

    public void sacuvajGosta(Gost gost, FUnosNovogGosta fung) throws IOException {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.SACUVAJ_GOSTA);
        kz.setParametar(gost);

        Socket socket = Session.getInstanca().getSocket();
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(kz);

        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        try {
            ServerskiOdgovor so = (ServerskiOdgovor) ois.readObject();
            if (so.getResponseStatus() == EnumResponseStatus.OK) {
                fung.uspesno();
            } else {
                fung.neuspesno(so);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public int vratiIDGosta() throws IOException {
        int id = 0;
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.VRATI_MAX_ID_GOSTA);

        Socket socket = Session.getInstanca().getSocket();
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(kz);

        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

        try {
            ServerskiOdgovor so = (ServerskiOdgovor) ois.readObject();
            id = (int) so.getParametar();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;

    }

    public List<Gost> vratiGoste() throws IOException {
        List<Gost> gosti = new ArrayList<>();
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.VRATI_SVE_GOSTE);

        Socket socket = Session.getInstanca().getSocket();
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(kz);

        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        try {
            ServerskiOdgovor so = (ServerskiOdgovor) ois.readObject();
            gosti = (List<Gost>) so.getParametar();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return gosti;
    }

    public void popuniTabeluGostiju(FPretragaGostiju fpg) throws IOException {
        gosti = new ArrayList<>();
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.VRATI_SVE_GOSTE);

        Socket socket = Session.getInstanca().getSocket();
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(kz);

        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        try {
            ServerskiOdgovor so = (ServerskiOdgovor) ois.readObject();
            gosti = (List<Gost>) so.getParametar();
            if (!gosti.isEmpty()) {
                fpg.srediFormu(gosti);
            } else {
                fpg.popuniTabeluNeuspesno();
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ModelTabeleGosti vratiModelGosti() {
        ModelTabeleGosti mtg = new ModelTabeleGosti(gosti);
        return mtg;
    }

    public void filterG(String filter, FPretragaGostiju fpg) throws IOException {
        gosti = new ArrayList<>();
        ObjectOutputStream oos = null;
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.VRATI_GOSTE_FILTER);
//        List<Object> parametri = new ArrayList<>();
//        parametri.add(filter);
//        parametri.add(new Gost());
        kz.setParametar(filter);

        Socket socket = Session.getInstanca().getSocket();
        oos = new ObjectOutputStream(socket.getOutputStream());;
        oos.writeObject(kz);
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        try {
            ServerskiOdgovor so = (ServerskiOdgovor) ois.readObject();
            List<Gost> listaGostijuFiltrirana = (List<Gost>) so.getParametar();
            if (!listaGostijuFiltrirana.isEmpty()) {
                fpg.srediFormu(listaGostijuFiltrirana);
                fpg.filterUspesno();
            } else {
                fpg.srediFormu(new ArrayList<Gost>());
                fpg.filterNeuspesan();
            }
        } catch (ClassNotFoundException ex) {
            //Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException ex) {
        }
    }

    public void obrisiGosta(Gost g, int red, FPretragaGostiju fpg) throws IOException {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.OBRISI_GOSTA);
        kz.setParametar(g);

        Socket socket = Session.getInstanca().getSocket();
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(kz);

        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        try {
            ServerskiOdgovor so = (ServerskiOdgovor) ois.readObject();
            if (so.getResponseStatus() == EnumResponseStatus.OK) {
                fpg.uspesnoObrisano(red);
            } else {
                fpg.neuspesnoObrisano(so);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Gost pronadjiGosta(Gost g) throws IOException {
        Gost gost = null;
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.NADJI_GOSTA);
        kz.setParametar(g);

        Socket socket = Session.getInstanca().getSocket();
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(kz);

        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

        try {
            ServerskiOdgovor so = (ServerskiOdgovor) ois.readObject();
            gost = (Gost) so.getParametar();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return gost;

    }

    public void izmeniGosta(Gost g, FDetaljiGosta fdg) throws IOException {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.IZMENI_GOSTA);
        kz.setParametar(g);

        Socket socket = Session.getInstanca().getSocket();
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(kz);

        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        try {
            ServerskiOdgovor so = (ServerskiOdgovor) ois.readObject();
            if (so.getResponseStatus() == EnumResponseStatus.OK) {
                fdg.uspesnoIzmenjeno();
            } else {
                fdg.neuspesnoIzmenjeno(so);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void logout(Recepcioner logovani, FGlavna fg) {
        ObjectOutputStream oos = null;
        try {
            KlijentskiZahtev kz = new KlijentskiZahtev();
            kz.setOperacija(Operacije.LOGOUT);
            kz.setParametar(logovani);

            Socket socket = Session.getInstanca().getSocket();
            oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(kz);

            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            ServerskiOdgovor so = (ServerskiOdgovor) ois.readObject();
            if (so.getResponseStatus() == EnumResponseStatus.OK) {
                fg.uspesanLogou(so);
            } else {
                fg.neuspesanLogou(so);
            }
        } catch (IOException ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void popuniTabeluSoba(FPretragaSoba fps) throws IOException {
        sobe = new ArrayList<>();
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.VRATIS_SVE_SOBE);

        Socket socket = Session.getInstanca().getSocket();
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(kz);

        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        try {
            ServerskiOdgovor so = (ServerskiOdgovor) ois.readObject();
            sobe = (List<Soba>) so.getParametar();
            if (!sobe.isEmpty()) {
                fps.srediFormu(sobe);
            } else {
                fps.popuniTabeluNeuspesno();
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ModelTabeleSobe vratiModelSobe() {
        ModelTabeleSobe mts = new ModelTabeleSobe(sobe);
        return mts;

    }

    public void filterS(String filter, FPretragaSoba fps) throws IOException {
        sobe = new ArrayList<>();
        ObjectOutputStream oos = null;
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.VRATI_SOBE_FILTER);
//        List<Object> parametri = new ArrayList<>();
//        parametri.add(filter);
//        parametri.add(new Gost());
        kz.setParametar(filter);

        Socket socket = Session.getInstanca().getSocket();
        oos = new ObjectOutputStream(socket.getOutputStream());;
        oos.writeObject(kz);
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        try {
            ServerskiOdgovor so = (ServerskiOdgovor) ois.readObject();
            List<Soba> listaSobaFiltrirana = (List<Soba>) so.getParametar();
            if (!listaSobaFiltrirana.isEmpty()) {
                fps.srediFormu(listaSobaFiltrirana);
                 fps.filterUspesno();
            } else {
                fps.srediFormu(new ArrayList<Soba>());
                fps.filterNeuspesan();
            }
        } catch (ClassNotFoundException ex) {
            //Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException ex) {
        }

    }

    public List<Soba> vratiSobe() throws IOException {
        List<Soba> sobe = new ArrayList<>();
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.VRATIS_SVE_SOBE);

        Socket socket = Session.getInstanca().getSocket();
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(kz);

        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        try {
            ServerskiOdgovor so = (ServerskiOdgovor) ois.readObject();
            sobe = (List<Soba>) so.getParametar();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sobe;
    }

    public List<IzdavanjeSobe> vratiIzdavanja() throws IOException {
        List<IzdavanjeSobe> izdavanjaSoba = new ArrayList<>();
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.VRATI_SVA_IZDAVANJA);

        Socket socket = Session.getInstanca().getSocket();
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(kz);

        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        try {
            ServerskiOdgovor so = (ServerskiOdgovor) ois.readObject();
            izdavanjaSoba = (List<IzdavanjeSobe>) so.getParametar();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return izdavanjaSoba;

    }

    public void sacuvajIzdavanjeSobe(IzdavanjeSobe izdavanjeSobe, FUnosNovogIzdavanjaSobe funis) throws IOException {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.SACUVAJ_IZDAVANJE);
        kz.setParametar(izdavanjeSobe);

        Socket socket = Session.getInstanca().getSocket();
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(kz);

        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        try {
            ServerskiOdgovor so = (ServerskiOdgovor) ois.readObject();
            if (so.getResponseStatus() == EnumResponseStatus.OK) {
                funis.uspesnoCuvanje();

            } else {
                funis.neuspesnoCuvanje(so);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void azurirajSobu(Soba izabranaSoba, FUnosNovogIzdavanjaSobe funis) throws IOException {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.IZMENI_SOBU);
        kz.setParametar(izabranaSoba);

        Socket socket = Session.getInstanca().getSocket();
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(kz);

        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        try {
            ServerskiOdgovor so = (ServerskiOdgovor) ois.readObject();
            if (so.getResponseStatus() == EnumResponseStatus.OK) {
                funis.uspesnoAzuriranaSoba();
            } else {
                funis.neuspesnoAzuriranaSoba(so);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void azurirajGosta(Gost izabraniGost, FUnosNovogIzdavanjaSobe funis) throws IOException {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.IZMENI_GOSTA);
        kz.setParametar(izabraniGost);

        Socket socket = Session.getInstanca().getSocket();
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(kz);

        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        try {
            ServerskiOdgovor so = (ServerskiOdgovor) ois.readObject();
            if (so.getResponseStatus() == EnumResponseStatus.OK) {
                funis.uspesnoAzuriranGost();
            } else {
                funis.neuspesnoAzuriranGost(so);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    public void filterI(String filter, FGenerisiRacun fgr) throws IOException {
//        ObjectOutputStream oos = null;
//        KlijentskiZahtev kz = new KlijentskiZahtev();
//        kz.setOperacija(Operacije.VRATI_IZDAVANJA_FILTER);
//        kz.setParametar(filter);
//
//        Socket socket = Session.getInstanca().getSocket();
//        oos = new ObjectOutputStream(socket.getOutputStream());
//        oos.writeObject(kz);
//        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
//        try {
//            ServerskiOdgovor so = (ServerskiOdgovor) ois.readObject();
//            List<IzdavanjeSobe> listaIzdavanjaSobeFiltrirana = (List<IzdavanjeSobe>) so.getParametar();
//            if (!listaIzdavanjaSobeFiltrirana.isEmpty()) {
//                fgr.setListaIzdavanjaSobe(listaIzdavanjaSobeFiltrirana);
//                // fpg.filterUspesno();
//            } else {
//                fgr.neuspesanIS();
//            }
//        } catch (ClassNotFoundException ex) {
//            //Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (NullPointerException ex) {
//        }
//    }

    public int vratiIDRacuna() throws IOException {
        int id = 0;
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.VRATI_MAX_ID_RACUNA);

        Socket socket = Session.getInstanca().getSocket();
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(kz);

        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

        try {
            ServerskiOdgovor so = (ServerskiOdgovor) ois.readObject();
            id = (int) so.getParametar();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;

    }

    public void sacuvajRacun(Racun racun, FGenerisiRacun fgr) throws IOException {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.SACUVAJ_RACUN);
        kz.setParametar(racun);

        Socket socket = Session.getInstanca().getSocket();
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(kz);

        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        try {
            ServerskiOdgovor so = (ServerskiOdgovor) ois.readObject();
            if (so.getResponseStatus() == EnumResponseStatus.OK) {
                fgr.uspesnoSacuvano(racun);
            } else {
                fgr.neuspesnoSacuvano(so);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void azurirajGostaPosleGenerisanjaRacuna(Gost gg, FGenerisiRacun fgr) throws IOException {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.IZMENI_GOSTA);
        kz.setParametar(gg);

        Socket socket = Session.getInstanca().getSocket();
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(kz);

        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        try {
            ServerskiOdgovor so = (ServerskiOdgovor) ois.readObject();
            if (so.getResponseStatus() == EnumResponseStatus.OK) {
                fgr.uspesnoAzuriranGost();
            } else {
                fgr.neuspesnoAzuriranGost(so);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void azurirajSobuPosleGenerisanjaRacuna(Soba ss, FGenerisiRacun fgr) throws IOException {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.IZMENI_SOBU);
        kz.setParametar(ss);

        Socket socket = Session.getInstanca().getSocket();
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(kz);

        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        try {
            ServerskiOdgovor so = (ServerskiOdgovor) ois.readObject();
            if (so.getResponseStatus() == EnumResponseStatus.OK) {
                fgr.uspesnoAzuriranaSoba();
            } else {
                fgr.neuspesnoAzuriranaSoba(so);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


    public void azurirajIzdavanjeSobePosleGenerisanjaRacuna(IzdavanjeSobe i, FGenerisiRacun fgr) throws IOException {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.IZMENI_IZDAVANJE_SOBE);
        kz.setParametar(i);

        Socket socket = Session.getInstanca().getSocket();
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(kz);

        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        try {
            ServerskiOdgovor so = (ServerskiOdgovor) ois.readObject();
            if (so.getResponseStatus() == EnumResponseStatus.OK) {
                fgr.uspesnoAzuriranoIzdavanjeSobe();
            } else {
                fgr.neuspesnoAzuriranaIzdavanjeSobe(so);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
