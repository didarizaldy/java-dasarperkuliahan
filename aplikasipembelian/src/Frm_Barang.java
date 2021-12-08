/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dida
 */

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class Frm_Barang extends javax.swing.JDialog {
private DefaultTableModel table;
    /**
     * Creates new form barang
     */
    public Frm_Barang(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
                setLocationRelativeTo(this);
        String[] data={"Kode","Nama Barang","Harga Beli","Harga Jual","Stok"};
        table=new DefaultTableModel(data,0);
        jTable1.setModel(table);
        tampil();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtKodeBarang = new javax.swing.JTextField();
        txtNamaBarang = new javax.swing.JTextField();
        txtHargaBeli = new javax.swing.JTextField();
        txtHargaJual = new javax.swing.JTextField();
        txtStok = new javax.swing.JTextField();
        BtnSimpan = new javax.swing.JButton();
        BtnEdit = new javax.swing.JButton();
        BtnBatal = new javax.swing.JButton();
        BtnHapus = new javax.swing.JButton();
        BtnTutup = new javax.swing.JButton();
        BtnCari = new javax.swing.JButton();
        txtCari = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 343, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 448, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("INPUT DATA BARANG");

        jLabel2.setText("Kode Barang");

        jLabel3.setText("Nama Barang");

        jLabel4.setText("Harga Beli");

        jLabel5.setText("Harga Jual");

        jLabel6.setText("Stok");

        BtnSimpan.setText("Simpan");
        BtnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSimpanActionPerformed(evt);
            }
        });

        BtnEdit.setText("Edit");
        BtnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEditActionPerformed(evt);
            }
        });

        BtnBatal.setText("Batal");
        BtnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBatalActionPerformed(evt);
            }
        });

        BtnHapus.setText("Hapus");
        BtnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnHapusActionPerformed(evt);
            }
        });

        BtnTutup.setText("Tutup");
        BtnTutup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnTutupActionPerformed(evt);
            }
        });

        BtnCari.setText("Cari Data");
        BtnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCariActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BtnCari)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCari))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BtnSimpan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtnEdit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtnBatal)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtnHapus)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BtnTutup))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(15, 15, 15)
                                .addComponent(txtNamaBarang))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtHargaBeli, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                    .addComponent(txtHargaJual))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addGap(58, 58, 58)
                                    .addComponent(txtStok, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtKodeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtKodeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtHargaBeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtHargaJual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtStok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnSimpan)
                    .addComponent(BtnEdit)
                    .addComponent(BtnBatal)
                    .addComponent(BtnTutup)
                    .addComponent(BtnHapus))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnCari)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSimpanActionPerformed
        // Ini adalah tombol cari
         if (txtKodeBarang.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Kode Barang tidak boleh kosong");
            txtKodeBarang.requestFocus();
             } 
        else if (txtNamaBarang.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Nama Barang tidak boleh kosong");
            txtNamaBarang.requestFocus();
        }
        else if (txtHargaBeli.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Harga Beli Barang tidak boleh kosong");
            txtHargaBeli.requestFocus();
        }
        else if (txtHargaJual.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Harga Jual Barang tidak boleh kosong");
            txtHargaJual.requestFocus();
        }
        else if (txtStok.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Stok Barang tidak boleh kosong");
            txtStok.requestFocus();
        }
        else
        try {
            Connection koneksi;
            koneksi = DriverManager.getConnection("jdbc:mysql://localhost/aplikasipembelian","root", "");
            koneksi.createStatement().executeUpdate("insert into tabelbarang values('"+txtKodeBarang.getText()+"','"+txtNamaBarang.getText()+"','"+txtHargaBeli.getText()+"','"+txtHargaJual.getText()+"','"+txtStok.getText()+"')");
            JOptionPane.showMessageDialog(rootPane, "Data berhasil disimpan");
            txtKodeBarang.setText(null);
            txtNamaBarang.setText(null);
            txtHargaBeli.setText(null);
            txtHargaJual.setText(null);
            txtStok.setText(null);
            txtKodeBarang.requestFocus();
           // tampil(); //memanggil prosedur dengan nama tampil, prosedur harus dibuat terlebih dahulu
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Database Error");
        }  
    }//GEN-LAST:event_BtnSimpanActionPerformed

    private void BtnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEditActionPerformed
        // Ini adalah tombol edit
        try {
            Connection koneksi;
            koneksi = DriverManager.getConnection("jdbc:mysql://localhost/aplikasipembelian","root", "");
            koneksi.createStatement().executeUpdate("update tabelbarang set namabarang='"+txtNamaBarang.getText()+"',hargabeli='"+txtHargaBeli.getText()+"',hargajual='"+txtHargaJual.getText()+"',stok='"+txtStok.getText()+"' where kodebarang='"+txtKodeBarang.getText()+"'");
            JOptionPane.showMessageDialog(rootPane, "Data berhasil di edit");
            tampil();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Database Error");
        }
    }//GEN-LAST:event_BtnEditActionPerformed

    private void BtnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBatalActionPerformed
        // Ini adalah tombol batal
        txtKodeBarang.setText(null);
            txtNamaBarang.setText(null);
            txtHargaBeli.setText(null);
            txtHargaJual.setText(null);
            txtStok.setText(null);
            txtKodeBarang.requestFocus();
    }//GEN-LAST:event_BtnBatalActionPerformed

    private void BtnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnHapusActionPerformed
        // Ini adalah tombol hapus
        try {
            Connection koneksi;
            koneksi = DriverManager.getConnection("jdbc:mysql://localhost/aplikasipembelian","root", "");
            koneksi.createStatement().executeUpdate("delete from tabelbarang where kodebarang='"+txtKodeBarang.getText()+"'");
            JOptionPane.showMessageDialog(rootPane, "Data berhasil dihapus");
            txtKodeBarang.setText(null);
            txtNamaBarang.setText(null);
            txtHargaBeli.setText(null);
            txtHargaJual.setText(null);
            txtStok.setText(null);
            txtKodeBarang.requestFocus();
            tampil();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Database Error");
        }
    }//GEN-LAST:event_BtnHapusActionPerformed

    private void BtnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCariActionPerformed
        // TODO add your handling code here:
        try
        {
            Connection koneksi;
            koneksi = DriverManager.getConnection("jdbc:mysql://localhost/aplikasipembelian","root", "");
            //koneksi.createStatement().executeUpdate("delete from tabelbarang where kodebarang='"+txtKodeBarang.getText()+"'");
            //Statement st = conn.createStatement();
            String search = txtCari.getText();
            ResultSet dat = koneksi.createStatement().executeQuery("SELECT * FROM tabelbarang WHERE namabarang like '%"+search+"%' OR kodebarang like '%"+search+"%'");
            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();

            dtm.setRowCount(0);
            String [] data = new String[5];
            int i = 1;

            while(dat.next())
            {
                data[0] = dat.getString("kodebarang");
                data[1] = dat.getString("namabarang");
                data[2] = dat.getString("hargabeli");
                data[3] = dat.getString("hargajual");
                data[4] = dat.getString("stok");
                dtm.addRow(data);
                i++;
            }
            dat.close();
            //txtCari.setText("");
        }
        catch(Exception ex)  {
            JOptionPane.showMessageDialog(null,"Data yang Anda cari Tidak dapat Ditemukan");
            System.err.println("error (search) : " +ex);
        }
    }//GEN-LAST:event_BtnCariActionPerformed

    private void BtnTutupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnTutupActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnTutupActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {                                     
        // TODO add your handling code here:
        int i=jTable1.getSelectedRow();
        if (i>-1){
            txtKodeBarang.setText(table.getValueAt(i,0).toString());
            txtNamaBarang.setText(table.getValueAt(i,1).toString());
            txtHargaBeli.setText(table.getValueAt(i,2).toString());
            txtHargaJual.setText(table.getValueAt(i,3).toString());
            txtStok.setText(table.getValueAt(i,4).toString());
        }
    }

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
            java.util.logging.Logger.getLogger(Frm_Barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_Barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_Barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_Barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Frm_Barang dialog = new Frm_Barang(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton BtnBatal;
    private javax.swing.JButton BtnCari;
    private javax.swing.JButton BtnEdit;
    private javax.swing.JButton BtnHapus;
    private javax.swing.JButton BtnSimpan;
    private javax.swing.JButton BtnTutup;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtHargaBeli;
    private javax.swing.JTextField txtHargaJual;
    private javax.swing.JTextField txtKodeBarang;
    private javax.swing.JTextField txtNamaBarang;
    private javax.swing.JTextField txtStok;
    // End of variables declaration//GEN-END:variables
private void tampil() {
        try {
            int row=jTable1.getRowCount();
            for(int i=0; i<row;i++){
                table.removeRow(0);
            }
            
            Connection koneksi =        DriverManager.getConnection("jdbc:mysql://localhost/aplikasipembelian","root", "");
            ResultSet dat=koneksi.createStatement().executeQuery("select * from tabelbarang");
            while(dat.next()){
                String[] data={dat.getString(1),dat.getString(2),dat.getString(3),dat.getString(4),dat.getString(5)};
                table.addRow(data);
}
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane,"Database Error");
        }
    }
}
