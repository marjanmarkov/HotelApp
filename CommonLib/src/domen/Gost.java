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
public class Gost implements OpstiDomenskiObjekat {

    private int gostID;
    private String ime;
    private String prezime;
    private String brTel;
    private boolean smesten;

    public Gost() {
    }

    public Gost(int gostID, String ime, String prezime, String brTel, boolean smesten) {
        this.gostID = gostID;
        this.ime = ime;
        this.prezime = prezime;
        this.brTel = brTel;
        this.smesten = smesten;
    }

    public boolean isSmesten() {
        return smesten;
    }

    public void setSmesten(boolean smesten) {
        this.smesten = smesten;
    }

    public int getGostID() {
        return gostID;
    }

    public void setGostID(int gostID) {
        this.gostID = gostID;
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

    public String getBrTel() {
        return brTel;
    }

    public void setBrTel(String brTel) {
        this.brTel = brTel;
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
        final Gost other = (Gost) obj;
        if (this.smesten != other.smesten) {
            return false;
        }
        if (!Objects.equals(this.ime, other.ime)) {
            return false;
        }
        if (!Objects.equals(this.prezime, other.prezime)) {
            return false;
        }
        if (!Objects.equals(this.brTel, other.brTel)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ime + " " + prezime + " " + brTel;
    }

    @Override
    public String vratiNazivTabele() {
        return "gost";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return "'" + getGostID() + "','" + getIme() + "','" + getPrezime() + "','" + getBrTel() + "','" + smestenLiJe() + "'";
    }

    @Override
    public String vratiUslov() {
        return " gostID = " + getGostID();
    }

    @Override
    public String vratiVrednostiZaUpdate() {

        return " ime ='" + ime + "' , prezime = '" + prezime + "' , brTel = '" + brTel + "' , smesten = '" + smestenLiJe() + "'";
    }

    @Override
    public String vratiTabeluSaUslovomSpajanja() {
        return "";
    }

    @Override
    public OpstiDomenskiObjekat vratiObjekat(ResultSet rs) {
        Gost g = null;
        try {
            while (rs.next()) {
                int id = rs.getInt("gostID");
                String i = rs.getString("ime");
                String p = rs.getString("prezime");
                String bt = rs.getString("brTel");
                boolean s = rs.getBoolean("smesten");
                g = new Gost(id, i, p, bt, s);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Gost.class.getName()).log(Level.SEVERE, null, ex);
        }
        return g;
    }

    @Override
    public String vratiZaMax() {
        return "gostID";
    }

    @Override
    public int vratiID(ResultSet rs) {
        int maks = 0;
        try {
            while (rs.next()) {
                maks = rs.getInt("maks");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Gost.class.getName()).log(Level.SEVERE, null, ex);
        }
        return maks;
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListu(ResultSet rs) {
        List<OpstiDomenskiObjekat> lista_gostiju = new LinkedList<>();
        try {
            while (rs.next()) {

                int id = rs.getInt("gostID");
                String ime = rs.getString("ime");
                String prezime = rs.getString("prezime");
                String brTel = rs.getString("brTel");
                boolean smesten = rs.getBoolean("smesten");
                Gost g = new Gost(id, ime, prezime, brTel, smesten);
                lista_gostiju.add(g);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista_gostiju;
    }

    @Override
    public String vratiKriterijumPretrage(String kriterijum) {
        if (kriterijum.equals("")) {
            return "";
        }
        return " WHERE prezime LIKE '" + kriterijum + "%'";
    }

    @Override
    public void set(String nazivAtributa, Object vrednostAtributa) {
    }

    private String smestenLiJe() {
        if (isSmesten()) {
            return "1";
        } else {
            return "0";
        }
    }

}
