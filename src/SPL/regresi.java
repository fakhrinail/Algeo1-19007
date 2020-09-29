/*
package SPL;

import java.util.Scanner;

public class regresi {
    public void makeRegresi() {
        try (Scanner scan = new Scanner(System.in)) {
            System.out.println("Masukkan jumlah peubah x : ");
            int n = scan.nextInt();
            float[] nilaix = new float[n];
            for (int i = 0; i < n; i++) {
                System.out.println("Masukkan nilai x ke-" + (i+1) + " : ");
                float[i] = scan.nextFloat();
            }
            System.out.println("Masukkan nilai dari y : ");
            float nilaiy = scan.nextFloat();

            for (int i = 0; i < this.getBaris(); i++) {
                for (int j = 0; j < this.getKolom(); j++) {
                    System.out.println("Masukkan nilai elemen baris ke-" + (i+1) + " kolom ke-" + (j+1) +": ");
                    this.setElmt(scan.nextFloat(), i,j);
                }
            }
            
        } catch (Exception e) {
            System.out.println("Invalid input");
        }
    }
}

*/