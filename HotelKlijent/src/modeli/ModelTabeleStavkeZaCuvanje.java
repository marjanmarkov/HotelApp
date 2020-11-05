/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.StavkaRacuna;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Marjan
 */
public class ModelTabeleStavkeZaCuvanje extends AbstractTableModel {

    List<StavkaRacuna> listaStavkiZaCuvanje;
    String[] naziviKolona = {"Redni broj","Gost","Cena"};
            

    public ModelTabeleStavkeZaCuvanje() {
        listaStavkiZaCuvanje = new ArrayList<>();

    }

    @Override
    public int getRowCount() {
        if (listaStavkiZaCuvanje == null) {
            return 0;
        } else {
            return listaStavkiZaCuvanje.size();
        }

    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        StavkaRacuna sr = listaStavkiZaCuvanje.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return sr.getRedniBroj();
            case 1:
                return sr.getIzdavanjeSobe().getGost();
            case 2:
                return sr.getIznosStavke();
            default:
                return "N/A";
        }
    }

    @Override
    public String getColumnName(int column) {
        return naziviKolona[column];
    }
    

    public void dodajStavkuZaCuvanje(StavkaRacuna izabranaStavkaZaCuvanje) {
        listaStavkiZaCuvanje.add(izabranaStavkaZaCuvanje);
        fireTableDataChanged();
    }

    public void srediStavke() {
        int brojac = 0;
        for (StavkaRacuna s : listaStavkiZaCuvanje) {
            brojac++;
            s.setRedniBroj(brojac);
            fireTableDataChanged();
        }
    }

    public List<StavkaRacuna> getListaStavkiZaCuvanje() {
        return listaStavkiZaCuvanje;
    }

    public void izbaciStavkuZaCuvanje(int red) {
        listaStavkiZaCuvanje.remove(red);
        fireTableDataChanged();

    }

}
