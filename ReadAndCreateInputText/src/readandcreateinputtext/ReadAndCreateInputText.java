/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readandcreateinputtext;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author didarizaldy
 */
public class ReadAndCreateInputText {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        File namafile = new File(JOptionPane.showInputDialog(null, "Masukkan Nama File : "));
        PrintWriter input = new PrintWriter(namafile);
        String kata = JOptionPane.showInputDialog(null, "Masukkan Kata : ");
        input.println(kata);
        input.close();
        
        char cari;
        int jumlah=0;
        
        cari = JOptionPane.showInputDialog(null,"Masukkan huruf yg ingin dihitung jumlahnya! ").charAt(0);
        for (int i = 0; i < kata.length(); i++) {
            if (cari == kata.charAt(i)) {
                jumlah++;
            }
        }
        JOptionPane.showMessageDialog(null, "Jumlah Huruf " + cari + " = " + jumlah);
    }    
}