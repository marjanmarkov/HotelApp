/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic.systemoperation;

import database.DBBroker;
import domen.OpstiDomenskiObjekat;
import domen.Soba;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marjan
 */
public class SOVratiSobe extends OpstaSO {

    List<Soba> sobe;

    public SOVratiSobe(DBBroker dbBroker) {
        super(dbBroker);
        sobe = new ArrayList<>();
        
    }

    public List<Soba> getSobe() {
        return sobe;
    }

    @Override
    protected void izvrsiOperaciju(Object object) throws Exception {
        List<OpstiDomenskiObjekat> idos = dbBroker.vratiSve(new Soba());
        for (OpstiDomenskiObjekat ido : idos) {
            sobe.add((Soba) ido);
        }
    }

}
