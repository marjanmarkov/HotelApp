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
public class Soba implements OpstiDomenskiObjekat {

    private int brojSobe;
    private boolean zauzeta;
    private TipSobe tipSobe;

    public Soba() {
    }

    public Soba(int brojSobe, boolean zauzeta, TipSobe tipSobe) {
        this.brojSobe = brojSobe;
        this.zauzeta = zauzeta;
        this.tipSobe = tipSobe;
    }

    public TipSobe getTipSobe() {
        return tipSobe;
    }

    public void setTipSobe(TipSobe tipSobe) {
        this.tipSobe = tipSobe;
    }

    public int getBrojSobe() {
        return brojSobe;
    }

    public void setBrojSobe(int brojSobe) {
        this.brojSobe = brojSobe;
    }

    public boolean isZauzeta() {
        return zauzeta;
    }

    public void setZauzeta(boolean zauzeta) {
        this.zauzeta = zauzeta;
    }

    @Override
    public String toString() {
        return brojSobe + " " + tipSobe.getNazivTipaSobe();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
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
        final Soba other = (Soba) obj;
        if (this.brojSobe != other.brojSobe) {
            return false;
        }
        if (!Objects.equals(this.tipSobe, other.tipSobe)) {
            return false;
        }
        return true;
    }

    @Override
    public String vratiNazivTabele() {
        return " soba ";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return "";
    }

    @Override
    public String vratiUslov() {
        return " brSobe = "+getBrojSobe();
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        return " zauzeta = '" + zauzetLiJe() + "' ";
    }

    @Override
    public String vratiTabeluSaUslovomSpajanja() {
        return " JOIN tipsobe ON (tipsobe.tipSobeID=soba.tip) ";
    }

    @Override
    public OpstiDomenskiObjekat vratiObjekat(ResultSet rs) {
        return null;
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
        List<OpstiDomenskiObjekat> lista_soba = new LinkedList<>();
        try {

            while (rs.next()) {
                int id = rs.getInt("tipSobeID");
                String naziv = rs.getString("nazivTipaSobe");
                int brKreveta = rs.getInt("brKreveta");;
                double cenaPoOsobi = rs.getDouble("cenaPoOsobi");

                TipSobe ts = new TipSobe(id, naziv, brKreveta, cenaPoOsobi);

                int brSobe = rs.getInt("brSobe");
                boolean zauzeta = rs.getBoolean("zauzeta");
                Soba s = new Soba(brSobe, zauzeta, ts);
                lista_soba.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Soba.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista_soba;
    }

    @Override
    public String vratiKriterijumPretrage(String kriterijum) {
        if (kriterijum.equals("")) {
            return "";
        }
        return "WHERE brSobe LIKE '" + kriterijum + "%'";
    }

    @Override
    public void set(String nazivAtributa, Object vrednostAtributa) {

    }

    private String zauzetLiJe() {
        if (isZauzeta()) {
            return "1";

        } else {
            return "0";
        }
    }

}
