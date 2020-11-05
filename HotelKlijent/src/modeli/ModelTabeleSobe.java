/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Gost;
import domen.Soba;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Marjan
 */
public class ModelTabeleSobe extends AbstractTableModel {

    List<Soba> listaSoba;
    String[] nazivKolona = {"Broj sobe", "Zauzeta", "Tip sobe"};

    public ModelTabeleSobe(List<Soba> listaSoba) {
        this.listaSoba = listaSoba;
    }

    @Override
    public int getRowCount() {
        if (listaSoba == null) {
            return 0;
        } else {
            return listaSoba.size();
        }
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Soba s = listaSoba.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return s.getBrojSobe();
            case 1:
                return s.isZauzeta();
            case 2:
                return s.getTipSobe().getNazivTipaSobe();
            default:
                return "N/A";
        }
    }

    @Override
    public String getColumnName(int column) {
        return nazivKolona[column];
    }

    
    public Soba vratiSobu(int red) {
        return listaSoba.get(red);
    }

    
}
