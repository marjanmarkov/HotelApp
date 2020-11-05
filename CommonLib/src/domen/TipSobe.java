/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Marjan
 */
public class TipSobe implements OpstiDomenskiObjekat {

    private int tipSobeID;
    private String nazivTipaSobe;
    private int brojKreveta;
    private double cenaPoOsobi;

    public TipSobe() {
    }

    public TipSobe(int tipSobeID, String nazivTipaSobe, int brojKreveta, double cenaPoOsobi) {
        this.tipSobeID = tipSobeID;
        this.nazivTipaSobe = nazivTipaSobe;
        this.brojKreveta = brojKreveta;
        this.cenaPoOsobi = cenaPoOsobi;
    }

    public double getCenaPoOsobi() {
        return cenaPoOsobi;
    }

    public void setCenaPoOsobi(double cenaPoOsobi) {
        this.cenaPoOsobi = cenaPoOsobi;
    }

    public int getTipSobeID() {
        return tipSobeID;
    }

    public void setTipSobeID(int tipSobeID) {
        this.tipSobeID = tipSobeID;
    }

    public String getNazivTipaSobe() {
        return nazivTipaSobe;
    }

    public void setNazivTipaSobe(String nazivTipaSobe) {
        this.nazivTipaSobe = nazivTipaSobe;
    }

    public int getBrojKreveta() {
        return brojKreveta;
    }

    public void setBrojKreveta(int brojKreveta) {
        this.brojKreveta = brojKreveta;
    }

    @Override
    public String vratiNazivTabele() {
        return "tipsobe";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return "";
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
        return "";
    }

    @Override
    public int vratiID(ResultSet rs) {
        return 0;
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
