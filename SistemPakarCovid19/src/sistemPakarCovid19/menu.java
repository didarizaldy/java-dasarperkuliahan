/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemPakarCovid19;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.EventQueue;

/**
 *
 * @author Dida
 */
public class menu extends javax.swing.JFrame {

    /**
     * Creates new form menu
     */
    public menu() {
        this.setUndecorated(true);
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        this.setBackground(new Color(0,0,0,0));
        jPanel1.setBackground(new Color(0,0,0,0));
//        this.setUndecorated(true);
//        hasilDiagnosa.setBackground(new Color(0,0,0,0));
//        this.setUndecorated(true);
//        hasilDiagnosaText.setBackground(new Color(0,0,0,0));
//        this.setUndecorated(true);
//        diagnosaButton.setBackground(new Color(0,0,0,0));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        Kiri = new javax.swing.JLabel();
        demam = new javax.swing.JCheckBox();
        kehilanganSeleraMakan = new javax.swing.JCheckBox();
        kelelahan = new javax.swing.JCheckBox();
        kehilanganBau = new javax.swing.JCheckBox();
        sesakNapas = new javax.swing.JCheckBox();
        batuk = new javax.swing.JCheckBox();
        batukBerdahak = new javax.swing.JCheckBox();
        kesulitanBangun = new javax.swing.JCheckBox();
        rasaCemas = new javax.swing.JCheckBox();
        nyeriOtot = new javax.swing.JCheckBox();
        wajahBibirKebiruan = new javax.swing.JCheckBox();
        batukDarah = new javax.swing.JCheckBox();
        nyeriDadaBerkelanjutan = new javax.swing.JCheckBox();
        demamTinggi = new javax.swing.JCheckBox();
        gagalGinjal = new javax.swing.JCheckBox();
        diagnosaButton = new javax.swing.JLabel();
        exitButton = new javax.swing.JLabel();
        hasilDiagnosaText = new javax.swing.JLabel();
        hasilDiagnosa = new javax.swing.JTextField();
        hasilDiagnosaText1 = new javax.swing.JLabel();
        hasilDiagnosa1 = new javax.swing.JTextField();
        Kanan = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemPakarCovid19/assets/images/sistem pakar3.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 36, -1, 20));

        Kiri.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemPakarCovid19/assets/images/sistem pakar.png"))); // NOI18N
        jPanel1.add(Kiri, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 400, 500));

        demam.setBackground(new java.awt.Color(245, 243, 244));
        demam.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        demam.setForeground(new java.awt.Color(0, 75, 140));
        demam.setText("Demam");
        demam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                demamActionPerformed(evt);
            }
        });
        jPanel1.add(demam, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 130, -1, -1));

        kehilanganSeleraMakan.setBackground(new java.awt.Color(245, 243, 244));
        kehilanganSeleraMakan.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        kehilanganSeleraMakan.setForeground(new java.awt.Color(0, 75, 140));
        kehilanganSeleraMakan.setText("Kehilangan Selera Makan");
        kehilanganSeleraMakan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kehilanganSeleraMakanActionPerformed(evt);
            }
        });
        jPanel1.add(kehilanganSeleraMakan, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 150, -1, -1));

        kelelahan.setBackground(new java.awt.Color(245, 243, 244));
        kelelahan.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        kelelahan.setForeground(new java.awt.Color(0, 75, 140));
        kelelahan.setText("Kelelahan");
        jPanel1.add(kelelahan, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 170, -1, -1));

        kehilanganBau.setBackground(new java.awt.Color(245, 243, 244));
        kehilanganBau.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        kehilanganBau.setForeground(new java.awt.Color(0, 75, 140));
        kehilanganBau.setText("Kehilangan Bau");
        jPanel1.add(kehilanganBau, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 190, -1, -1));

        sesakNapas.setBackground(new java.awt.Color(245, 243, 244));
        sesakNapas.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        sesakNapas.setForeground(new java.awt.Color(0, 75, 140));
        sesakNapas.setText("Sesak Napas");
        jPanel1.add(sesakNapas, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 410, -1, -1));

        batuk.setBackground(new java.awt.Color(245, 243, 244));
        batuk.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        batuk.setForeground(new java.awt.Color(0, 75, 140));
        batuk.setText("Batuk");
        batuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batukActionPerformed(evt);
            }
        });
        jPanel1.add(batuk, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 210, -1, -1));

        batukBerdahak.setBackground(new java.awt.Color(245, 243, 244));
        batukBerdahak.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        batukBerdahak.setForeground(new java.awt.Color(0, 75, 140));
        batukBerdahak.setText("Batuk Berdahak");
        jPanel1.add(batukBerdahak, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 230, -1, -1));

        kesulitanBangun.setBackground(new java.awt.Color(245, 243, 244));
        kesulitanBangun.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        kesulitanBangun.setForeground(new java.awt.Color(0, 75, 140));
        kesulitanBangun.setText("Kesulitan Bangun");
        jPanel1.add(kesulitanBangun, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 250, -1, -1));

        rasaCemas.setBackground(new java.awt.Color(245, 243, 244));
        rasaCemas.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        rasaCemas.setForeground(new java.awt.Color(0, 75, 140));
        rasaCemas.setText("Rasa Cemas");
        jPanel1.add(rasaCemas, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 270, -1, -1));

        nyeriOtot.setBackground(new java.awt.Color(245, 243, 244));
        nyeriOtot.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        nyeriOtot.setForeground(new java.awt.Color(0, 75, 140));
        nyeriOtot.setText("Nyeri dan Sakit Otot");
        nyeriOtot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nyeriOtotActionPerformed(evt);
            }
        });
        jPanel1.add(nyeriOtot, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 290, -1, -1));

        wajahBibirKebiruan.setBackground(new java.awt.Color(245, 243, 244));
        wajahBibirKebiruan.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        wajahBibirKebiruan.setForeground(new java.awt.Color(0, 75, 140));
        wajahBibirKebiruan.setText("Wajah atau Bibir Kebiruan");
        jPanel1.add(wajahBibirKebiruan, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 310, -1, -1));

        batukDarah.setBackground(new java.awt.Color(245, 243, 244));
        batukDarah.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        batukDarah.setForeground(new java.awt.Color(0, 75, 140));
        batukDarah.setText("Batuk Darah");
        jPanel1.add(batukDarah, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 330, -1, -1));

        nyeriDadaBerkelanjutan.setBackground(new java.awt.Color(245, 243, 244));
        nyeriDadaBerkelanjutan.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        nyeriDadaBerkelanjutan.setForeground(new java.awt.Color(0, 75, 140));
        nyeriDadaBerkelanjutan.setText("Nyeri Dada Berkelanjutan");
        jPanel1.add(nyeriDadaBerkelanjutan, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 350, -1, -1));

        demamTinggi.setBackground(new java.awt.Color(245, 243, 244));
        demamTinggi.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        demamTinggi.setForeground(new java.awt.Color(0, 75, 140));
        demamTinggi.setText("Demam Tinggi");
        demamTinggi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                demamTinggiActionPerformed(evt);
            }
        });
        jPanel1.add(demamTinggi, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 370, -1, -1));

        gagalGinjal.setBackground(new java.awt.Color(245, 243, 244));
        gagalGinjal.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        gagalGinjal.setForeground(new java.awt.Color(0, 75, 140));
        gagalGinjal.setText("Gagal Ginjal");
        gagalGinjal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gagalGinjalActionPerformed(evt);
            }
        });
        jPanel1.add(gagalGinjal, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 390, -1, -1));

        diagnosaButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemPakarCovid19/assets/images/sistem pakar4.png"))); // NOI18N
        diagnosaButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                diagnosaButtonMouseClicked(evt);
            }
        });
        jPanel1.add(diagnosaButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 440, -1, -1));

        exitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemPakarCovid19/assets/images/exit.png"))); // NOI18N
        exitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitButtonMouseClicked(evt);
            }
        });
        jPanel1.add(exitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 30, 40, -1));

        hasilDiagnosaText.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        hasilDiagnosaText.setForeground(new java.awt.Color(0, 75, 140));
        hasilDiagnosaText.setText("Hasil Diagnosa");
        jPanel1.add(hasilDiagnosaText, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 480, -1, -1));

        hasilDiagnosa.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        hasilDiagnosa.setForeground(new java.awt.Color(0, 75, 140));
        jPanel1.add(hasilDiagnosa, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 475, 213, -1));

        hasilDiagnosaText1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        hasilDiagnosaText1.setForeground(new java.awt.Color(0, 75, 140));
        hasilDiagnosaText1.setText("Nama Pasien");
        jPanel1.add(hasilDiagnosaText1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 80, -1, -1));
        jPanel1.add(hasilDiagnosa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 75, 213, -1));

        Kanan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemPakarCovid19/assets/images/sistem pakar2.png"))); // NOI18N
        jPanel1.add(Kanan, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, 550, 500));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 838, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void exitButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitButtonMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_exitButtonMouseClicked

    private void gagalGinjalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gagalGinjalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gagalGinjalActionPerformed

    private void demamTinggiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_demamTinggiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_demamTinggiActionPerformed

    private void nyeriOtotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nyeriOtotActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nyeriOtotActionPerformed

    private void diagnosaButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_diagnosaButtonMouseClicked
        // TODO add your handling code here:
        if (demam.isSelected() && demamTinggi.isSelected() && batuk.isSelected() && batukBerdahak.isSelected() && batukDarah.isSelected() && gagalGinjal.isSelected() && kehilanganBau.isSelected() && kehilanganSeleraMakan.isSelected() && kelelahan.isSelected() && kesulitanBangun.isSelected() && nyeriDadaBerkelanjutan.isSelected() && nyeriOtot.isSelected() && rasaCemas.isSelected() && sesakNapas.isSelected() && wajahBibirKebiruan.isSelected()) {
            hasilDiagnosa.setText("Positif");
        } else {
            hasilDiagnosa.setText("Negatif");
        }
    }//GEN-LAST:event_diagnosaButtonMouseClicked

    private void demamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_demamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_demamActionPerformed

    private void kehilanganSeleraMakanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kehilanganSeleraMakanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kehilanganSeleraMakanActionPerformed

    private void batukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batukActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_batukActionPerformed

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
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Kanan;
    private javax.swing.JLabel Kiri;
    private javax.swing.JCheckBox batuk;
    private javax.swing.JCheckBox batukBerdahak;
    private javax.swing.JCheckBox batukDarah;
    private javax.swing.JCheckBox demam;
    private javax.swing.JCheckBox demamTinggi;
    private javax.swing.JLabel diagnosaButton;
    private javax.swing.JLabel exitButton;
    private javax.swing.JCheckBox gagalGinjal;
    private javax.swing.JTextField hasilDiagnosa;
    private javax.swing.JTextField hasilDiagnosa1;
    private javax.swing.JLabel hasilDiagnosaText;
    private javax.swing.JLabel hasilDiagnosaText1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JCheckBox kehilanganBau;
    private javax.swing.JCheckBox kehilanganSeleraMakan;
    private javax.swing.JCheckBox kelelahan;
    private javax.swing.JCheckBox kesulitanBangun;
    private javax.swing.JCheckBox nyeriDadaBerkelanjutan;
    private javax.swing.JCheckBox nyeriOtot;
    private javax.swing.JCheckBox rasaCemas;
    private javax.swing.JCheckBox sesakNapas;
    private javax.swing.JCheckBox wajahBibirKebiruan;
    // End of variables declaration//GEN-END:variables
}