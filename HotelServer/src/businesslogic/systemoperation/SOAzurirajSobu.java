/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic.systemoperation;

import database.DBBroker;
import domen.Soba;

/**
 *
 * @author Marjan
 */
public class SOAzurirajSobu extends OpstaSO{

    public SOAzurirajSobu(DBBroker dbBroker) {
        super(dbBroker);
    }

    @Override
    protected void izvrsiOperaciju(Object object) throws Exception {
        Soba sb = (Soba) object;
        try {
            dbBroker.izmeni(sb);
        } catch (Exception e) {
            System.out.println("Greska kod izmene "+sb.getBrojSobe());
            throw new Exception("Sistem ne moze da azurira sobu");
            
        }
    }
    
}
