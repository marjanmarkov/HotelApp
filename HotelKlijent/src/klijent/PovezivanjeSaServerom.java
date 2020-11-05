/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package klijent;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import session.Session;

/**
 *
 * @author Marjan
 */
public class PovezivanjeSaServerom {

    Socket socket;

    public boolean poveziSeSaServerom(String adresa, int port) throws IOException {
        try {
            socket = new Socket(adresa, port);
            System.out.println("Klijent se povezao sa serverom");
            Session.getInstanca().setSocket(socket);
            return true;
        } catch (IOException ex) {
//            Logger.getLogger(PovezivanjeSaServerom.class.getName()).log(Level.SEVERE, null, ex);
            return false;

        }
    }
}
