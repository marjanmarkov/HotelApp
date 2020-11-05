/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic.systemoperation;

import database.DBBroker;
import domen.OpstiDomenskiObjekat;
import domen.Recepcioner;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marjan
 */
public class SOUcitajListuRecepcionera extends OpstaSO{

    List<Recepcioner> recepcioneri;
    
    public SOUcitajListuRecepcionera(DBBroker dbBroker) {
        super(dbBroker);
        recepcioneri = new ArrayList<>();
        
    }

    public List<Recepcioner> getRecepcioneri() {
        return recepcioneri;
    }

    @Override
    protected void izvrsiOperaciju(Object object) throws Exception {
        List<OpstiDomenskiObjekat> idos = dbBroker.vratiSve((OpstiDomenskiObjekat) new Recepcioner());
        for (OpstiDomenskiObjekat ido : idos) {
            recepcioneri.add((Recepcioner) ido);
        }
    }
    
}
