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
public class SOObrisiGosta extends OpstaSO {

    public SOObrisiGosta(DBBroker dbBroker) {
        super(dbBroker);
    }

    @Override
    protected void izvrsiOperaciju(Object object) throws Exception {
        Gost gost = (Gost) object;
        try {
            dbBroker.obrisi(gost);

        } catch (Exception e) {
            System.out.println("Greska kod brisanja:" + gost.getGostID());
            new Exception("Sistem ne moze da obrise gosta");
        }

    }

}
