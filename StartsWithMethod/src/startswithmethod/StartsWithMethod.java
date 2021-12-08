/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package startswithmethod;

import javax.swing.JOptionPane;

/**
 *
 * @author didarizaldy
 */
public class StartsWithMethod {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String kata = JOptionPane.showInputDialog(null, "Masukkan Kata : ");
        String katakunci = JOptionPane.showInputDialog(null, "Masukkan Kata Kunci Pada Awal Kata: ");
        if(kata.startsWith(katakunci)==true){
            JOptionPane.showMessageDialog(null, "Kata tersebut terdapat pada awal kalimat");
        } else {
            JOptionPane.showConfirmDialog(null, "Tidak Terdapat Kata Kunci Tersebut","Error" , JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
