/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic.systemoperation;

import database.DBBroker;
import domen.IzdavanjeSobe;

/**
 *
 * @author Marjan
 */
public class SOAzurirajIzdavanjeSobe extends OpstaSO {

    public SOAzurirajIzdavanjeSobe(DBBroker dbBroker) {
        super(dbBroker);
    }

    @Override
    protected void izvrsiOperaciju(Object object) throws Exception {
        IzdavanjeSobe is = (IzdavanjeSobe) object;
        try {
            dbBroker.izmeni(is);
        } catch (Exception e) {
            System.out.println("Greska kod izmene izdavanja sobe" + is.getSoba().getBrojSobe()+ " "+is.getGost().getPrezime());
            throw new Exception("Sistem ne moze da azurira izdavanje sobe");

        }
    }

}
