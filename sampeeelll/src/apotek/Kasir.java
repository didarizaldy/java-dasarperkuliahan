/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apotek;

import java.awt.HeadlessException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import koneksi.Connection;
import koneksi.Parameter;
import koneksi.SetTable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Acer
 */
public class Kasir extends javax.swing.JInternalFrame {

    ResultSet st;
    Connection con;
    Statement rs;
    PreparedStatement ps;
    String sql;
    int old, dec, now;
    String newstock;
    public String date;

    /**
     * Creates new form Obat
     */
    private void otomatis() {
        try {
            DateFormat vblnth = new SimpleDateFormat("ddMMYYYY");
            String blnth = vblnth.format(Calendar.getInstance().getTime());

            DateFormat hari = new SimpleDateFormat("dd-MM-YYYY");
            String a = hari.format(Calendar.getInstance().getTime());
             st = con.eksekusiQuery("SELECT MAX(right(kode_transaksi,6)) AS kode_transaksi  "
                    + "FROM penjualan Where tanggal_transaksi like '" +a+ "'");

            while (st.next()) {
                if (st.first() == false) {
                    KodeTransaksi.setText("AP/" +blnth+"/"+ "000001");
                } else {
                    st.last();
                    int auto_id = st.getInt(1) + 1;
                    String no = String.valueOf(auto_id);
                    int NomorJual = no.length();
                    //MENGATUR jumlah 0
                    for (int j = 0; j < 6 - NomorJual; j++) {
                        no = "0" + no;
                    }
                    KodeTransaksi.setText("AP/"+blnth+"/" + no);
                }
            }

        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());

        }
    }
    
     private void noterakhir() 
       
    {
        try {
            st = con.eksekusiQuery("SELECT *from penjualan order by kode_transaksi desc limit 1 ");
            DateFormat vblnth = new SimpleDateFormat("dd-MM-YYYY");
            String blnth = vblnth.format(Calendar.getInstance().getTime());
            if (!st.next()) {
                KodeTransaksi.setText("UPB/" + blnth + "/" + "000000");
            } else {
                String no = st.getString("kode_transaksi");
                String kosong = "";
                String b = no.substring(0, 10);
                String c = no.substring(11, 17);
                KodeTransaksi.setText(b + "/" + c);
            }
            otomatis();

        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());

        }
    }
 
    
    

    public Kasir() {
        con = new koneksi.Connection(new Parameter().HOST_DB,
                new Parameter().USERNAME_DB,
                new Parameter().PASSWORD_DB,
                new Parameter().IPHOST,
                new Parameter().PORT);
        initComponents();
        getTabel();
        getView();
        otomatis();
        Waktu();
     
    }

    public void getTabel() {
        String column[] = {"kode_obat", "nama_obat", "kategori_obat",
            "jenis_obat", "merek_obat", "harga_beli_obat", "harga_jual_obat",
            "jumlah_obat", "tanggal_masuk", "expired"};
        st = con.querySelect(column, "medicine");
        TableMedicine.setModel(new SetTable(st));
    }

    public void getView() {
        String column[] = {"kode_transaksi", "Nama_Pembeli", "kode_obat", "nama_obat",
            "merek_obat", "harga_jual", "jumlah_beli", "total_harga", "tanggal_transaksi","Nomor"};
        st = con.querySelect(column, "penjualan");
        TableTransaksi.setModel(new SetTable(st));
    }

    public void getCari() {
        if (TextSearch.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Masukkan yang anda cari !!!");
        } else {
            if (ComboBoxSearch.getSelectedItem().equals("Kode Obat")) {
                st = con.querySelectAll("medicine", "kode_obat LIKE '%" + TextSearch.getText() + "%' ");
                TableMedicine.setModel(new SetTable(st));
            } else if (ComboBoxSearch.getSelectedItem().equals("Nama Obat")) {
                st = con.querySelectAll("medicine", "nama_obat LIKE '%" + TextSearch.getText() + "%' ");
                TableMedicine.setModel(new SetTable(st));
            } else if (ComboBoxSearch.getSelectedItem().equals("Kategori Obat")) {
                st = con.querySelectAll("medicine", "kategori_obat LIKE '%" + TextSearch.getText() + "%' ");
                TableMedicine.setModel(new SetTable(st));
            } else if (ComboBoxSearch.getSelectedItem().equals("Jenis Obat")) {
                st = con.querySelectAll("medicine", "jenis_obat LIKE '%" + TextSearch.getText() + "%' ");
                TableMedicine.setModel(new SetTable(st));
            } else if (ComboBoxSearch.getSelectedItem().equals("Merek Obat")) {
                st = con.querySelectAll("medicine", "merek_obat LIKE '%" + TextSearch.getText() + "%' ");
                TableMedicine.setModel(new SetTable(st));
            }
        }
    }

    public void getTambah() {
        if (KodeObat.getText().equals("")
                || NamaObat.getText().equals("")
                || MerekObat.getText().equals("")
                || HargaJualObat.getText().equals("")
                || JumlahBeli.getText().equals("")
                || LSubTotal.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Silahkan lengkapi data terlebih dahulu !!! ");

        } else if (KodeTransaksi.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Silahkan Masukan Kode Transaksi Secara Unik !!!");

        } else {
            String[] column = {
                "kode_transaksi",
                "Nama_Pembeli",
                "kode_obat",
                "nama_obat",
                "merek_obat",
                "harga_jual",
                "jumlah_beli",
                "total_harga",
                "tanggal_transaksi",
               
               };
            String[] value = {KodeTransaksi.getText(), NamaPembeli.getText(),
                KodeObat.getText(), NamaObat.getText(),
                MerekObat.getText(), HargaJualObat.getText(),
                JumlahBeli.getText(), LSubTotal.getText(),date};
            System.out.println(con.queryInsert("penjualan", column, value));
            try {
                if (!getCheck_stock()) {
                    JOptionPane.showMessageDialog(this, "Stock obat sudah habis");
                } else {
                    getMin();
                    getTabel();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Kasir.class.getName()).log(Level.SEVERE, null, ex);
            }
            getSubTotal();
            getTotal();
          
              JumlahBeli.setText("");
              LSubTotal.setText("");
              Kembalian1.setText("");
              Tunai.setText("");
            getView();
           
            /*getCancel();*/
        }
    }

    public boolean getCheck_stock() throws SQLException {
        boolean checkstock;
        st = con.querySelectAll("medicine", "kode_obat='" + KodeObat.getText() + "'");
        while (st.next()) {
            old = st.getInt("jumlah_obat");
        }
        dec = Integer.parseInt(JumlahBeli.getText());
        if (old < dec) {
            checkstock = false;
        } else {
            checkstock = true;
        }
        return checkstock;
    }

    public void getMin() throws SQLException {
        st = con.querySelectAll("medicine", "kode_obat='" + KodeObat.getText() + "'");
        while (st.next()) {
            old = st.getInt("jumlah_obat");
        }
        dec = Integer.parseInt(JumlahBeli.getText());
        now = old - dec;
        newstock = Integer.toString(now);
        String a = String.valueOf(newstock);
        String[] kolom = {"jumlah_obat"};
        String[] isi = {a};
        System.out.println(con.queryUpdate("medicine", kolom, isi, "kode_obat='"
                + KodeObat.getText() + "'"));
    }

    public void getMouseClick() {
        //KodeTransaksi.setText(String.valueOf(TableMedicine.getValueAt(TableMedicine.getSelectedRow(), 0)));
        KodeObat.setText(String.valueOf(TableMedicine.getValueAt(TableMedicine.getSelectedRow(), 0)));
        NamaObat.setText(String.valueOf(TableMedicine.getValueAt(TableMedicine.getSelectedRow(), 1)));
        MerekObat.setText(String.valueOf(TableMedicine.getValueAt(TableMedicine.getSelectedRow(), 4)));
        HargaJualObat.setText(String.valueOf(TableMedicine.getValueAt(TableMedicine.getSelectedRow(), 6)));
        JumlahBeli.setText("");
        LSubTotal.setText("");
        Kembalian1.setText("");
        Tunai.setText("");
    }

    //  Hitungan Hitungannya
    public void getSubTotal() {
        Integer a = Integer.parseInt(HargaJualObat.getText());
        Integer b = Integer.parseInt(JumlahBeli.getText());
        Integer c = a * b;
        LSubTotal.setText(String.valueOf(c));
    }

   
    
     public void getPaymen1() {
        int a = Integer.parseInt(LSubTotal.getText());
        int b = Integer.parseInt(Tunai.getText());
        int c = b - a;
        Kembalian1.setText(String.valueOf(c));
    }
    public void getTotal() {
        st = con.eksekusiQuery("SELECT SUM(total_harga) as total_harga FROM"
                + " penjualan WHERE Kode_Transaksi= '" + KodeTransaksi.getText() + "'");
        try {
            st.next();
            lSubTotal1.setText(st.getString("total_harga"));
        } catch (SQLException ex) {
            Logger.getLogger(Kasir.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getPaymen() {
        int a = Integer.parseInt(lSubTotal1.getText());
        int b = Integer.parseInt(Tunai.getText());
        int c = b - a;
        Kembalian1.setText(Integer.toString(c));
    }
public void getCan(){
    NamaPembeli.setText(null);
        NamaPembeli.setText(null);
        KodeObat.setText(null);
        NamaObat.setText(null);
        MerekObat.setText(null);
        HargaJualObat.setText(null);
        JumlahBeli.setText(null);
        Tanggalan.setDate(null);
        LSubTotal.setText(null);
        lSubTotal1.setText(null);
     
    otomatis();
      Waktu();
}
    public void getCancel() {
        NamaPembeli.setText(null);
        NamaPembeli.setText(null);
        KodeObat.setText(null);
        NamaObat.setText(null);
        MerekObat.setText(null);
        HargaJualObat.setText(null);
        JumlahBeli.setText(null);
        Tanggalan.setDate(null);
        LSubTotal.setText(null);
        lSubTotal1.setText(null);
        Tunai.setText(null);
        Kembalian1.setText(null);
          Waktu();
    }

    public void getDelete() {
        String id = String.valueOf(TableTransaksi.getValueAt(TableTransaksi.getSelectedRow(), 9));
        if (JOptionPane.showConfirmDialog(this, "Yakin ingin menghapus data ini", "Peringatan!!!", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            con.queryDelete("penjualan", "Nomor=" + id);
        } else {
            return;
        }
        getTabel();
        getView();
        JOptionPane.showMessageDialog(this, "Data berhasil dihapus");
        getTotal();
        Waktu();
       
         
    
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        NamaPembeli = new javax.swing.JTextField();
        JumlahBeli = new javax.swing.JTextField();
        HargaJualObat = new javax.swing.JTextField();
        MerekObat = new javax.swing.JTextField();
        NamaObat = new javax.swing.JTextField();
        KodeObat = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        LSubTotal = new javax.swing.JLabel();
        Tanggalan = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        KodeTransaksi = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        Tunai = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        Kembalian1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        lSubTotal1 = new javax.swing.JTextField();
        Cancel = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableTransaksi = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableMedicine = new javax.swing.JTable();
        ComboBoxSearch = new javax.swing.JComboBox();
        TextSearch = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        Delete1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        Delete2 = new javax.swing.JButton();
        AddCart = new javax.swing.JButton();
        txtCetak = new javax.swing.JTextField();

        jLabel1.setText("Nama Pembeli");

        jLabel2.setText("Kode Obat");

        jLabel3.setText("Nama Obat");

        jLabel4.setText("Merek");

        jLabel5.setText("Harga Jual");

        jLabel6.setText("Jumlah Beli");

        jLabel7.setText("Tanggal ");

        NamaPembeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NamaPembeliActionPerformed(evt);
            }
        });
        NamaPembeli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                NamaPembeliKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                NamaPembeliKeyReleased(evt);
            }
        });

        JumlahBeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JumlahBeliActionPerformed(evt);
            }
        });
        JumlahBeli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JumlahBeliKeyReleased(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Rp. ");

        Tanggalan.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                TanggalanPropertyChange(evt);
            }
        });

        jLabel13.setText("Kode_Transaksi");

        jLabel14.setText("Tunai");

        Tunai.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TunaiKeyReleased(evt);
            }
        });

        jLabel15.setText("Kembalian");

        jLabel9.setText("Total Harga");

        Cancel.setText("Simpan");
        Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MerekObat))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NamaObat))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NamaPembeli))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(KodeObat))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(KodeTransaksi))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JumlahBeli)
                            .addComponent(HargaJualObat)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE))
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(LSubTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(Tunai)
                            .addComponent(Kembalian1)
                            .addComponent(Tanggalan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                            .addComponent(lSubTotal1))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(KodeTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(NamaPembeli)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(KodeObat)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(NamaObat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(MerekObat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(HargaJualObat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JumlahBeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(Tanggalan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Tunai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Kembalian1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lSubTotal1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        TableTransaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "id_jual", "Nama Pembeli", "Kode Transaksi", "Kode Obat", "Nama Obat", "Harga Obat", "Jumlah Beli", "Total Harga", "Total Beli", "Total Bayar", "Kembali"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TableTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableTransaksiMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TableTransaksi);

        TableMedicine.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Kode Obat", "Nama Obat", "Kategori Obat", "Jenis Obat", "Merek Obat", "Harga Jual Obat", "Stock Obat", "Expired"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TableMedicine.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableMedicineMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableMedicine);

        ComboBoxSearch.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Kode Obat", "Nama Obat", "Kategori Obat", "Jenis Obat", "Merek Obat" }));

        jLabel12.setText("Kategori");

        jButton4.setText("Cari");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        Delete1.setText("Hapus");
        Delete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Delete1ActionPerformed(evt);
            }
        });

        jButton3.setText("Cetak");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        Delete2.setText("Refresh");
        Delete2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Delete2ActionPerformed(evt);
            }
        });

        AddCart.setText("Tambah");
        AddCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddCartActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Delete1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(AddCart, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Delete2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtCetak, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 372, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(TextSearch)
                                    .addComponent(ComboBoxSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane1))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3)
                            .addComponent(txtCetak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(ComboBoxSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4)
                            .addComponent(TextSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Delete1)
                            .addComponent(AddCart)
                            .addComponent(Delete2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(58, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TableTransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableTransaksiMouseClicked
        // TODO add your handling code here:
        
        //KodeTransaksi.setText(String.valueOf(TableMedicine.getValueAt(TableMedicine.getSelectedRow(), 0)));
        KodeTransaksi.setText(String.valueOf(TableTransaksi.getValueAt(TableTransaksi.getSelectedRow(), 0)));
        NamaPembeli.setText(String.valueOf(TableTransaksi.getValueAt(TableTransaksi.getSelectedRow(), 1)));
        KodeObat.setText(String.valueOf(TableTransaksi.getValueAt(TableTransaksi.getSelectedRow(), 2)));
        NamaObat.setText(String.valueOf(TableTransaksi.getValueAt(TableTransaksi.getSelectedRow(), 3)));
        MerekObat.setText(String.valueOf(TableTransaksi.getValueAt(TableTransaksi.getSelectedRow(), 4)));
        HargaJualObat.setText(String.valueOf(TableTransaksi.getValueAt(TableTransaksi.getSelectedRow(), 5)));
        JumlahBeli.setText(String.valueOf(TableTransaksi.getValueAt(TableTransaksi.getSelectedRow(), 6)));
       Tunai.setText(String.valueOf(TableTransaksi.getValueAt(TableTransaksi.getSelectedRow(), 8)));
        Kembalian1.setText(String.valueOf(TableTransaksi.getValueAt(TableTransaksi.getSelectedRow(), 9)));

 Waktu();
    
    }//GEN-LAST:event_TableTransaksiMouseClicked

    private void TableMedicineMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMedicineMouseClicked
        // TODO add your handling code here:
        getMouseClick();
    }//GEN-LAST:event_TableMedicineMouseClicked

    private void Delete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Delete1ActionPerformed
        // TODO add your handling code here:
        getDelete();
        Waktu();
        getTabel();
        getView();
        getCan();
        getCancel();
        
        
    }//GEN-LAST:event_Delete1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        getCari();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelActionPerformed
        // TODO add your handling code here:
            getTambah();
            
            
      
    }//GEN-LAST:event_CancelActionPerformed

    private void JumlahBeliKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JumlahBeliKeyReleased
        // TODO add your handling code here:
        getSubTotal();
        
    }//GEN-LAST:event_JumlahBeliKeyReleased

    private void AddCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddCartActionPerformed
        // TODO add your handling code here:
      getCan();
        getTabel();
         otomatis();
         Waktu();

    }//GEN-LAST:event_AddCartActionPerformed

    private void NamaPembeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NamaPembeliActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_NamaPembeliActionPerformed

    private void NamaPembeliKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NamaPembeliKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER) {
            
            JumlahBeli.requestFocus();
        }
    }//GEN-LAST:event_NamaPembeliKeyPressed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        java.sql.Connection con = null;
        try {
            String jdbcDriver = "com.mysql.jdbc.Driver";
            Class.forName(jdbcDriver);

            String url = "jdbc:mysql://localhost:3306/Apotek";
            String user = "root";
            String pass = "";

            con = DriverManager.getConnection(url, user, pass);
            Statement stm = con.createStatement();

            try {

                String report = ("C:\\Users\\Acer\\Documents\\NetBeansProjects\\Apotik\\src\\apotik\\report1.jrxml");
                 
                JasperReport JRpt = JasperCompileManager.compileReport(report);
                JasperPrint JPrint = JasperFillManager.fillReport(JRpt, null, con);
                JasperViewer.viewReport(JPrint, false);
            } catch (Exception rptexcpt) {
                System.out.println("Report Can't view because : " + rptexcpt);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }//GEN-LAST:event_jButton3ActionPerformed
 public void Waktu() {
        Date tgl = new Date();
        Tanggalan.setDate(tgl);
    }
    
    private void TanggalanPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_TanggalanPropertyChange
        // TODO add your handling code here:
        try {
            if (Tanggalan.getDate() != null) {
                String pattern = "dd-MM-YYYY";
                SimpleDateFormat format = new SimpleDateFormat(pattern);
                date = String.valueOf(format.format(Tanggalan.getDate()));
            }
        } catch (Exception e) {
        }

    }//GEN-LAST:event_TanggalanPropertyChange

    private void JumlahBeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JumlahBeliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JumlahBeliActionPerformed

    private void NamaPembeliKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NamaPembeliKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_NamaPembeliKeyReleased

    private void Delete2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Delete2ActionPerformed
        // TODO add your handling code here:
         NamaPembeli.setText(null);
        NamaPembeli.setText(null);
        KodeObat.setText(null);
        NamaObat.setText(null);
        MerekObat.setText(null);
        HargaJualObat.setText(null);
        JumlahBeli.setText(null);
        Tanggalan.setDate(null);
        LSubTotal.setText(null);
        lSubTotal1.setText(null);
        
     otomatis();
     Waktu();
    }//GEN-LAST:event_Delete2ActionPerformed

    private void TunaiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TunaiKeyReleased
        // TODO add your handling code here:
          getPaymen1();
    }//GEN-LAST:event_TunaiKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddCart;
    private javax.swing.JButton Cancel;
    private javax.swing.JComboBox ComboBoxSearch;
    private javax.swing.JButton Delete1;
    private javax.swing.JButton Delete2;
    private javax.swing.JTextField HargaJualObat;
    private javax.swing.JTextField JumlahBeli;
    private javax.swing.JTextField Kembalian1;
    private javax.swing.JTextField KodeObat;
    private javax.swing.JTextField KodeTransaksi;
    private javax.swing.JLabel LSubTotal;
    private javax.swing.JTextField MerekObat;
    private javax.swing.JTextField NamaObat;
    private javax.swing.JTextField NamaPembeli;
    private javax.swing.JTable TableMedicine;
    private javax.swing.JTable TableTransaksi;
    private com.toedter.calendar.JDateChooser Tanggalan;
    private javax.swing.JTextField TextSearch;
    private javax.swing.JTextField Tunai;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField lSubTotal1;
    private javax.swing.JTextField txtCetak;
    // End of variables declaration//GEN-END:variables
}
