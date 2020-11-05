/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer;

import java.io.Serializable;
import util.EnumResponseStatus;

/**
 *
 * @author Marjan
 */
public class ServerskiOdgovor implements Serializable{
    private String poruka;
    private Exception izuzetak;
    private Object parametar;
    private EnumResponseStatus responseStatus;

    public ServerskiOdgovor() {
    }

    public ServerskiOdgovor(String poruka, Exception izuzetak, Object parametar, EnumResponseStatus responseStatus) {
        this.poruka = poruka;
        this.izuzetak = izuzetak;
        this.parametar = parametar;
        this.responseStatus = responseStatus;
    }

    public EnumResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(EnumResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    public String getPoruka() {
        return poruka;
    }

    public void setPoruka(String poruka) {
        this.poruka = poruka;
    }

    public Exception getIzuzetak() {
        return izuzetak;
    }

    public void setIzuzetak(Exception izuzetak) {
        this.izuzetak = izuzetak;
    }

    public Object getParametar() {
        return parametar;
    }

    public void setParametar(Object parametar) {
        this.parametar = parametar;
    }
    
    
    
}
