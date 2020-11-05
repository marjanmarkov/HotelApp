/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import forme.FGlavna;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import niti.ObradaKlijentskihZahtevaNit;
import niti.ZaustavljanjeServeraNit;

/**
 *
 * @author Marjan
 */
public class PokretanjeServeraNit extends Thread {

    FGlavna sf;
    int port;

    public PokretanjeServeraNit(FGlavna sf, int port) {
        this.sf = sf;
        this.port = port;
    }

    @Override
    public void run() {
        try {
            ServerSocket ss = new ServerSocket(9000);
            ZaustavljanjeServeraNit zsn = new ZaustavljanjeServeraNit(ss, this);
            zsn.start();
            System.out.println("Server je pokrenut!\nCekam klijente.");
            while (true) {
                Socket s = ss.accept();
                System.out.println("Klijent se povezao");
                ObradaKlijentskihZahtevaNit okzn = new ObradaKlijentskihZahtevaNit(s, sf);
                new Thread(okzn).start();
            }
        } catch (IOException ex) {
//            Logger.getLogger(PokretanjeServeraNit.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Soket je zatvoren");
        }

    }

}
