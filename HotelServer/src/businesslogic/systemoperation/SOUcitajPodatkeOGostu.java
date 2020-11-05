/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic.systemoperation;

import database.DBBroker;
import domen.Gost;
import domen.OpstiDomenskiObjekat;

/**
 *
 * @author Marjan
 */
public class SOUcitajPodatkeOGostu extends OpstaSO{

    Gost gost;
    public SOUcitajPodatkeOGostu(DBBroker dbBroker) {
        super(dbBroker);
    }

    public Gost getGost() {
        return gost;
    }
    

    @Override
    protected void izvrsiOperaciju(Object object) throws Exception {
        gost = (Gost) dbBroker.pronadji((OpstiDomenskiObjekat) object);
        
    }
    
}
