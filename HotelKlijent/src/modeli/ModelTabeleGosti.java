/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Gost;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Marjan
 */
public class ModelTabeleGosti extends AbstractTableModel {

    List<Gost> listaGostiju;
    String[] naziviKolona = {"Ime", "Prezime", "Broj Telefona", "Smesten"};

    public ModelTabeleGosti(List<Gost> listaGostiju) {
        this.listaGostiju = listaGostiju;
    }

    @Override
    public int getRowCount() {
        if (listaGostiju == null) {
            return 0;
        } else {
            return listaGostiju.size();
        }
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Gost g = listaGostiju.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return g.getIme();
            case 1:
                return g.getPrezime();
            case 2:
                return g.getBrTel();
            case 3:
                return g.isSmesten();
            default:
                return "N/A";
        }

    }

    @Override
    public String getColumnName(int column) {
        return naziviKolona[column];
    }

    public void obrisiGosta(int red) {
        listaGostiju.remove(red);
        fireTableDataChanged();

    }

    public Gost vratiGosta(int red) {
        return listaGostiju.get(red);
    }

}
