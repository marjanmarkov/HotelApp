/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 *
 * @author Marjan
 */
public class StavkaRacuna implements OpstiDomenskiObjekat {

    private Racun racun;
    private int redniBroj;
    private IzdavanjeSobe izdavanjeSobe;
    private double iznosStavke;

    public StavkaRacuna() {
    }

    public StavkaRacuna(Racun racun, int redniBroj, IzdavanjeSobe izdavanjeSobe) {
        this.racun = racun;
        this.redniBroj = redniBroj;
        this.izdavanjeSobe = izdavanjeSobe;
    }

    public IzdavanjeSobe getIzdavanjeSobe() {
        return izdavanjeSobe;
    }

    public void setIzdavanjeSobe(IzdavanjeSobe izdavanjeSobe) {
        this.izdavanjeSobe = izdavanjeSobe;
    }

    public Racun getRacun() {
        return racun;
    }

    public void setRacun(Racun racun) {
        this.racun = racun;
    }

    public int getRedniBroj() {
        return redniBroj;
    }

    public void setRedniBroj(int redniBroj) {
        this.redniBroj = redniBroj;
    }

    public double getIznosStavke() {
        return iznosStavke;
    }

    public void setIznosStavke(double iznosStavke) {
        this.iznosStavke = iznosStavke;
    }

    @Override
    public String vratiNazivTabele() {
        return "stavkaracuna";

    }

    @Override
    public String vratiVrednostiZaInsert() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        return "'" + getRacun().getRacunID() + "','" + getRedniBroj()
                + "','" + getIzdavanjeSobe().getGost().getGostID() + "','"
                + getIzdavanjeSobe().getSoba().getBrojSobe() + "','"
                + sdf.format(getIzdavanjeSobe().getDatumDolaska()) + "'";
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
