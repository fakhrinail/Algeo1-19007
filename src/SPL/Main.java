package SPL;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
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
                MC1.printHasil(MC1.cramerMethod());
            }
            else{

            }
        } else if (menu == 2) {
            
        } else if (menu == 3) {
            
        } else if (menu == 4) {
            
        } else if (menu == 5) {
            
        } else if (menu == 6) {
            
        }
    }
}

    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SPL;

/**
 *
 * @author Azmi
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Inverse M1 = new Inverse();
        M1.makeInverse();
        
        //Matriks M2, matriks yang berisi matriks setelah
        Inverse M2 = new Inverse();
        M2.copyMatriks(M1);

        M2.setWholeTabFloat(M1.inverse(M2.getWholeTab()));
        
        for (int i = 0; i < M2.getBaris(); i++) {
            for (int j = 0; j < M2.getKolom(); j++) {
                System.out.print(M2.getElmt(i, j) + " ");
            }
            System.out.println();
        }
        matriks M3 = new matriks();
        M3.makeSPL();
        
        //Matriks M4, matriks yang berisi matriks setelah
        matriks M4 = new matriks();
        M4.copyMatriks(M3);
        
        for (int i = 0; i < M4.getBaris(); i++) {
            for (int j = 0; j < M4.getKolom(); j++) {
                System.out.print(M4.getElmt(i, j) + " ");
            }
            System.out.println();
        }
        
        
    }
}





