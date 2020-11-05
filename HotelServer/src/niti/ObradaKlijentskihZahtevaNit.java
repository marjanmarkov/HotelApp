/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import domen.Gost;
import domen.IzdavanjeSobe;
import domen.Racun;
import domen.Recepcioner;
import domen.Soba;
import forme.FGlavna;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logika.Kontroler;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;
import util.EnumResponseStatus;
import util.Operacije;

/**
 *
 * @author Marjan
 */
public class ObradaKlijentskihZahtevaNit extends Thread {

    Socket s;
    FGlavna fg;

    public ObradaKlijentskihZahtevaNit(Socket s, FGlavna fg) {
        this.s = s;
        this.fg = fg;
    }

    @Override
    public void run() {
        try {
            obradiKlijenta(s);
        } catch (IOException ex) {
            Logger.getLogger(ObradaKlijentskihZahtevaNit.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ObradaKlijentskihZahtevaNit.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void obradiKlijenta(Socket s) throws IOException, ClassNotFoundException {
        while (true) {
            System.out.println("Cekam klijentski zahtev");
            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
            Object object = ois.readObject();
            KlijentskiZahtev kz = (KlijentskiZahtev) object;

            ServerskiOdgovor so = obradiZahtev(kz);
            ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
            oos.writeObject(so);
            oos.flush();
        }

    }

    private ServerskiOdgovor obradiZahtev(KlijentskiZahtev kz) {
        ServerskiOdgovor so = new ServerskiOdgovor();

        int operacija = kz.getOperacija();
        switch (operacija) {
//1            
            case Operacije.NADJI_RECEPCIONERA:
                try {
                    Recepcioner r = Kontroler.getInstanca().nadjiRecepcionera(kz.getParametar());
                    so.setParametar(r);
                } catch (Exception e) {
                    so.setPoruka(e.getMessage());
                }
                return so;
//2
            case Operacije.LOGIN:
                try {
                    Recepcioner r = (Recepcioner) kz.getParametar();
                    if (Kontroler.getInstanca().loginRecepcionera(r)) {
                        so.setPoruka("Uspesno ste se logovali!");
                        fg.srediTabelu();
                        so.setResponseStatus(EnumResponseStatus.OK);
                    } else {
                        so.setPoruka("Recepcioner sa tim podacima je vec ulogovan!");
                        so.setResponseStatus(EnumResponseStatus.ERROR);
                    }
                } catch (Exception e) {
                    so.setPoruka(e.getMessage());
                }
                return so;
//3
            case Operacije.SACUVAJ_GOSTA:
                Gost g = (Gost) kz.getParametar();

                try {
                    Kontroler.getInstanca().sacuvajGosta(g);
                    so.setResponseStatus(EnumResponseStatus.OK);
                } catch (Exception e) {
                    so.setPoruka(e.getMessage());
                    so.setResponseStatus(EnumResponseStatus.ERROR);

                }
                return so;
//4
            case Operacije.VRATI_MAX_ID_GOSTA:
                try {
                    int id = Kontroler.getInstanca().vratiMaxIDGosta();
                    so.setParametar(id);
                } catch (Exception e) {
                    so.setPoruka(e.getMessage());
                }
                return so;
//5                
            case Operacije.VRATI_SVE_GOSTE:
                try {
                    List<Gost> gosti = Kontroler.getInstanca().vratiGoste();
                    so.setParametar(gosti);
                } catch (Exception ex) {
                    so.setPoruka(ex.getMessage());
                }
                return so;
//6
            case Operacije.VRATI_GOSTE_FILTER:
                try {
                    List<Gost> gostiFilter = Kontroler.getInstanca().vratiGosteFilter(kz.getParametar());
                    so.setParametar(gostiFilter);
                } catch (Exception ex) {
                    so.setPoruka(ex.getMessage());
                }
                return so;
//7
            case Operacije.OBRISI_GOSTA:
                Gost gBrisanje = (Gost) kz.getParametar();
                 {
                    try {
                        Kontroler.getInstanca().obrisiGosta(gBrisanje);
                        so.setResponseStatus(EnumResponseStatus.OK);

                    } catch (Exception ex) {
                        so.setPoruka(ex.getMessage());
                        so.setResponseStatus(EnumResponseStatus.ERROR);
                        Logger.getLogger(ObradaKlijentskihZahtevaNit.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                return so;
//8
            case Operacije.NADJI_GOSTA: {
                try {
                    Gost pronadjeniGost = Kontroler.getInstanca().nadjiGosta(kz.getParametar());
                    so.setParametar(pronadjeniGost);
                } catch (Exception ex) {
                    so.setPoruka(ex.getMessage());
                }
            }
            return so;

//9
            case Operacije.IZMENI_GOSTA:
                Gost izmeniGost = (Gost) kz.getParametar();

                try {
                    Kontroler.getInstanca().izmeniGosta(izmeniGost);
                    so.setResponseStatus(EnumResponseStatus.OK);
                } catch (Exception ex) {
                    so.setPoruka(ex.getMessage());
                    so.setResponseStatus(EnumResponseStatus.ERROR);
                    Logger.getLogger(ObradaKlijentskihZahtevaNit.class.getName()).log(Level.SEVERE, null, ex);
                }

                return so;
//10

            case Operacije.LOGOUT: {
                try {
                    Recepcioner r = (Recepcioner) kz.getParametar();

                    if (Kontroler.getInstanca().logoutRecepcionera(r)) {
                        so.setPoruka("Uspesno ste se odjavili sa sistema!");
                        fg.srediTabelu();
                        so.setResponseStatus(EnumResponseStatus.OK);
                    } else {
                        so.setPoruka("Doslo je do greske prilikom odjave!");
                        so.setResponseStatus(EnumResponseStatus.ERROR);
                    }
                } catch (Exception ex) {
                    so.setPoruka(ex.getMessage());
                }
            }
            return so;
//11
            case Operacije.VRATIS_SVE_SOBE:
                try {
                    List<Soba> sobe = Kontroler.getInstanca().vratiSobe();
                    so.setParametar(sobe);
                } catch (Exception ex) {
                    so.setPoruka(ex.getMessage());
                }
                return so;
//12
            case Operacije.VRATI_SOBE_FILTER:
                try {
                    List<Soba> sobeFilter = Kontroler.getInstanca().vratiSobeFilter(kz.getParametar());
                    so.setParametar(sobeFilter);
                } catch (Exception ex) {
                    so.setPoruka(ex.getMessage());
                }
                return so;
//13
            case Operacije.VRATI_SVA_IZDAVANJA: {
                try {
                    List<IzdavanjeSobe> izdavanjaSva = Kontroler.getInstanca().vratiIzdavanja();
                    so.setParametar(izdavanjaSva);
                } catch (Exception ex) {
                    Logger.getLogger(ObradaKlijentskihZahtevaNit.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return so;
//14
            case Operacije.SACUVAJ_IZDAVANJE:
                IzdavanjeSobe iS = (IzdavanjeSobe) kz.getParametar();

                try {
                    Kontroler.getInstanca().sacuvajIzdavanje(iS);
                    so.setResponseStatus(EnumResponseStatus.OK);
                } catch (Exception ex) {
                    so.setPoruka(ex.getMessage());
                    so.setResponseStatus(EnumResponseStatus.ERROR);
                    Logger.getLogger(ObradaKlijentskihZahtevaNit.class.getName()).log(Level.SEVERE, null, ex);
                }

                return so;

//15
            case Operacije.IZMENI_SOBU:
                Soba izmeniSoba = (Soba) kz.getParametar();

                try {
                    Kontroler.getInstanca().izmeniSobu(izmeniSoba);
                    so.setResponseStatus(EnumResponseStatus.OK);
                } catch (Exception ex) {
                    so.setPoruka(ex.getMessage());
                    so.setResponseStatus(EnumResponseStatus.ERROR);
                    Logger.getLogger(ObradaKlijentskihZahtevaNit.class.getName()).log(Level.SEVERE, null, ex);
                }
                return so;

//16 
            

            case Operacije.VRATI_MAX_ID_RACUNA:
                try {
                    int id = Kontroler.getInstanca().vratiMaxIDRacuna();
                    so.setParametar(id);
                } catch (Exception e) {
                    so.setPoruka(e.getMessage());
                }

                return so;
//17
            case Operacije.SACUVAJ_RACUN:
                Racun r = (Racun) kz.getParametar();

                try {
                    Kontroler.getInstanca().sacuvajRacun(r);
                    so.setResponseStatus(EnumResponseStatus.OK);
                } catch (Exception ex) {
                    so.setPoruka(ex.getMessage());
                    so.setResponseStatus(EnumResponseStatus.ERROR);
                    Logger.getLogger(ObradaKlijentskihZahtevaNit.class.getName()).log(Level.SEVERE, null, ex);
                }
                return so;

//18              
            case Operacije.IZMENI_IZDAVANJE_SOBE:
                IzdavanjeSobe izmeniIzdavanje = (IzdavanjeSobe) kz.getParametar();

                try {
                    Kontroler.getInstanca().izmeniIzdavanje(izmeniIzdavanje);
                    so.setResponseStatus(EnumResponseStatus.OK);
                } catch (Exception ex) {
                    so.setPoruka(ex.getMessage());
                    so.setResponseStatus(EnumResponseStatus.ERROR);
                    Logger.getLogger(ObradaKlijentskihZahtevaNit.class.getName()).log(Level.SEVERE, null, ex);
                }
                return so;


            default:
                return so;
        }

    }

}
