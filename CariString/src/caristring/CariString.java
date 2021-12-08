/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caristring;

import javax.swing.JOptionPane;

/**
 *
 * @author Rizal
 */
public class CariString {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String kalimat;
        char cari;
        int jumlah=0;
        kalimat = JOptionPane.showInputDialog(null,"Masukkan kalimat anda! ");
        cari = JOptionPane.showInputDialog(null,"Masukkan karakter yg ingin dihitung jumlahnya! ").charAt(0);
        for (int i = 0; i < kalimat.length(); i++) {
         if (cari == kalimat.charAt(i)) {
        jumlah++;
         }
        }
        JOptionPane.showMessageDialog(null, "jumlah huruf " + cari + "= " + jumlah);
    }
    
}
