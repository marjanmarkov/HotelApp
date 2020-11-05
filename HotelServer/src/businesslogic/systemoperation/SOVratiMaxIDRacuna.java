/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic.systemoperation;

import database.DBBroker;
import domen.Racun;

/**
 *
 * @author Marjan
 */
public class SOVratiMaxIDRacuna extends OpstaSO{

    int id;
    
    public SOVratiMaxIDRacuna(DBBroker dbBroker) {
        super(dbBroker);
    }

    public int getId() {
        return id;
    }

    
    @Override
    protected void izvrsiOperaciju(Object object) throws Exception {
        id = dbBroker.vratiMaksID(new Racun());
    }
    
}
