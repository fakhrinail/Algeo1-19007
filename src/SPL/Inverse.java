package SPL;
import java.util.Scanner;
import java.lang.Math;

public class Inverse {
    private int baris,kolom;
    private float[][] tabFloat;

    public void makeInverse() {
        try (Scanner scan = new Scanner(System.in)) {
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
    public float[][] getWholeTab(){
        return this.tabFloat;
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
                    determinan = Determinan(mtmp);
                    }
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
    
    public float[][] inverse(float[][] matriks){
        int i, j;
        float det_m;
        float[][] m;
        
        m = new float[matriks.length][matriks[0].length];
        det_m = Determinan(matriks);
        matriks = cofactor(matriks);
        transpose(matriks);
        for (i = 0; i < matriks.length; i++){
            for (j = 0; j < matriks[0].length; j++){
                m[i][j] = (matriks[i][j])/(det_m); 
            }
            
        
        }
        return m;
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
}

