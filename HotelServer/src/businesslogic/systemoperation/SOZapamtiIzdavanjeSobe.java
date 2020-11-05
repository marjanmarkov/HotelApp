/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic.systemoperation;

import database.DBBroker;
import domen.IzdavanjeSobe;

/**
 *
 * @author Marjan
 */
public class SOZapamtiIzdavanjeSobe extends OpstaSO {
    
    public SOZapamtiIzdavanjeSobe(DBBroker dbBroker) {
        super(dbBroker);
    }
    
    @Override
    protected void izvrsiOperaciju(Object object) throws Exception {
        IzdavanjeSobe izdavanje = (IzdavanjeSobe) object;
        try {
            dbBroker.sacuvaj(izdavanje);
        } catch (Exception e) {
            System.out.println("Greska kod cuvanja izdavanja sobe" + izdavanje.getSoba().getBrojSobe() + "sa gostom " + izdavanje.getGost().getIme() + " " + izdavanje.getGost().getPrezime());            
            throw new Exception("Sistem ne moze da zapamti izdavanje sobe");
        }
    }
    
}
