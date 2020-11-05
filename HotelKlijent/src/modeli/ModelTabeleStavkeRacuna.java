/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.StavkaRacuna;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Marjan
 */
public class ModelTabeleStavkeRacuna extends AbstractTableModel {

    List<StavkaRacuna> listaStavki;

    String[] naziviKolona = { "Gost", "Cena"};

    public ModelTabeleStavkeRacuna(List<StavkaRacuna> listaStavki) {
        this.listaStavki = listaStavki;
    }

    @Override
    public int getRowCount() {
        if (listaStavki == null) {
            return 0;
        } else {
            return listaStavki.size();
        }
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        StavkaRacuna s = listaStavki.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return s.getIzdavanjeSobe().getGost();
            case 1:
                return s.getIznosStavke();
            
            default:
                return "N/A";
        }
    }

    @Override
    public String getColumnName(int column) {
        return naziviKolona[column];
    }

    public double vratiUkupnuCenu() {
        double ukupno = 0d;

        for (StavkaRacuna sr : listaStavki) {
            ukupno += sr.getIznosStavke();
        }
        return ukupno;
    }

    public List<StavkaRacuna> getListaStavki() {
        return listaStavki;
    }

    public void izbaciStavku(int red) {
        listaStavki.remove(red);
        fireTableDataChanged();
    }

    public void dodajStavkuracuna(StavkaRacuna izabranaStavkaZaIzbacivanje) {
        listaStavki.add(izabranaStavkaZaIzbacivanje);
        fireTableDataChanged();
    }

    
}
