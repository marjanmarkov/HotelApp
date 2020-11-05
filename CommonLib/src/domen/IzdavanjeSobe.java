/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marjan
 */
public class IzdavanjeSobe implements OpstiDomenskiObjekat {

    private Gost gost;
    private Soba soba;
    private Date datumDolaska;
    //private Date datumOdlaska;
    private Recepcioner recepcioner;
    private boolean placeno;

    public IzdavanjeSobe() {
    }

    public IzdavanjeSobe(Gost gost, Soba soba, Date datumDolaska, Recepcioner recepcioner, boolean placeno) {
        this.gost = gost;
        this.soba = soba;
        this.datumDolaska = datumDolaska;
        this.recepcioner = recepcioner;
        this.placeno = placeno;
    }

//    public IzdavanjeSobe(Gost gost, Soba soba, Date datumDolaska, Date datumOdlaska, Recepcioner recepcioner) {
//        this.gost = gost;
//        this.soba = soba;
//        this.datumDolaska = datumDolaska;
//        this.datumOdlaska = datumOdlaska;
//        this.recepcioner = recepcioner;
//    }
    public Recepcioner getRecepcioner() {
        return recepcioner;
    }

    public void setRecepcioner(Recepcioner recepcioner) {
        this.recepcioner = recepcioner;
    }

    public Gost getGost() {
        return gost;
    }

    public void setGost(Gost gost) {
        this.gost = gost;
    }

    public Soba getSoba() {
        return soba;
    }

    public void setSoba(Soba soba) {
        this.soba = soba;
    }

    public Date getDatumDolaska() {
        return datumDolaska;
    }

    public void setDatumDolaska(Date datumDolaska) {
        this.datumDolaska = datumDolaska;
    }

    public boolean isPlaceno() {
        return placeno;
    }

    public void setPlaceno(boolean placeno) {
        this.placeno = placeno;
    }

//    public Date getDatumOdlaska() {
//        return datumOdlaska;
//    }
//
//    public void setDatumOdlaska(Date datumOdlaska) {
//        this.datumOdlaska = datumOdlaska;
//    }
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final IzdavanjeSobe other = (IzdavanjeSobe) obj;
//        if (!Objects.equals(this.gost, other.gost)) {
//            return false;
//        }
//        if (!Objects.equals(this.soba, other.soba)) {
//            return false;
//        }
//        if (!Objects.equals(this.datumDolaska, other.datumDolaska)) {
//            return false;
//        }
//        if (!Objects.equals(this.datumOdlaska, other.datumOdlaska)) {
//            return false;
//        }
//        return true;
//    }
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
        final IzdavanjeSobe other = (IzdavanjeSobe) obj;
        if (!Objects.equals(this.gost, other.gost)) {
            return false;
        }
        if (!Objects.equals(this.soba, other.soba)) {
            return false;
        }
        if (!Objects.equals(this.datumDolaska, other.datumDolaska)) {
            return false;
        }
        return true;
    }

    @Override
    public String vratiNazivTabele() {
        return " izdavanjesobe ";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return "'" + getGost().getGostID() + "','" + getSoba().getBrojSobe()
                + "','" + sdf.format(getDatumDolaska()) + "','" + getRecepcioner().getRecepcionerID() + "','" + placenoLiJe() + "'";
    }

    @Override
    public String vratiUslov() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return "gostID = '" + getGost().getGostID() + "' AND brSobe = '" + getSoba().getBrojSobe() + "' AND datumDolaska='" + sdf.format(getDatumDolaska()) + "'";
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        return " placeno = '"+placenoLiJe()+"'";

    }

    @Override
    public String vratiTabeluSaUslovomSpajanja() {
        return " JOIN gost ON (gost.gostID=izdavanjesobe.gostID) JOIN recepcioner ON (recepcioner.recepcionerID=izdavanjesobe.recepcionerID) JOIN soba ON (soba.brSobe=izdavanjesobe.brSobe)  JOIN tipsobe ON (tipsobe.tipSobeID=soba.tip)";
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
//pazi na datum odlaska NULL JE

    @Override
    public List<OpstiDomenskiObjekat> vratiListu(ResultSet rs) {
        List<OpstiDomenskiObjekat> lista_izdavanja = new LinkedList<>();
        try {
            while (rs.next()) {
                int id = rs.getInt("gostID");
                String i = rs.getString("ime");
                String p = rs.getString("prezime");
                String bt = rs.getString("brTel");
                boolean s = rs.getBoolean("smesten");
                Gost g = new Gost(id, i, p, bt, s);

                int idts = rs.getInt("tipSobeID");
                String naziv = rs.getString("nazivTipaSobe");
                int brKreveta = rs.getInt("brKreveta");;
                double cenaPoOsobi = rs.getDouble("cenaPoOsobi");

                TipSobe ts = new TipSobe(idts, naziv, brKreveta, cenaPoOsobi);

                int brSobe = rs.getInt("brSobe");
                boolean zauzeta = rs.getBoolean("zauzeta");
                Soba sob = new Soba(brSobe, zauzeta, ts);

                int idr = rs.getInt("recepcionerID");
                String ime = rs.getString("ime");
                String prezime = rs.getString("prezime");
                String user = rs.getString("korisnickoIme");
                String pass = rs.getString("sifra");

                Recepcioner r = new Recepcioner(idr, ime, prezime, user, pass);

                Date datumDolask = new Date(rs.getDate("datumDolaska").getTime());
                boolean placen = rs.getBoolean("placeno");

                //PAZI
                IzdavanjeSobe is = new IzdavanjeSobe(g, sob, datumDolask, r, placen);
                lista_izdavanja.add(is);
            }
        } catch (SQLException ex) {
            Logger.getLogger(IzdavanjeSobe.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista_izdavanja;

    }

    @Override
    public String vratiKriterijumPretrage(String kriterijum) {
        if (kriterijum.equals("")) {
            return "";
        }
        return " WHERE brSobe = '" + kriterijum + "'";
    }

    @Override
    public void set(String nazivAtributa, Object vrednostAtributa) {
    }

    private String placenoLiJe() {
        if (isPlaceno()) {
            return "1";
        } else {
            return "0";
        }
    }

}
