/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marjan
 */
public class Racun implements OpstiDomenskiObjekat {

    private int racunID;
    private double iznos;
    private Soba soba;
    private List<StavkaRacuna> stavkeRacuna;

    public Racun() {
        stavkeRacuna = new ArrayList<>();
    }

    public Racun(int racunID, double iznos, Soba soba, List<StavkaRacuna> stavkeRacuna) {
        this.racunID = racunID;
        this.iznos = iznos;
        this.soba = soba;
        this.stavkeRacuna = stavkeRacuna;
    }

    public Soba getSoba() {
        return soba;
    }

    public void setSoba(Soba soba) {
        this.soba = soba;
    }

    public int getRacunID() {
        return racunID;
    }

    public void setRacunID(int racunID) {
        this.racunID = racunID;
    }

    public double getIznos() {
        return iznos;
    }

    public void setIznos(double iznos) {
        this.iznos = iznos;
    }

    public List<StavkaRacuna> getStavkeRacuna() {
        return stavkeRacuna;
    }

    public void setStavkeRacuna(List<StavkaRacuna> stavkeRacuna) {
        this.stavkeRacuna = stavkeRacuna;
    }

    @Override
    public String vratiNazivTabele() {
        return " racun ";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return "'" + getRacunID() + "','" + getIznos() + "','"
                + getSoba().getBrojSobe() + "'";
    }

    @Override
    public String vratiUslov() {
        return "";
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
        return null;
    }

    @Override
    public String vratiZaMax() {
        return "racunID";
    }

    @Override
    public int vratiID(ResultSet rs) {
        int maks = 0;
        try {
            while (rs.next()) {
                maks = rs.getInt("maks");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Racun.class.getName()).log(Level.SEVERE, null, ex);
        }
        return maks;
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListu(ResultSet rs) {
        return null;
    }

    @Override
    public String vratiKriterijumPretrage(String kriterijum) {
        return "";
    }

    @Override
    public void set(String nazivAtributa, Object vrednostAtributa) {
    }

}
