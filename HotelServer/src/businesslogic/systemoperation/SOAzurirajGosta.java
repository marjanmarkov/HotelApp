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
public class SOAzurirajGosta extends OpstaSO {

    public SOAzurirajGosta(DBBroker dbBroker) {
        super(dbBroker);
    }

    @Override
    protected void izvrsiOperaciju(Object object) throws Exception {
        Gost gs = (Gost) object;
        try {
            dbBroker.izmeni(gs);

        } catch (Exception e) {
            System.out.println("Greska kod izmene" + e.getMessage());
            throw new Exception("Sistem ne moze da azurira gosta!");
        }
    }

}
