package SPL;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        spl spl1 = new spl();
        
        try (Scanner scan = new Scanner(System.in)) {
            System.out.println("Input your row of matrix : ");
            int row = scan.nextInt();
            System.out.println("Input your column of matrix : ");
            int column = scan.nextInt();
            
            spl1.makeSPL(row, column);
            
            for (int i = 0; i < spl1.getBaris(); i++) {
                for (int j = 0; j < spl1.getKolom(); j++) {
                    System.out.println("Masukkan nilai elemen baris ke-" + (i+1) + " kolom ke-" + (j+1) +": ");
                    spl1.setElmt(scan.nextInt(), i,j);
                }
            }
            
        } catch (Exception e) {
            System.out.println("Invalid input");
        }
    }
}
