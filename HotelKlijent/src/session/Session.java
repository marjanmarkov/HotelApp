/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import java.net.Socket;

/**
 *
 * @author Marjan
 */
public class Session {

    private Socket socket;
    private static Session instanca;

    public Session() {
    }

    public static Session getInstanca() {
        if (instanca == null) {
            instanca = new Session();
        }
        return instanca;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }



    
}
