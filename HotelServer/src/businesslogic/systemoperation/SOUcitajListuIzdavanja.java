/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic.systemoperation;

import database.DBBroker;
import domen.IzdavanjeSobe;
import domen.OpstiDomenskiObjekat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marjan
 */
public class SOUcitajListuIzdavanja extends OpstaSO {

    List<IzdavanjeSobe> izdavanja;

    public SOUcitajListuIzdavanja(DBBroker dbBroker) {
        super(dbBroker);
        izdavanja = new ArrayList<>();
    }

    public List<IzdavanjeSobe> getIzdavanja() {
        return izdavanja;
    }

    
    @Override
    protected void izvrsiOperaciju(Object object) throws Exception {
        List<OpstiDomenskiObjekat> idos = dbBroker.vratiSve(new IzdavanjeSobe());
        for (OpstiDomenskiObjekat ido : idos) {
            izdavanja.add((IzdavanjeSobe) ido);
        }


    }

}
