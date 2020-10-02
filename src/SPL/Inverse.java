package SPL;

import java.util.Scanner;
import java.lang.Math;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;  // Import the IOException class to handle errors
import java.io.Writer;
import java.util.Scanner;

public class Inverse {
    private int baris,kolom;
    private float[][] tabFloat;
    private float[][] tabY;

    Scanner scan = new Scanner(System.in);

    public void makeInverse() {
        System.out.print("Masukkan n, sebagai nxn matriks : ");
        int n = scan.nextInt();
            
        this.setBaris(n);
        this.setKolom(n);
        this.tabFloat = new float[n][n];

        for (int i = 0; i < this.getBaris(); i++) {
            for (int j = 0; j < this.getKolom(); j++) {
                System.out.println("Masukkan nilai elemen baris ke-" + (i+1) + " kolom ke-" + (j+1) +": ");
                this.setElmt(scan.nextFloat(), i,j);
            }
        }
    }

    public void makeMatriksY() {
        this.tabY = new float[tabFloat.length][1];
        for (int i = 0; i < tabFloat.length; i++) {
            System.out.println("Masukkan nilai y pada baris ke-" + (i+1));
            this.tabY[i][0] = scan.nextFloat();
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
    public float[][] getWholeTab(){
        return this.tabFloat;
    }
    public float[][] getWholeTabY() {
        return this.tabY;
    }

    /*METHOD*/
    public void copyMatriks(Inverse MSource){
        this.baris = MSource.baris;
        this.kolom = MSource.kolom;
        this.tabFloat = MSource.tabFloat;
    }

    public float Determinan(float[][] matriks) {
        if (matriks.length==2 && matriks[0].length==2){
            return (matriks[0][0]*matriks[1][1]) - (matriks[0][1]*matriks[1][0]);
        }else if (matriks.length==1 && matriks[0].length==1){
            return matriks[0][0];
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
            determinan += isneg * matriks[i][j] * Determinan(mtmp);
            }
                return determinan;
            }
    }
    
    public float[][] cofactor(float[][] matriks){
        int i, j;
        float[][] mtmp2;
        mtmp2 = new float[matriks.length][matriks[0].length];
        
        float determinan=0;
        for (i=0; i < matriks.length; i++){    
            for (j=0;j < matriks[0].length;j++){  
                float[][] mtmp;
                mtmp = new float[matriks.length-1][matriks[0].length-1];
        
                int k,l;
                for (k=0;k<matriks.length;k++){
                    for (l=0;l < matriks[0].length;l++){
                        if (k > i){
                            if (l<j){
                                mtmp[k-1][l] = matriks[k][l];
                            }else if (l>j){
                                mtmp[k-1][l-1] = matriks[k][l];
                            }
                        }
                        else if (k < i){
                            if (l < j){
                                mtmp[k][l] = matriks[k][l];
                            }
                            else if (l > j){
                                mtmp[k][l-1] = matriks[k][l];
                            }
                        }   
                    }
                }
                determinan = Determinan(mtmp);
                float negatif = (float)Math.pow(-1, i+j);
                mtmp2[i][j] = negatif*determinan;
            }
        }
        return mtmp2;
        
    }
    
    public void transpose(float[][] matriks){
        int i = 0;
        int j = 0;
        while (i < this.getBaris()){
            j = 0;
            j += i;
            while ( j < this.getKolom()){
                float temp = matriks[j][i];
                matriks[j][i] = matriks[i][j];
                matriks[i][j] = temp;
                j += 1;
            }
            i += 1;
        }
    }

    public boolean cantInverse(float[][] matriks){
        int i=0;
        int j=0;
        boolean cant = true;
        while (cant && i<matriks.length){
            while (cant && j<matriks[0].length){
                if (matriks[i][j]!=0){
                    cant=false;
                }
                j+=1;
            }
            i+=1;
        }
        return cant;
    }
    
    public float[][] inverse(float[][] matriks){
        int i, j;
        float det_m;
        float[][] m;
        
        m = new float[matriks.length][matriks[0].length];
        det_m = Determinan(matriks);
        if (det_m!=0){
            if (matriks.length!=2 && matriks[0].length!=2){
                matriks = cofactor(matriks);
                transpose(matriks);
            }else{
                float temp = matriks[0][0];
                matriks[0][0] = matriks[1][1];
                matriks[1][1] = temp;
                
                matriks[0][1] = -matriks[0][1];
                matriks[1][0] = -matriks[1][0];
            }
            for (i = 0; i < matriks.length; i++){
                for (j = 0; j < matriks[0].length; j++){
                    m[i][j] = (matriks[i][j])/(det_m); 
                }
            }
            return m;
        }else{
            for (i = 0; i < matriks.length; i++){
                for (j = 0; j < matriks[0].length; j++){
                    m[i][j] = 0; 
                }
            }
            return m;
        }
    }

    public float[][] kaliMatriks(float[][] matriks1,float[][] matriks2){
        int i, j;
        float[][] mHasilKali;
        mHasilKali = new float[matriks1.length][matriks2[0].length];
        for (i = 0; i < matriks1.length; i++){
            for (j = 0; j < matriks2[0].length; j++){
                for (int k = 0; k < matriks2.length; k++) {
                    mHasilKali[i][j] += (matriks1[i][k] * matriks2[k][j]);
                }
            }
        }
        return mHasilKali;
    }

    public float[][] cariHasil() {
        float[][] hasil = new float[this.tabFloat.length][1];
        float[][] inverseX = new float[this.tabFloat[0].length][this.tabFloat.length];
        inverseX = inverse(this.tabFloat);
        hasil = kaliMatriks(inverseX,this.tabY);
        return hasil;
    }

    public void printHasil(float[][] hasil) {
        for (Integer i = 0; i < hasil.length; i++) {
            System.out.print("Hasil elemen ke-");
            System.out.print(i+1);
            System.out.print(" adalah ");
            System.out.println(hasil[i][0]);
        }
    }

    public void printTxtInverse(float[][] hasil) {
        try {
            String filename = "hasilinverse.txt";
            File myObj = new File(filename);
            FileWriter myWriter = new FileWriter(myObj);
            String s = "";
            String elmnt;
            for (int i = 0; i < hasil.length; i++) {
                for (int j = 0; j < hasil[0].length; j++) {
                    if (j == hasil[0].length-1) {
                        elmnt = Float.toString(hasil[i][j]);
                        s += (elmnt + "\n");
                    } else {
                        elmnt = Float.toString(hasil[i][j]);
                        s += (elmnt + " ");
                    }
                }
            }
            myWriter.write(s);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void printTxtDet(float det) {
        try {
            String filename = "hasildet.txt";
            File myObj = new File(filename);
            FileWriter myWriter = new FileWriter(myObj);
            String s = "";
            s = Float.toString(det);
            myWriter.write("Determinan adalah " + s);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void prosesTxtSPLInv() {
        makeInverse();
        makeMatriksY();
        float[][] inv = new float[getBaris()][getKolom()];
        inv = getWholeTab();
        inv = inverse(inv);
        float[][] matY = getWholeTabY();
        printTxtSPLInv(inv,matY);
    }

    public void printTxtSPLInv(float[][] inv, float[][] matriksY) {
        try {
            String filename = "hasilsplinv.txt";
            File myObj = new File(filename);
            FileWriter myWriter = new FileWriter(myObj);
            String s;
            if (cantInverse(inv)){
                myWriter.write("Solusi tidak dapat dicari karena determinan 0.\n");
            }else{
                float[][] tabTemp = kaliMatriks(inv, matriksY);
                for (int i=0; i<tabTemp.length; i++){
                    myWriter.write("x" +(i+1)+ " = " +tabTemp[i][0] + "\n");
                }
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}


