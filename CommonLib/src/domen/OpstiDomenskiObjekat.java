/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Marjan
 */
public interface OpstiDomenskiObjekat extends Serializable {

    public String vratiNazivTabele();

    public String vratiVrednostiZaInsert();

    public String vratiUslov();

    public String vratiVrednostiZaUpdate();

    public String vratiTabeluSaUslovomSpajanja();

    public OpstiDomenskiObjekat vratiObjekat(ResultSet rs);

    public String vratiZaMax();

    public int vratiID(ResultSet rs);

    public List<OpstiDomenskiObjekat> vratiListu(ResultSet rs);

    public String vratiKriterijumPretrage(String kriterijum);

    public void set(String nazivAtributa, Object vrednostAtributa);

}
