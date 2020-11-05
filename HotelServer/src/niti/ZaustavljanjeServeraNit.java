/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.logging.Level;
import java.util.logging.Logger;
import server.PokretanjeServeraNit;

/**
 *
 * @author Marjan
 */
public class ZaustavljanjeServeraNit extends Thread {

    ServerSocket ss;
    PokretanjeServeraNit ps;
    boolean kraj = false;

    public ZaustavljanjeServeraNit(ServerSocket ss, PokretanjeServeraNit ps) {
        this.ss = ss;
        this.ps = ps;
    }

    @Override
    public void run() {
        while (!kraj) {
            if (ps.isInterrupted()) {
                try {
                    ss.close();
                    kraj = true;
                } catch (IOException ex) {
                    Logger.getLogger(ZaustavljanjeServeraNit.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ZaustavljanjeServeraNit.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
