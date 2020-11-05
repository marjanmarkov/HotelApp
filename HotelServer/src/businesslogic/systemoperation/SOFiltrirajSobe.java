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
public class SOFiltrirajSobe extends OpstaSO {
    
    List<Soba> sobe;

    public SOFiltrirajSobe(DBBroker dbBroker) {
        super(dbBroker);
        sobe = new ArrayList<>();
    }
    
    @Override
    protected void izvrsiOperaciju(Object object) throws Exception {
        String parametri = (String) object;
        List<OpstiDomenskiObjekat> idos = dbBroker.vratiSaFilterom(parametri, new Soba());
        for (OpstiDomenskiObjekat ido : idos) {
            sobe.add((Soba) ido);
        }
    }
    
    public List<Soba> getSobe() {
        return sobe;
    }
    
}
