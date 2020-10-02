package SPL;

import java.util.Scanner;
import java.lang.Math;

public class interpolasi {
    private int baris,kolom;
    private float[][] tabFloat;

    /*CONSTRUCTOR*/
    public void makeInterpolasi(){
        try (Scanner scan = new Scanner(System.in)) {
            System.out.println("Masukkan banyak titik: ");
            int n = scan.nextInt();
            
            this.setBaris(n);
            this.setKolom(2);
            this.tabFloat = new float[n][2];

            for (int i = 0; i < this.getBaris(); i++) {
                for (int j = 0; j < this.getKolom(); j++) {
                    if (j==0){
                        System.out.println("Masukkan nilai x dari titik ke-" + (i+1));
                        this.setElmt(scan.nextFloat(), i,j);
                    }else{
                        System.out.println("Masukkan nilai y dari titik ke-" + (i+1));
                        this.setElmt(scan.nextFloat(), i,j);
                    }
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
    public void copyInterpolasi(interpolasi MSource){
        this.baris = MSource.baris;
        this.kolom = MSource.kolom;
        this.tabFloat = MSource.tabFloat;
    }

    public float[][] convertToMatriks(){
        float[][] matriksSPL = new float[this.getBaris()][this.getBaris()+1];

        int i;
        for (i=0; i<this.getBaris(); i++){
            int j = 0;
            while (j<this.getBaris()+1){
                if (j==this.getBaris()){
                    matriksSPL[i][j] = this.getElmt(i, 1);                    
                }else{
                    double nilaiX = (double) this.getElmt(i, 0);
                    matriksSPL[i][j] = (float) Math.pow(nilaiX, j);
                }
                j+=1;
            }
        }
        return matriksSPL;
    }

    public void outputInterpolasi(float x, float[][] matriksGaussJordan){
        float[] membantuPerhitungan = new float[this.getBaris()];
        String ln = "";
        float value = 0;
        for (int i = 0; i<this.getBaris(); i++){
            membantuPerhitungan[i] = matriksGaussJordan[i][this.getBaris()];
            value += membantuPerhitungan[i]*Math.pow(x, i);
            if (membantuPerhitungan[i]>=0 && i==0){
                ln = ln + membantuPerhitungan[i] + "x^" + i + " ";
            }else if(membantuPerhitungan[i]>=0 && i!=0){
                ln = ln +"+ "+ membantuPerhitungan[i] + "x^" + i + " ";
            }else if(membantuPerhitungan[i]<0 && i==0){
                ln = ln + membantuPerhitungan[i] + "x^" + i + " ";
            }else if(membantuPerhitungan[i]<0 && i!=0){
                ln = ln + "- " + (-membantuPerhitungan[i]) + "x^" + i + " ";
            }
        }
        System.out.println(ln);
        System.out.println("Perkiraan hasil polinom: " + value);
        Inverse inv = new Inverse();
        inv.printTxtInterpolasi(ln, value);
    }

}
