/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic.systemoperation;

import database.DBBroker;
import domen.OpstiDomenskiObjekat;
import domen.Recepcioner;

/**
 *
 * @author Marjan
 */
public class SOPronadjiRecepcionera extends OpstaSO{
    Recepcioner recepcioner;

    public SOPronadjiRecepcionera(DBBroker dbBroker) {
        super(dbBroker);
    }

    public Recepcioner getRecepcioner() {
        return recepcioner;
    }
    
    

    @Override
    protected void izvrsiOperaciju(Object object) throws Exception {
       recepcioner = (Recepcioner) dbBroker.pronadji((OpstiDomenskiObjekat) object);
    }
    
}
