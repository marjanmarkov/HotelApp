/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Recepcioner;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Marjan
 */
public class ModelTabeleRecepcioner extends AbstractTableModel {

    List<Recepcioner> listaRecepcionera;

    String[] nazivKolona = {"Ime", "Prezime", "Username", "Status"};

    public ModelTabeleRecepcioner(List<Recepcioner> listaRecepcionera) {
        this.listaRecepcionera = listaRecepcionera;
    }

    public ModelTabeleRecepcioner() {
        this.listaRecepcionera = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        if (listaRecepcionera == null) {
            return 0;
        } else {
            return listaRecepcionera.size();
        }

    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Recepcioner r = listaRecepcionera.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return r.getIme();
            case 1:
                return r.getPrezime();
            case 2:
                return r.getKorisnickoIme();
            case 3:
                return r.getStatus();
            default:
                return "N/A";
        }

    }

    @Override
    public String getColumnName(int column) {
        return nazivKolona[column];
    }

}
