/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic.systemoperation;

import database.DBBroker;
import domen.Gost;

/**
 *
 * @author Marjan
 */
public class SOZapamtiGosta extends OpstaSO {

    public SOZapamtiGosta(DBBroker dbBroker) {
        super(dbBroker);
    }

    @Override
    protected void izvrsiOperaciju(Object object) throws Exception {
        Gost gost = (Gost) object;
        try {
            dbBroker.sacuvaj(gost);
        } catch (Exception e) {
            System.out.println("greska kod cuvanja:" + gost.getIme()
                    + "" + e.getMessage());
            throw new Exception("Sistem ne moze da zapamti gosta");
        }

    }

}
