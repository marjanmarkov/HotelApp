/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic.systemoperation;

import database.DBBroker;
import domen.Gost;
import domen.OpstiDomenskiObjekat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marjan
 */
public class SOVratiGoste extends OpstaSO{

    List<Gost> gosti;
    
    public SOVratiGoste(DBBroker dbBroker) {
        super(dbBroker);
        gosti = new ArrayList<>();
    }

    public List<Gost> getGosti() {
        return gosti;
    }
    
    @Override
    protected void izvrsiOperaciju(Object object) throws Exception {
        List<OpstiDomenskiObjekat> idos = dbBroker.vratiSve(new Gost());
        for (OpstiDomenskiObjekat ido : idos) {
            gosti.add((Gost) ido);
        }
    }
    
}
