/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luaslingkaran;
import javax.swing.JOptionPane;
/**
 *
 * @author Dida
 */
public class LuasLingkaran {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       int alas;
       int tinggi;
       alas=Integer.parseInt(JOptionPane.showInputDialog(null, "Masukkan Nilai Alas "));
     
       tinggi=Integer.parseInt(JOptionPane.showInputDialog(null,"Masukkan Nilai Tinggi "));
     
        int Luas = alas*tinggi/2;
     
        JOptionPane.showMessageDialog(null, "Luas = Alas x Tinggi : 2 \n" +
                "Luas =" + alas + " x " + tinggi + " : 2\n"
                + "Luas Segitiga adalah : " +Luas);
   
    }
    
}