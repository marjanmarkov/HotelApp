/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import domen.Gost;
import domen.IzdavanjeSobe;
import domen.Racun;
import domen.Soba;
import domen.StavkaRacuna;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import logika.Kontroler;
import modeli.ModelTabeleSobe;
import modeli.ModelTabeleStavkeRacuna;
import modeli.ModelTabeleStavkeZaCuvanje;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Marjan
 */
public class FGenerisiRacun extends javax.swing.JDialog {

    Soba izabranaSoba;
    private List<IzdavanjeSobe> listaIzdavanjaSobe;
    List<StavkaRacuna> listaStavki;

    /**
     * Creates new form FGenerisiRacun
     */
    public FGenerisiRacun(java.awt.Frame parent, boolean modal, Soba izabrana) throws IOException {
        super(parent, modal);
        initComponents();
        izabranaSoba = izabrana;
        listaIzdavanjaSobe = Kontroler.getInstanca().vratiIzdavanja();
        listaStavki = new ArrayList<>();
        srediFormu();
        postaviModelDrugeTabele();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtIzabranaSoba = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaStavkeRacuna = new javax.swing.JTable();
        txtUkupno = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnOdustani = new javax.swing.JButton();
        btnSacuvaj = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaStavkeZaCuvanje = new javax.swing.JTable();
        btnDodaj = new javax.swing.JButton();
        btnIzbaci = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Izabrana soba:");

        txtIzabranaSoba.setEnabled(false);

        tabelaStavkeRacuna.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabelaStavkeRacuna);

        txtUkupno.setEnabled(false);

        jLabel2.setText("Ukupan iznos:");

        btnOdustani.setText("Odustani");
        btnOdustani.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOdustaniActionPerformed(evt);
            }
        });

        btnSacuvaj.setText("Sacuvaj");
        btnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajActionPerformed(evt);
            }
        });

        tabelaStavkeZaCuvanje.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tabelaStavkeZaCuvanje);

        btnDodaj.setText("Dodaj ->");
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });

        btnIzbaci.setText("<- Izbaci");
        btnIzbaci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzbaciActionPerformed(evt);
            }
        });

        jLabel3.setText("Dodajte iz tabele goste za koje zelite da formirate racun");

        jLabel4.setText("Gosti kojima se izdaje racun:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtIzabranaSoba, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(202, 202, 202))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDodaj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnIzbaci, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnSacuvaj, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnOdustani, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(txtUkupno, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(182, 182, 182))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtIzabranaSoba, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(185, 185, 185)
                        .addComponent(btnDodaj)
                        .addGap(18, 18, 18)
                        .addComponent(btnIzbaci)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)))
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtUkupno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOdustani)
                    .addComponent(btnSacuvaj))
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOdustaniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOdustaniActionPerformed
        dispose();
    }//GEN-LAST:event_btnOdustaniActionPerformed

    private void btnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajActionPerformed
        ModelTabeleStavkeZaCuvanje mtszc = (ModelTabeleStavkeZaCuvanje) tabelaStavkeZaCuvanje.getModel();

        try {
            int idRacuna = Kontroler.getInstanca().vratiIDRacuna();

            List<StavkaRacuna> listaStavkiRacuna = mtszc.getListaStavkiZaCuvanje();
            if (listaStavkiRacuna.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Morate uneti bar jedno izdavanje sobe!");
                return;
            }

            double iznos = Double.parseDouble(txtUkupno.getText());

            Racun racun = new Racun(idRacuna, iznos, izabranaSoba, listaStavkiRacuna);

            Kontroler.getInstanca().sacuvajRacun(racun, this);
        } catch (IOException ex) {
            Logger.getLogger(FGenerisiRacun.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSacuvajActionPerformed

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed
        int red = tabelaStavkeRacuna.getSelectedRow();
        if (red == -1) {
            JOptionPane.showMessageDialog(this, "Morate izabrati stavku za racun!");
            return;
        } else {
            ModelTabeleStavkeRacuna mtsr = (ModelTabeleStavkeRacuna) tabelaStavkeRacuna.getModel();
            StavkaRacuna izabranaStavkaZaCuvanje = mtsr.getListaStavki().get(red);

            ModelTabeleStavkeZaCuvanje mtszc = (ModelTabeleStavkeZaCuvanje) tabelaStavkeZaCuvanje.getModel();
            mtszc.dodajStavkuZaCuvanje(izabranaStavkaZaCuvanje);
            mtszc.srediStavke();

            mtsr.izbaciStavku(red);
            double iznosPrikaz = 0d;
            for (StavkaRacuna s : mtszc.getListaStavkiZaCuvanje()) {
                iznosPrikaz += s.getIznosStavke();
            }

            txtUkupno.setText(iznosPrikaz + "");

        }


    }//GEN-LAST:event_btnDodajActionPerformed

    private void btnIzbaciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzbaciActionPerformed
        int red = tabelaStavkeZaCuvanje.getSelectedRow();
        if (red == -1) {
            JOptionPane.showMessageDialog(this, "Morate izabrati stavku za izbacivanje sa racun!");
            return;
        } else {
            ModelTabeleStavkeZaCuvanje mtszc = (ModelTabeleStavkeZaCuvanje) tabelaStavkeZaCuvanje.getModel();
            StavkaRacuna izabranaStavkaZaIzbacivanje = mtszc.getListaStavkiZaCuvanje().get(red);

            ModelTabeleStavkeRacuna mtsr = (ModelTabeleStavkeRacuna) tabelaStavkeRacuna.getModel();
            mtsr.dodajStavkuracuna(izabranaStavkaZaIzbacivanje);

            mtszc.izbaciStavkuZaCuvanje(red);
            mtszc.srediStavke();

            double iznosPrikaz = 0d;
            for (StavkaRacuna s : mtszc.getListaStavkiZaCuvanje()) {
                iznosPrikaz += s.getIznosStavke();
            }

            txtUkupno.setText(iznosPrikaz + "");

        }


    }//GEN-LAST:event_btnIzbaciActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(FGenerisiRacun.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(FGenerisiRacun.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(FGenerisiRacun.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(FGenerisiRacun.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                FGenerisiRacun dialog = new FGenerisiRacun(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnIzbaci;
    private javax.swing.JButton btnOdustani;
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabelaStavkeRacuna;
    private javax.swing.JTable tabelaStavkeZaCuvanje;
    private javax.swing.JTextField txtIzabranaSoba;
    private javax.swing.JTextField txtUkupno;
    // End of variables declaration//GEN-END:variables

    public void setIzabranaSoba(Soba izabranaSoba) {
        this.izabranaSoba = izabranaSoba;
    }

    public List<IzdavanjeSobe> getListaIzdavanjaSobe() {
        return listaIzdavanjaSobe;
    }

    public void setListaIzdavanjaSobe(List<IzdavanjeSobe> listaIzdavanjaSobe) {
        this.listaIzdavanjaSobe = listaIzdavanjaSobe;
    }

    private void srediFormu() {
        txtIzabranaSoba.setText(izabranaSoba.toString());

        int brojIzabraneSobe = izabranaSoba.getBrojSobe();

        List<IzdavanjeSobe> listaIzdavanjaZaIzabranuSobu = new ArrayList<>();
        for (IzdavanjeSobe iSobe : listaIzdavanjaSobe) {
            if (iSobe.getSoba().getBrojSobe() == brojIzabraneSobe && !iSobe.isPlaceno()) {
                listaIzdavanjaZaIzabranuSobu.add(iSobe);
            }
        }

        srediStavke(listaIzdavanjaZaIzabranuSobu);

    }

    public void neuspesanIS() {
        JOptionPane.showMessageDialog(this, "Izabrana Soba nikome nije izdata");
        dispose();
    }

    private double srediIznosStavke(IzdavanjeSobe iS) {
        double iznosStavke = 0d;

        Date datum = iS.getDatumDolaska();
        Date sada = new Date();

        long diff = sada.getTime() - datum.getTime();
        long brojDana = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);

        iznosStavke = brojDana * izabranaSoba.getTipSobe().getCenaPoOsobi();

        return iznosStavke;
    }

    private void srediStavke(List<IzdavanjeSobe> listaIzdavanjaZaIzabranuSobu) {

//        int brojac = 0;
        for (IzdavanjeSobe iS : listaIzdavanjaZaIzabranuSobu) {
            // brojac++;
            StavkaRacuna s = new StavkaRacuna();
            s.setIznosStavke(srediIznosStavke(iS));
            s.setIzdavanjeSobe(iS);
            s.setRedniBroj(0);
            s.setRacun(null);
            listaStavki.add(s);
        }
        popuniTabelu();
    }

    private void popuniTabelu() {

        ModelTabeleStavkeRacuna mtsr = new ModelTabeleStavkeRacuna(listaStavki);
        tabelaStavkeRacuna.setModel(mtsr);

        //  txtUkupno.setText(mtsr.vratiUkupnuCenu() + "");
    }

    public void uspesnoSacuvano(Racun racun) {
        try {
            Soba ss = izabranaSoba;
            ss.setZauzeta(false);
            Kontroler.getInstanca().azurirajSobuPosleGenerisanjaRacuna(ss, this);
            for (StavkaRacuna sr : racun.getStavkeRacuna()) {

                Gost gg = sr.getIzdavanjeSobe().getGost();
                gg.setSmesten(false);
                Kontroler.getInstanca().azurirajGostaPosleGenerisanjaRacuna(gg, this);

            }

            for (StavkaRacuna sr : racun.getStavkeRacuna()) {
                IzdavanjeSobe i = sr.getIzdavanjeSobe();
                i.setPlaceno(true);
                Kontroler.getInstanca().azurirajIzdavanjeSobePosleGenerisanjaRacuna(i, this);
            }
            JOptionPane.showMessageDialog(this, "Uspesno ste generisali racun!");
        } catch (IOException ex) {
            Logger.getLogger(FGenerisiRacun.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void neuspesnoSacuvano(ServerskiOdgovor so) {
        JOptionPane.showMessageDialog(this, so.getPoruka());
    }

    private void postaviModelDrugeTabele() {
        ModelTabeleStavkeZaCuvanje mtszc = new ModelTabeleStavkeZaCuvanje();
        tabelaStavkeZaCuvanje.setModel(mtszc);

    }
    //*******SOUTi

    public void uspesnoAzuriranGost() {
        System.out.println("uspesno azuriran gost posle generisanja racuna");
    }

    public void neuspesnoAzuriranGost(ServerskiOdgovor so) {
        System.out.println("greska prilikom azuriranja gosta posle generisanja racuna" + so.getPoruka());
    }

    public void uspesnoAzuriranaSoba() {
        System.out.println("uspesno azurirana soba posle generisanja racuna");
    }

    public void neuspesnoAzuriranaSoba(ServerskiOdgovor so) {
        System.out.println("greska prilikom azuriranja sobe posle generisanja racuna" + so.getPoruka());

    }

    public void uspesnoAzuriranoIzdavanjeSobe() {
        System.out.println("uspesno azurirano izdavanje sobe nakon generisanja racuna");
    }

    public void neuspesnoAzuriranaIzdavanjeSobe(ServerskiOdgovor so) {
        System.out.println("greska prilikom azuriranja izdavanja sove posle generisanja racuna");
    }

}
