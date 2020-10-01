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

                System.out.print("Masukkan jumlah baris SPL anda: ");
                int baris = scan.nextInt();
                System.out.print("Masukkan jumlah variabel SPL anda: ");    //jumlah variabel tidak termasuk kolom paling kanan
                int kolom = scan.nextInt();

                matriks M1 = new matriks();         //matriks1 adalah matriks raw
                float[][] tabInput = new float[baris][kolom+1];     //ditambah 1 untuk kolom paling kanan
                M1.setBaris(baris);
                M1.setKolom(kolom+1);
                M1.setWholeTabFloat(tabInput);
                
                //Matriks M2, matriks yang berisi matriks setelah
                matriks M2 = new matriks();         //matriks2 akan dijadikan matriks yang telah diproses gauss
                M2.copyMatriks(M1);

                M2.setWholeTabFloat(M1.matriksToGauss());

                float[][] tabTemp = M2.getWholeTab();

                M2.gaussToGaussJordan(tabTemp);     //mengubah dahulu ke gauss-jordan sebelum dikeluarkan hasilnya
                M2.outputHasil(tabTemp);            //dikeluarkan hasil SPL
            }
            else if(opsi == 2) { //Metode Gauss-Jordan
                System.out.print("Masukkan jumlah baris SPL anda: ");
                int baris = scan.nextInt();
                System.out.print("Masukkan jumlah variabel SPL anda: ");    //jumlah variabel tidak termasuk kolom paling kanan
                int kolom = scan.nextInt();

                matriks M1 = new matriks();         //matriks1 adalah matriks raw
                float[][] tabInput = new float[baris][kolom+1];     //ditambah 1 untuk kolom paling kanan
                M1.setBaris(baris);
                M1.setKolom(kolom+1);
                M1.setWholeTabFloat(tabInput);
                
                //Matriks M2, matriks yang berisi matriks setelah
                matriks M2 = new matriks();         //matriks2 akan dijadikan matriks yang telah diproses gauss
                M2.copyMatriks(M1);

                M2.setWholeTabFloat(M1.matriksToGauss());

                float[][] tabTemp = M2.getWholeTab();

                M2.gaussToGaussJordan(tabTemp);     //mengubah dahulu ke gauss-jordan sebelum dikeluarkan hasilnya
                M2.outputHasil(tabTemp);            //dikeluarkan hasil SPL
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
    public static void DeterminanDanMatriksBalikan() {
        System.out.println("1. Metode eliminasi Gauss");
        System.out.println("2. Metode eliminasi Gauss-Jordan");
        System.out.println("3. Metode matriks balikan");
        System.out.println("4. Kaidah Cramer");

        Scanner scan = new Scanner(System.in);

        try {
            int opsi = scan.nextInt();
            if (opsi == 1) { //Metode Gauss

                System.out.print("Masukkan n, sebagai nxn MATRIKS anda: ");
                int n = scan.nextInt();

                matriks M1 = new matriks();                         //matriks1 adalah matriks raw
                float[][] tabInput = new float[n][n];     //ditambah 1 untuk kolom paling kanan
                M1.setBaris(n);
                M1.setKolom(n);
                M1.setWholeTabFloat(tabInput);
                
                //Matriks M2, matriks yang berisi matriks setelah
                matriks M2 = new matriks();         //matriks2 akan dijadikan matriks yang telah diproses gauss
                M2.copyMatriks(M1);

                M2.setWholeTabFloat(M1.matriksToGauss());

                float[][] tabTemp = M2.getWholeTab();

                M2.gaussToGaussJordan(tabTemp);     //mengubah dahulu ke gauss-jordan sebelum dikeluarkan hasilnya
                M2.outputHasil(tabTemp);            //dikeluarkan hasil SPL
            }
            else if(opsi == 2) { //Metode Gauss-Jordan
                System.out.print("Masukkan n, sebagai nxn MATRIKS anda: ");
                int n = scan.nextInt();

                matriks M1 = new matriks();                         //matriks1 adalah matriks raw
                float[][] tabInput = new float[n][n];     //ditambah 1 untuk kolom paling kanan
                M1.setBaris(n);
                M1.setKolom(n);
                M1.setWholeTabFloat(tabInput);
                
                //Matriks M2, matriks yang berisi matriks setelah
                matriks M2 = new matriks();         //matriks2 akan dijadikan matriks yang telah diproses gauss
                M2.copyMatriks(M1);

                M2.setWholeTabFloat(M1.matriksToGauss());

                float[][] tabTemp = M2.getWholeTab();

                M2.gaussToGaussJordan(tabTemp);     //mengubah dahulu ke gauss-jordan sebelum dikeluarkan hasilnya
                M2.outputHasil(tabTemp);            //dikeluarkan hasil SPL
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
            DeterminanDanMatriksBalikan();
        }
    }
    public static void MatrisBalikan() {
        Inverse M = new Inverse();
        cramer C = new cramer();
        M.makeInverse();
        Scanner scan = new Scanner();
        float[][] tabTemp = M.inverse(M.getWholeTab());
        float[][] hasilY = new float[M.getBaris()][1];
        float[] hasil = new float[M.getBaris()][1];
        for (int i = 0; i < hasilY.length; i++) {
            hasilY[i][0] = scan.nextFloat();
        }
        hasil = M.kaliMatriks(tabTemp, hasilY);
        
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