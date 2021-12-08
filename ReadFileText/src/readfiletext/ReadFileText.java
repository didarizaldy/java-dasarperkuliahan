/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readfiletext;
import java.io.BufferedReader;
import java.io.File;
import javax.swing.JOptionPane;
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 *
 * @author Rizal
 */
public class ReadFileText {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
//        String barisIsi;
//        try {
//            Scanner inputFile = new Scanner(new FileReader("C:\\Users\\Administrator\\Documents\\NetBeansProjects\\ReadFileText\\src\\readfiletext\\daftarNama.txt"));
//
//            while(inputFile.hasNextLine()){
//                barisIsi = inputFile.nextLine();
//                System.out.println(barisIsi);
//            }
//        }
//        catch(FileNotFoundException e) {
//            System.out.println("Tidak ada file .txt tersebut");
//        }
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
            // membuat objek file dengan argumen "todolist.txt"
        File f = new File(JOptionPane.showInputDialog(null, "Masukkan Nama File : "));
        // kalau filenya tidak ada, filenya ditulis
        if (!f.exists()) {
            // inisiasi objek PrintWriter untuk melakukan input/output
            PrintWriter pw = new PrintWriter(f);
            // tuliskan "to do list:" pada baris pertama
//                pw.println("to do list:");
            // loop untuk menulis sebanyak yang kita mau
            for (int i = 0; i < 100; i++) {
//                    System.out.println("silahkan input");
                // baca dari console dan dimasukan ke variabel
                String task = JOptionPane.showInputDialog(null, "Masukkan Kata : ");
                if (task.equalsIgnoreCase("quit")) {
                    // kalau string nya terbaca "quit", break dari loop dan program selesai
                    // tutup writer dan reader
                    consoleReader.close();
                    pw.close();
                    JOptionPane.showMessageDialog(null, "Kata sudah ditambahkan");
                    break;
                }
                else {
                    // print string nya ke file (kalau stringnya bukan "quit")
                    pw.println(task);
                }
            }
        }

        // kalau filenya sudah ada, filenya dibaca
        else {
            // inisiasi objek BufferedReader untuk membaca dari file
            BufferedReader fileReader = new BufferedReader(new FileReader(f));
            Scanner bacafile = new Scanner(new FileReader(f));
            // print header
            System.out.println(fileReader.readLine());
//                JOptionPane.showInputDialog(fileReader.readLine());
            // for loop untuk membaca seluruh isi dari file
//                String task1 = fileReader.readLine();
//                JOptionPane.showMessageDialog(null, task1);
            for (int i = 0; i <= 100; i++) {
                // baca baris dan dimasukkan ke variabel
                String task = fileReader.readLine();
                if (task != null) {
                    // kalau string nya bukan null, print stringnya
                    System.out.println("- " + task);
//                        JOptionPane.showMessageDialog(null, task);
                }
                else {
                    // kalau string nya null, artinya filenya sudah habis, dan break dari loop
                    break;
                }
            }
        }
    }
    
}
