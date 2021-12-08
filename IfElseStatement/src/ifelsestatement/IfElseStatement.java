/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifelsestatement;
import java.io.File;
import javax.swing.JOptionPane;
/**
 *
 * @author Rizal
 */
public class IfElseStatement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       int input = 10;
       input=Integer.parseInt(JOptionPane.showInputDialog(null, "Masukkan Nilai : "));
     
        if (input < 10) {
            JOptionPane.showMessageDialog(null, "Input Anda Kurang Dari 10");
        } else {
            JOptionPane.showMessageDialog(null, "Input Anda Sangat Banyak");
        }
    }
    
}
