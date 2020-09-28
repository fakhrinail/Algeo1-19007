package SPL;

import java.util.Scanner;

public class cramer {
    private int baris,kolom;
    private float[][] tabFloat;

    public void makeCramer() {
        try (Scanner scan = new Scanner(System.in)) {
            System.out.println("Masukkan jumlah baris matriks : ");
            int row = scan.nextInt();
            System.out.println("Masukkan jumlah kolom matriks : ");
            int column = scan.nextInt();
            
            this.setBaris(row);
            this.setKolom(column);
            this.tabFloat = new float[row][column];

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

    /*SETTER*/
    public void setBaris(int row){
        this.baris = row;
    }

    public void setKolom(int column){
        this.kolom = column;
    }
    
    public void setElmt(float value, int row, int column){
        this.tabFloat[row][column] = value;
    }

    public void setWholeTabFloat(float[][] tabInput){
        this.tabFloat = tabInput;
    }

    /*GETTER*/
    public int getBaris(){
        return this.baris;
    }

    public int getKolom(){
        return this.kolom;
    }

    public float getElmt(int row, int column){
        return this.tabFloat[row][column];
    }

    /*METHOD*/
    public void copyMatriks(cramer MSource){
        this.baris = MSource.baris;
        this.kolom = MSource.kolom;
        this.tabFloat = MSource.tabFloat;
    }

    public float[][] switchColumn(float[][] matriks, int columntarget) {
        float tmp;

        for (int i = 0; i < matriks.length; i++) {
            tmp = matriks[i][columntarget];
            matriks[i][columntarget] = matriks[i][matriks[0].length-1];
            matriks[i][matriks[0].length-1] = tmp;
        }

        return matriks;
    }

    public float[][] squareMatrix(float[][] matriks) {
        float[][] square;
        square = new float[matriks.length][matriks[0].length-1];

        for (int i = 0; i < matriks.length; i++) {
            for (int j = 0; j < matriks[0].length-1; j++) {
                square[i][j] = matriks[i][j];
            }
        }

        return square;
    }

    public float determinan(float[][] matriks) {
        if (matriks.length==2 && matriks[0].length==2){
            return (matriks[0][0]*matriks[1][1]) - (matriks[0][1]*matriks[1][0]);
        }else{
            int i = 0;
            int j;

            float determinan=0;
            for (j=0;j<matriks[0].length;j++){  
                float[][] mtmp;
                mtmp = new float[matriks.length-1][matriks[0].length-1];
        
                int k,l;
                for (k=1;k<matriks.length;k++){
                    for (l=0;l<matriks[0].length;l++){
                        if (l<j){
                            mtmp[k-1][l] = matriks[k][l];
                        }else if (l>j){
                            mtmp[k-1][l-1] = matriks[k][l];
                        }
                }
                }
                float isneg = (j%2==0) ? 1:-1;
                determinan += isneg * matriks[i][j] * determinan(mtmp);
            }
            return determinan;
        }
    }
    
    public float[] cramerMethod(float[][] matriks){
        float[] hasil = new float[matriks.length];
        float pembagi;

        pembagi = determinan(squareMatrix(matriks));
        for (int i = 0; i < hasil.length; i++) {
            hasil[i] = determinan(squareMatrix(switchColumn(matriks, i))) / pembagi;
        }

        return hasil;
    }

    public void printHasil(){
        float[] hasil = cramerMethod(tabFloat);
        for (Integer i = 0; i < hasil.length; i++) {
            System.out.print("Hasil elemen ke-");
            System.out.print(i+1);
            System.out.print(" adalah ");
            System.out.print(hasil[i]);
        }
    }
}