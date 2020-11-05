/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import domen.OpstiDomenskiObjekat;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marjan
 */
public class DBBroker {

    private Connection konekcija;

    public void ucitajDriver() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void otvoriKonekciju() {
        try {
            konekcija = Konekcija.vratiObjekat().vratiKonekciju();
        } catch (IOException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void zatvoriKonekciju() throws SQLException {
        konekcija.close();
    }

    public void commit() {
        try {
            konekcija.commit();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void rollback() {
        try {
            konekcija.rollback();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void sacuvaj(OpstiDomenskiObjekat odo) throws SQLException {
        String upit = "INSERT INTO " + odo.vratiNazivTabele() + " VALUES (" + odo.vratiVrednostiZaInsert() + ")";
        System.out.println("\n\n ************** \n" + upit);
        Statement st = konekcija.createStatement();
     st.executeUpdate(upit);
        //st.executeUpdate(upit);
        st.close();
    }

    public void obrisi(OpstiDomenskiObjekat odo) throws SQLException {
        String upit = "DELETE FROM " + odo.vratiNazivTabele() + " WHERE " + odo.vratiUslov();
        System.out.println("\n\n ************** \n" + upit);
        Statement st = konekcija.createStatement();
        st.executeUpdate(upit);
        st.close();
    }

    public void izmeni(OpstiDomenskiObjekat odo) throws SQLException {
        String upit = "UPDATE " + odo.vratiNazivTabele() + " SET " + odo.vratiVrednostiZaUpdate() + " WHERE " + odo.vratiUslov();
        System.out.println("\n\n ************** \n" + upit);
        Statement st = konekcija.createStatement();
        st.executeUpdate(upit);
        st.close();
    }

    public OpstiDomenskiObjekat pronadji(OpstiDomenskiObjekat odo) throws Exception {
        OpstiDomenskiObjekat objekat;

        String upit = "SELECT * FROM " + odo.vratiNazivTabele() + "" + odo.vratiTabeluSaUslovomSpajanja() + " WHERE " + odo.vratiUslov();
        System.out.println(upit);
        Statement st = konekcija.createStatement();
        ResultSet rs = st.executeQuery(upit);
        objekat = odo.vratiObjekat(rs);
        st.close();
        return objekat;
    }

    public int vratiMaksID(OpstiDomenskiObjekat odo) throws Exception {
        try {
            int maxID = -1;
            String upit = "SELECT max(" + odo.vratiZaMax() + ") as maks from " + odo.vratiNazivTabele();
            Statement st = konekcija.createStatement();
            ResultSet rs = st.executeQuery(upit);
            maxID = (int) odo.vratiID(rs);
            st.close();
            return maxID;
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("Sistem nije uspeo da vrati maksimalni ID za " + odo.vratiNazivTabele(), ex);
        }
    }

    public List<OpstiDomenskiObjekat> vratiSve(OpstiDomenskiObjekat odo) throws SQLException {

        List<OpstiDomenskiObjekat> idos = new ArrayList<>();
        String upit = "SELECT * FROM " + odo.vratiNazivTabele() + "" + odo.vratiTabeluSaUslovomSpajanja();
        System.out.println(upit);
        Statement st = konekcija.createStatement();
        ResultSet rs = st.executeQuery(upit);
        idos = odo.vratiListu(rs);
        st.close();
        return idos;
    }

    public List<OpstiDomenskiObjekat> vratiSaFilterom(String kriterijum, OpstiDomenskiObjekat odo) throws SQLException {
        List<OpstiDomenskiObjekat> idos = new ArrayList<>();

        String upit = "SELECT * FROM " + odo.vratiNazivTabele() + "" + odo.vratiTabeluSaUslovomSpajanja() + "" + odo.vratiKriterijumPretrage(kriterijum);
        System.out.println(upit);
        Statement st = konekcija.createStatement();
        ResultSet rs = st.executeQuery(upit);
        idos = odo.vratiListu(rs);
        st.close();
        return idos;

    }

}
