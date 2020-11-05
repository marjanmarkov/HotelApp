/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic.systemoperation;

import database.DBBroker;
import java.sql.SQLException;

/**
 *
 * @author Marjan
 */
public abstract class OpstaSO {

    protected DBBroker dbBroker;

    public OpstaSO(DBBroker dbBroker) {
        this.dbBroker = dbBroker;
    }

    public void execute(Object object) throws Exception {
        try {
            dbBroker.ucitajDriver();
            dbBroker.otvoriKonekciju();
            izvrsiOperaciju(object);
            dbBroker.commit();
        } catch (Exception e) {
            dbBroker.rollback();
            throw e;
        }
    }

    protected abstract void izvrsiOperaciju(Object object) throws Exception;

    private void zatvoriKonekciju() throws SQLException {
        dbBroker.zatvoriKonekciju();
    }

}
