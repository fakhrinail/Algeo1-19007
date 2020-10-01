package SPL;
import java.util.Scanner;

public class regresi {
    private int baris,kolom;
    private float[][] tabX;
    private float[][] tabY;
    private float[] nilaix;

    public void makeRegresi() {
        try (Scanner scan = new Scanner(System.in)) {
            System.out.println("Masukkan jumlah peubah x : ");
            int col = scan.nextInt();
            System.out.println("Masukkan jumlah baris data : ");
            int row = scan.nextInt();

            this.baris = row;
            this.kolom = col;
            this.tabX = new float[row][col];
            this.tabY = new float[row][1];
            this.nilaix = new float[row];

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    System.out.println("Masukkan nilai dari x ke-" + (j+1) + " pada baris ke-" + (i+1) + " : ");
                    this.tabX[i][j] = scan.nextFloat();
                    }
                }

            for (int i = 0; i < row; i++) {
                System.out.println("Masukkan nilai dari y pada baris ke-" + (i+1) + " : ");
                this.tabY[i][0] = scan.nextFloat();
            }
            

            this.nilaix = new float[col];
            for (int i = 0; i < nilaix.length; i++) {
                System.out.println("Masukkan nilai xk ke-" + (i+1) + " : ");
                this.nilaix[i] = scan.nextFloat();
            }
            
        } catch (Exception e) {
            System.out.println("Invalid input");
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
    
    public float[][] transpose(float[][] matriks){
        float[][] matrikst = new float[matriks[0].length][matriks.length];

        for (int i = 0; i < matriks.length; i++) {
            for (int j = 0; j < matriks[0].length; j++) {
                matrikst[j][i] = matriks[i][j];
            }
        }
        return matrikst;
    }

    public float[][] makeSigmaX(float[][] matriksX) {
        float[][] kaliX = new float[matriksX.length][matriksX[0].length+1];
        for (int i = 0; i < kaliX.length; i++) {
            for (int j = 0; j < kaliX[0].length; j++) {
                if (j == 0) {
                    kaliX[i][j] = 1;
                }
                else
                {
                    kaliX[i][j] = matriksX[i][j-1];
                }
            }
        }

        kaliX = kaliMatriks(transpose(kaliX),kaliX);

        return kaliX;
    }

    public float[][] makeSigmaY(float[][] matriksX, float[][] matriksY) {
        float[][] kaliX = new float[matriksX.length][matriksX[0].length+1];
        float[][] kaliY = new float[matriksX.length][matriksY[0].length];
        for (int i = 0; i < kaliX.length; i++) {
            for (int j = 0; j < kaliX[0].length; j++) {
                if (j == 0) {
                    kaliX[i][j] = 1;
                }
                else
                {
                    kaliX[i][j] = matriksX[i][j-1];
                }
            }
        }

        kaliY = kaliMatriks(transpose(kaliX),matriksY);

        return kaliY;
    }

    public float[][] makeSPL() {
        float[][] sigmaX = makeSigmaX(this.tabX);
        float[][] sigmaY = makeSigmaY(this.tabX, this.tabY);
        float[][] spl = new float[sigmaX.length][sigmaX[0].length+1];

        for (int i = 0; i < spl.length; i++) {
            for (int j = 0; j < spl[0].length; j++) {
                if (j == spl[0].length-1)
                {
                    spl[i][j] = sigmaY[i][0];
                }
                else
                {
                    spl[i][j] = sigmaX[i][j];
                }
            }
        }

        return spl;
    }

    public void metodeRegresi() {
        makeRegresi();
        makeSPL();
    }
}
