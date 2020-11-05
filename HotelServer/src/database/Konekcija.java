/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import util.DBUtil;

/**
 *
 * @author Marjan
 */
public class Konekcija {

    private static Konekcija objekat;
    private Connection konekcija;

    private Konekcija() throws IOException, SQLException {
        
        DBUtil dbUtil = new DBUtil();
        String url = dbUtil.vratiDBURL();
        String user = dbUtil.vratiDBKorisnik();
        String password = dbUtil.vratiDBSifra();
        konekcija = DriverManager.getConnection(url, user, password);
        konekcija.setAutoCommit(false);

    }

    public Connection vratiKonekciju() {
        return konekcija;
    }

    public static Konekcija vratiObjekat() throws IOException, SQLException {
        if (objekat == null) {
            objekat = new Konekcija();
        }

        return objekat;
    }

}
