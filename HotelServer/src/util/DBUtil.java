/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Marjan
 */
public class DBUtil {

    Properties properties;

    public DBUtil() throws FileNotFoundException, IOException {
        properties = new Properties();
        properties.load(new FileInputStream("db.config"));
    }

    public String vratiDBURL() {
        return properties.getProperty(DBKonstante.URL);
    }

    public String vratiDBKorisnik() {
        return properties.getProperty(DBKonstante.USER);
    }

    public String vratiDBSifra() {
        return properties.getProperty(DBKonstante.PASSWORD);
    }

    public String vratiPort() {
        return properties.getProperty(DBKonstante.PORT);
    }

    public void setPort(int port) throws IOException {
        properties.setProperty("port", port + "");
        properties.store(new FileOutputStream(new File("db.config")), null);

    }

    public void setUrl(String url) throws IOException {
        properties.setProperty("url", url);
//        BufferedWriter bfw= new BufferedWriter(new FileWriter("db.config"));
//        bfw.write(url);
        properties.store(new FileOutputStream(new File("db.config")), null);
    }

    public void setUser(String user) throws IOException {
        properties.setProperty("user", user);
        properties.store(new FileOutputStream(new File("db.config")), null);
    }

    public void setPassword(String password) throws IOException {
        properties.setProperty("password", password);
        properties.store(new FileOutputStream(new File("db.config")), null);
    }
}
