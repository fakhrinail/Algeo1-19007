package SPL;

import java.util.Scanner;

public class Menu {
    public static void SPL() {
        System.out.println("1. Metode eliminasi Gauss");
        System.out.println("2. Metode eliminasi Gauss-Jordan");
        System.out.println("3. Metode matriks balikan");
        System.out.println("4. Kaidah Cramer");

        Scanner scan = new Scanner(System.in);

        try {
            int opsi = scan.nextInt();
            if (opsi == 1) { //Metode Gauss
                matriks M1 = new matriks();
                float[][] tabInput = {{1,1,-1,-1,1},{2,5,-7,-5,-2},{2,-1,1,3,4},{5,2,-4,2,6}};
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
                System.out.println("Invalid Input");
                SPL();
            }
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println("Invalid input");
            SPL();
        }
    }
    public static void Determinan () {
        Inverse M = new Inverse();
        M.makeInverse();
        float nilaiDeterminan = M.Determinan(M.getWholeTab());
        System.out.println(nilaiDeterminan);
    }
    public static void MatrisBalikan() {
        Inverse M = new Inverse();
        M.makeInverse();
        float[][] tabTemp = M.inverse(M.getWholeTab());
        for (int i = 0; i < M.getBaris(); i++) {
            for (int j = 0; j < M.getKolom(); j++) {
                System.out.print(tabTemp[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void Interpolasi() {
        interpolasi firstInterpolasi = new interpolasi();
        firstInterpolasi.makeInterpolasi();
        float[][] tabTemp = firstInterpolasi.convertToMatriks();

        matriks M = new matriks();
        M.setBaris(firstInterpolasi.getBaris());
        M.setKolom(firstInterpolasi.getBaris()+1);
        M.setWholeTabFloat(tabTemp);

        tabTemp = M.matriksToGauss();
        M.gaussToGaussJordan(tabTemp);

        for (int i = 0; i < M.getBaris(); i++) {
            for (int j = 0; j < M.getKolom(); j++) {
                System.out.print(tabTemp[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void Regresi() {
        regresi reg = new regresi();
        reg.metodeRegresi();
    }
}