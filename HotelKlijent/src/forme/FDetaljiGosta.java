/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import domen.Gost;
import java.awt.Color;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import logika.Kontroler;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Marjan
 */
public class FDetaljiGosta extends javax.swing.JDialog {

    /**
     * Creates new form FDetaljiGosta
     */
    public FDetaljiGosta(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("Izmena gosta");
        setLocationRelativeTo(null);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtIDGosta = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtIme = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPrezime = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtBrojTelefona = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        checkSmesten = new javax.swing.JCheckBox();
        btnOdustani = new javax.swing.JButton();
        btnIzmeni = new javax.swing.JButton();

        jLabel7.setText("jLabel7");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Detalji gosta");

        jLabel2.setText("ID gosta");

        txtIDGosta.setEnabled(false);

        jLabel3.setText("Ime");

        jLabel4.setText("Prezime");

        jLabel5.setText("Broj telefona");

        txtBrojTelefona.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBrojTelefonaKeyReleased(evt);
            }
        });

        jLabel6.setText("Smesten");

        checkSmesten.setEnabled(false);

        btnOdustani.setText("Odustani");
        btnOdustani.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOdustaniActionPerformed(evt);
            }
        });

        btnIzmeni.setText("Izmeni");
        btnIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmeniActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(checkSmesten)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtIDGosta)
                            .addComponent(txtIme)
                            .addComponent(txtPrezime)
                            .addComponent(txtBrojTelefona)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 203, Short.MAX_VALUE)
                        .addComponent(btnIzmeni)
                        .addGap(18, 18, 18)
                        .addComponent(btnOdustani)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtIDGosta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtBrojTelefona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(checkSmesten))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOdustani)
                    .addComponent(btnIzmeni))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOdustaniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOdustaniActionPerformed
        try {
            FPretragaGostiju fpg = new FPretragaGostiju(null, true);
            this.dispose();
            fpg.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(FDetaljiGosta.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnOdustaniActionPerformed

    private void btnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmeniActionPerformed
        String id = txtIDGosta.getText().trim();
        String ime = txtIme.getText().trim();
        String prezime = txtPrezime.getText().trim();
        String tel = txtBrojTelefona.getText().trim();
        boolean smesten = checkSmesten.isSelected();
        try {
            validacija(ime, prezime, tel);
            Gost g = new Gost(Integer.parseInt(id), ime, prezime, tel, smesten);
            List<Gost> listaGostiju = Kontroler.getInstanca().vratiGoste();
            for (Gost gost : listaGostiju) {
                if (gost.getIme().equals(ime) && gost.getPrezime().equals(prezime) && gost.getBrTel().equals(tel) && Boolean.valueOf(gost.isSmesten()).equals(smesten)) {
                    JOptionPane.showMessageDialog(this, "Sistem ne moze da izmeni gosta, jer nije uneta nikakva izmena.");
                    return;
                }
            }
            Kontroler.getInstanca().izmeniGosta(g, this);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Greska: " + e.getMessage());
        }

    }//GEN-LAST:event_btnIzmeniActionPerformed

    private void txtBrojTelefonaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBrojTelefonaKeyReleased
        String brojTelefona = txtBrojTelefona.getText().trim();

        for (char c : brojTelefona.toCharArray()) {
            if (!Character.isDigit(c) && !brojTelefona.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Broj telefona moze sadrzati samo cifre!");
                txtBrojTelefona.setText("");
            }
        }


    }//GEN-LAST:event_txtBrojTelefonaKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FDetaljiGosta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FDetaljiGosta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FDetaljiGosta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FDetaljiGosta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FDetaljiGosta dialog = new FDetaljiGosta(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIzmeni;
    private javax.swing.JButton btnOdustani;
    private javax.swing.JCheckBox checkSmesten;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txtBrojTelefona;
    private javax.swing.JTextField txtIDGosta;
    private javax.swing.JTextField txtIme;
    private javax.swing.JTextField txtPrezime;
    // End of variables declaration//GEN-END:variables

    void postaviVrednostiGosta(Gost g) {
        txtIDGosta.setText(g.getGostID() + "");
        txtIme.setText(g.getIme());
        txtPrezime.setText(g.getPrezime());
        txtBrojTelefona.setText(g.getBrTel());
        checkSmesten.setSelected(g.isSmesten());
    }

    public void uspesnoIzmenjeno() throws IOException {
        JOptionPane.showMessageDialog(this, "Sistem je uspesno azurirao gosta");
        FPretragaGostiju fpg = new FPretragaGostiju(null, true);
        dispose();
        Kontroler.getInstanca().popuniTabeluGostiju(fpg);
        fpg.setVisible(true);
    }

    public void neuspesnoIzmenjeno(ServerskiOdgovor so) {
        JOptionPane.showMessageDialog(this, so.getPoruka());

    }

    private void validacija(String ime, String prezime, String brojTel) throws Exception {
        Border a = BorderFactory.createEtchedBorder();
        Border b = BorderFactory.createLineBorder(Color.RED);

        txtIme.setBorder(a);
        txtPrezime.setBorder(a);
        txtBrojTelefona.setBorder(a);

        //  ime txtPrezime txtBrojTelefona
        //|| ime == null
        //|| txtPrezime == null
        //|| txtBrojTelefona == null
        if ((ime.isEmpty() || ime == null) && (prezime.isEmpty() || prezime == null) && (brojTel.isEmpty() || brojTel == null)) {
            txtIme.setBorder(b);
            txtPrezime.setBorder(b);
            txtBrojTelefona.setBorder(b);
            throw new Exception("Sva tekstualna polja moraju biti popunjena!");
        }

        if (!(ime.isEmpty() || ime == null) && (prezime.isEmpty() || prezime == null) && (brojTel.isEmpty() || brojTel == null)) {
            txtPrezime.setBorder(b);
            txtBrojTelefona.setBorder(b);
            throw new Exception("Sva tekstualna polja moraju biti popunjena!");
        }
        if ((ime.isEmpty() || ime == null) && !(prezime.isEmpty() || prezime == null) && (brojTel.isEmpty() || brojTel == null)) {
            txtIme.setBorder(b);
            txtBrojTelefona.setBorder(b);
            throw new Exception("Sva tekstualna polja moraju biti popunjena!");
        }
        if ((ime.isEmpty() || ime == null) && (prezime.isEmpty() || prezime == null) && !(brojTel.isEmpty() || brojTel == null)) {
            txtIme.setBorder(b);
            txtPrezime.setBorder(b);
            throw new Exception("Sva tekstualna polja moraju biti popunjena!");
        }

        if ((ime.isEmpty() || ime == null) && !(prezime.isEmpty() || prezime == null) && !(brojTel.isEmpty() || brojTel == null)) {
            txtIme.setBorder(b);
            throw new Exception("Sva tekstualna polja moraju biti popunjena!");
        }
        if (!(ime.isEmpty() || ime == null) && (prezime.isEmpty() || prezime == null) && !(brojTel.isEmpty() || brojTel == null)) {
            txtPrezime.setBorder(b);
            throw new Exception("Sva tekstualna polja moraju biti popunjena!");
        }
        if (!(ime.isEmpty() || ime == null) && !(prezime.isEmpty() || prezime == null) && (brojTel.isEmpty() || brojTel == null)) {
            txtBrojTelefona.setBorder(b);
            throw new Exception("Sva tekstualna polja moraju biti popunjena!");
        }
    }
}
