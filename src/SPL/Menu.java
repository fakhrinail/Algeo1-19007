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
               
                for (int i=0; i<baris; i++){
                    for (int j=0; j<kolom+1;j++){
                        if (j==kolom){
                                System.out.print("Masukkan b baris ke " + (i+1) + " ");
                                tabInput[i][j] = scan.nextFloat();
                            }else{
                                System.out.print("Masukkan a baris ke " +(i+1)+" kolom ke "+ (j+1) + " ");
                                tabInput[i][j] = scan.nextFloat();
                        }
                    }
                }
               
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
                
                for (int i=0; i<baris; i++){
                    for (int j=0; j<kolom+1;j++){
                        if (j==kolom){
                                System.out.print("Masukkan b baris ke " + (i+1) + " ");
                                tabInput[i][j] = scan.nextFloat();
                            }else{
                                System.out.print("Masukkan a baris ke " +(i+1)+" kolom ke "+ (j+1) + " ");
                                tabInput[i][j] = scan.nextFloat();
                        }
                    }
                }
                
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
                float[][] tabInput = new float[n][n];     
                for (int i=0; i<n; i++){
                    for (int j=0; j<n;j++){
                        System.out.print("Masukkan a baris ke " +i+" kolom ke "+j);
                        tabInput[i][j] = scan.nextFloat();
                    }
                }

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
                float[][] tabInput = new float[n][n];     
                
                for (int i=0; i<n; i++){
                    for (int j=0; j<n;j++){
                        System.out.print("Masukkan a baris ke " +i+" kolom ke "+j);
                        tabInput[i][j] = scan.nextFloat();
                    }
                }
                
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
                DeterminanDanMatriksBalikan();
            }
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println("Invalid input");
            DeterminanDanMatriksBalikan();
        }
    }
    public static void MatriksBalikan() {
        
    }

    public static void Interpolasi() {
        Scanner scan = new Scanner(System.in);

        interpolasi firstInterpolasi = new interpolasi();
        System.out.println("Masukkan banyak titik: ");
        int n = scan.nextInt();
        
        firstInterpolasi.setBaris(n);
        firstInterpolasi.setKolom(2);
        firstInterpolasi.setWholeTabFloat(new float[n][2]);

        for (int i = 0; i < firstInterpolasi.getBaris(); i++) {
            for (int j = 0; j < firstInterpolasi.getKolom(); j++) {
                if (j==0){
                    System.out.println("Masukkan nilai x dari titik ke-" + (i+1));
                    firstInterpolasi.setElmt(scan.nextFloat(), i,j);
                }else{
                    System.out.println("Masukkan nilai y dari titik ke-" + (i+1));
                    firstInterpolasi.setElmt(scan.nextFloat(), i,j);
                }
            }
        }
        float[][] tabTemp = firstInterpolasi.convertToMatriks();
        
        float x;
        float y;
        
        System.out.println("Masukkan titik (x) yang ingin ditaksir");
        x = scan.nextFloat();

        System.out.println("1. Metode eliminasi Gauss");
        System.out.println("2. Metode eliminasi Gauss-Jordan");
        System.out.println("3. Metode matriks balikan");
        System.out.println("4. Kaidah Cramer");

        int opsi = scan.nextInt();
        if (opsi==1){       //elim gauss
            matriks M = new matriks();
            M.setBaris(firstInterpolasi.getBaris());
            M.setKolom(firstInterpolasi.getBaris()+1);
            M.setWholeTabFloat(tabTemp);

            tabTemp = M.matriksToGauss();
            M.gaussToGaussJordan(tabTemp);

            firstInterpolasi.outputInterpolasi(x, tabTemp);
        }else if(opsi==2){
            matriks M = new matriks();
            M.setBaris(firstInterpolasi.getBaris());
            M.setKolom(firstInterpolasi.getBaris()+1);
            M.setWholeTabFloat(tabTemp);

            tabTemp = M.matriksToGauss();
            M.gaussToGaussJordan(tabTemp);

            firstInterpolasi.outputInterpolasi(x, tabTemp);
        }
            

     
    }

    public static void Regresi() {
        regresi reg = new regresi();
        reg.metodeRegresi();
    }
}