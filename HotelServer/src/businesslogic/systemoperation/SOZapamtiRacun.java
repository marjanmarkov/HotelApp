/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic.systemoperation;

import database.DBBroker;
import domen.Racun;
import domen.StavkaRacuna;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marjan
 */
public class SOZapamtiRacun extends OpstaSO {

    public SOZapamtiRacun(DBBroker dbBroker) {
        super(dbBroker);
    }

    @Override
    protected void izvrsiOperaciju(Object object) throws Exception {
        Racun racun = (Racun) object;
        try {
            dbBroker.sacuvaj(racun);
            for (int i = 0; i < racun.getStavkeRacuna().size(); i++) {
                StavkaRacuna stavkaRac = racun.getStavkeRacuna().get(i);
                stavkaRac.setRacun(racun);
                dbBroker.sacuvaj(stavkaRac);
            }
        } catch (SQLException ex) {
            System.out.println("greska kod cuvanja"+racun.getRacunID());
            throw new Exception("Sistem ne moze da zapamti racun!");
        }

    }

}
