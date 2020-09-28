package SPL;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        Scanner scan = new Scanner(System.in);

        System.out.println("MENU");
        System.out.println("1. Sistem Persamaan Linier");
        System.out.println("2. Determinan");
        System.out.println("3. Matriks balikan");
        System.out.println("4. Interpolasi Polinom");
        System.out.println("5. Regresi linier berganda");
        System.out.println("6. Keluar");

        int menu = scan.nextInt();

        if (menu == 1) {
            System.out.println("1. Metode eliminasi Gauss");
            System.out.println("2. Metode eliminasi Gauss-Jordan");
            System.out.println("3. Metode matriks balikan");
            System.out.println("4. Kaidah Cramer");
            
            int opsi = scan.nextInt();
            if (opsi == 1) { //Metode Gauss
                matriks M1 = new matriks();
                M1.makeSPL();
                
                //Matriks M2, matriks yang berisi matriks setelah
                matriks M2 = new matriks();
                M2.copyMatriks(M1);

                M2.setWholeTabFloat(M1.matriksToGauss());

                for (int i = 0; i < M2.getBaris(); i++) {
                    for (int j = 0; j < M2.getKolom(); j++) {
                        System.out.print(M2.getElmt(i, j) + " ");
                    }
                    System.out.println();
                }
            }
            else if(opsi == 2) { //Metode Gauss-Jordan
                
            }
            else if (opsi == 3) { //Metode balikan
                
            }
            else if (opsi == 4) { //Metode Cramer
                cramer MC1 = new cramer();
                MC1.makeCramer();
                
                //Matriks M2, matriks yang berisi matriks setelah
                cramer MC2 = new cramer();
                MC2.copyMatriks(MC1);

                MC2.printHasil();
            }
            else{

            }
        } else if (menu == 2) {
            
        } else if (menu == 3) {
            
        } else if (menu == 4) {
            
        } else if (menu == 5) {
            
        } else if (menu == 6) {
            
        }
        */
        Scanner scan = new Scanner(System.in);

        cramer MC1 = new cramer();
        
        System.out.println("Masukkan jumlah baris matriks : ");
        int row = scan.nextInt();
        System.out.println("Masukkan jumlah kolom matriks : ");
        int column = scan.nextInt();

        float[][] matriks = new float[row][column];

        for (int i = 0; i < matriks.length; i++) {
            for (int j = 0; j < matriks[0].length; j++) {
                System.out.println("Masukkan nilai elemen baris ke-" + (i+1) + " kolom ke-" + (j+1) +": ");
                matriks[i][j] = scan.nextFloat();
            }
        }
        
        MC1.printHasil(MC1.cramerMethod(matriks));

    }
}




