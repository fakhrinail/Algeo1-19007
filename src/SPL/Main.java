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
                float[][] tabInput = {{1,1,-1,-1,1},{2,5,-7,-5,-2},{2,-1,1,3,4},{5,2,-4,2,6}};
                /*
                {{1,1,-1,-1,1},{2,5,-7,-5,-2},{2,-1,1,3,4},{5,2,-4,2,6}}
                {{1,-1,0,0,1,3},{1,1,0,-3,0,6},{2,-1,0,1,-1,5},{-1,2,0,-2,-1,-1}}
                {{0,1,0,0,1,0,2},{0,0,0,1,1,0,-1},{0,1,0,0,0,1,1}}
                */
                M1.setBaris(4);
                M1.setKolom(5);
                M1.setWholeTabFloat(tabInput);
                
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
                matriks M1 = new matriks();
                float[][] tabInput = {{1,-1,0,0,1,3},{1,1,0,-3,0,6},{2,-1,0,1,-1,5},{-1,2,0,-2,-1,-1}};
                /*
                {{1,1,-1,-1,1},{2,5,-7,-5,-2},{2,-1,1,3,4},{5,2,-4,2,6}}
                {{1,-1,0,0,1,3},{1,1,0,-3,0,6},{2,-1,0,1,-1,5},{-1,2,0,-2,-1,-1}}
                {{0,1,0,0,1,0,2},{0,0,0,1,1,0,-1},{0,1,0,0,0,1,1}}
                */
                M1.setBaris(4);
                M1.setKolom(6);
                M1.setWholeTabFloat(tabInput);

                float[][] tabTemp = M1.matriksToGauss();
                M1.gaussToGaussJordan(tabTemp);         //tabTemp sudah bernilai gauss-jordan
                
                //Matriks M2, matriks yang berisi matriks setelah
                matriks M2 = new matriks();
                M2.copyMatriks(M1);

                M2.setWholeTabFloat(tabTemp);


                for (int i = 0; i < M2.getBaris(); i++) {
                    for (int j = 0; j < M2.getKolom(); j++) {
                        System.out.print(M2.getElmt(i, j) + " ");
                    }
                    System.out.println();
                }
            }
            else if (opsi == 3) { //Metode balikan
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






