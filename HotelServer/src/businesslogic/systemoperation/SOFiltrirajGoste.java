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
public class SOFiltrirajGoste extends OpstaSO {

    List<Gost> gosti;

    public SOFiltrirajGoste(DBBroker dbBroker) {
        super(dbBroker);
        gosti = new ArrayList<>();
    }

    @Override
    protected void izvrsiOperaciju(Object object) throws Exception {
        String parametri = (String) object;
        List<OpstiDomenskiObjekat> idos = dbBroker.vratiSaFilterom(parametri, new Gost());
        for (OpstiDomenskiObjekat ido : idos) {
            gosti.add((Gost) ido);

        }
    }

    public List<Gost> getGosti() {
        return gosti;
    }

}
