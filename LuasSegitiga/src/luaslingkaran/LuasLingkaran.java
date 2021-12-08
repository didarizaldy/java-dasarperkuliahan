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
       double phi = 3.14;
       double r;
       r=Double.parseDouble(JOptionPane.showInputDialog(null,"Masukkan Jari Jari : "));
     
       double Luas = phi * r * r;
     
       JOptionPane.showMessageDialog(null, "Luas = phi x r x r \n" +
                "Luas =" + phi + " x " + r + " x " + r + "\n"
                + "Luas Lingkaran adalah : " + Luas);
   
    }
    
}