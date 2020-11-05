/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marjan
 */
public class Recepcioner implements OpstiDomenskiObjekat {

    private int RecepcionerID;
    private String ime;
    private String prezime;
    private String korisnickoIme;
    private String sifra;
    private String status = "offline";

    public Recepcioner() {
    }

    public Recepcioner(int RecepcionerID, String ime, String prezime, String korisnickoIme, String sifra) {
        this.RecepcionerID = RecepcionerID;
        this.ime = ime;
        this.prezime = prezime;
        this.korisnickoIme = korisnickoIme;
        this.sifra = sifra;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public int getRecepcionerID() {
        return RecepcionerID;
    }

    public void setRecepcionerID(int RecepcionerID) {
        this.RecepcionerID = RecepcionerID;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

   

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Recepcioner other = (Recepcioner) obj;
        if (!Objects.equals(this.korisnickoIme, other.korisnickoIme)) {
            return false;
        }
        if (!Objects.equals(this.sifra, other.sifra)) {
            return false;
        }
        return true;
    }
    
    
    

    @Override
    public String vratiNazivTabele() {
        return "recepcioner";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return "";
    }

    @Override
    public String vratiUslov() {
        return " korisnickoIme='" + getKorisnickoIme() + "' AND sifra='" + getSifra() + "'";
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        return "";
    }

    @Override
    public String vratiTabeluSaUslovomSpajanja() {
        return "";
    }

    @Override
    public OpstiDomenskiObjekat vratiObjekat(ResultSet rs) {
        Recepcioner r = null;
        try {
            while (rs.next()) {

                int id = rs.getInt("recepcionerID");
                String ime = rs.getString("ime");
                String prezime = rs.getString("prezime");
                String user = rs.getString("korisnickoIme");
                String pass = rs.getString("sifra");

                r = new Recepcioner(id, ime, prezime, user, pass);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Recepcioner.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    @Override
    public String vratiZaMax() {
        return "";
    }

    @Override
    public int vratiID(ResultSet rs) {
        return 0;
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListu(ResultSet rs) {
        List<OpstiDomenskiObjekat> lista_recepcionera = new LinkedList<>();
        try {
            while (rs.next()) {

                int id = rs.getInt("recepcionerID");
                String ime = rs.getString("ime");
                String prezime = rs.getString("prezime");
                String user = rs.getString("korisnickoIme");
                String pass = rs.getString("sifra");

                Recepcioner r = new Recepcioner(id, ime, prezime, user, pass);
                lista_recepcionera.add(r);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            //Logger.getLogger(Recepcioner.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista_recepcionera;
    }

    @Override
    public String vratiKriterijumPretrage(String kriterijum) {
        return "";
    }

    @Override
    public void set(String nazivAtributa, Object vrednostAtributa) {
        switch (nazivAtributa) {

            case "RecepcionerID":
                setRecepcionerID(Integer.parseInt((String) vrednostAtributa));
                break;
            case "ime":
                setIme((String) vrednostAtributa);
                break;
            case "prezime":
                setPrezime((String) vrednostAtributa);
                break;
            case "korisnickoIme":
                setKorisnickoIme((String) vrednostAtributa);
                break;
            case "sifra":
                setSifra((String) vrednostAtributa);
                break;
            case "status":
                setStatus((String) vrednostAtributa);
                break;
        }
    }

}
