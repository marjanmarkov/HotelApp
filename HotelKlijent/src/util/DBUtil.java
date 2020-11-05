/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
        properties.load(new FileInputStream("klijent.config"));

    }

    public String vratiIPAdresu() {
        return properties.getProperty(DBKonstanta.ADRESA);
    }

    public String vratiPort() {
        return properties.getProperty(DBKonstanta.PORT);
    }

    public void setIPAdresa(String adresa) throws FileNotFoundException, IOException {
        properties.setProperty("adresa", adresa);
        properties.store(new FileOutputStream(new File("klijent.config")), null);
    }

    public void setPort(int port) throws FileNotFoundException, IOException {
        properties.setProperty("port", port + "");
        properties.store(new FileOutputStream(new File("klijent.config")), null);

    }

}
