package SPL;

import java.util.Scanner;

/**
 * matriks
 */
public class matriks {

    private int baris,kolom;
    private float[][] tabFloat;

    /*CONSTRUCTOR*/
    public void makeSPL(){
        try (Scanner scan = new Scanner(System.in)) {
            System.out.println("Input your row of matrix : ");
            int row = scan.nextInt();
            System.out.println("Input your column of matrix : ");
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
    public void copyMatriks(matriks MSource){
        this.baris = MSource.baris;
        this.kolom = MSource.kolom;
        this.tabFloat = MSource.tabFloat;
    }

    private void divideAllbyLeading(int rowLeading, float[][] MTarget){
        float divider = MTarget[rowLeading][rowLeading];
        for (int j=rowLeading; j<this.getKolom();j++){
            float newValue = MTarget[rowLeading][j]/divider;
            MTarget[rowLeading][j] = newValue;
        }
    }

    private void exchangeRow(int row1, int row2, float[][] MTarget){
        float temp;
        for (int j=0; j<this.getKolom(); j++){
            temp = MTarget[row1][j];
            MTarget[row1][j] = MTarget[row2][j];
            MTarget[row2][j] = temp;
        }
    }

    private void searchNonZeroValue(int row, int column, float[][] MTarget){
        
        boolean ketemu = false;
        int i = 0;

        while (i < this.getBaris() && !ketemu){
            if (MTarget[i][column]!=0){
                exchangeRow(row, i, MTarget);
                ketemu = true;
            }
        }
    }

    private void makeElmtBeforeLeadingToZero(int rowLeading, int columnLeading, float[][] MTarget){
        for (int j=0; j<columnLeading; j++){
            if (MTarget[rowLeading][j]!=0){
                substractionRow(rowLeading, j, MTarget);
            }
        }

    }

    private void substractionRow(int row1, int row2, float[][] MTarget){
        float multiplier = MTarget[row1][row2] / MTarget[row2][row2];
        for (int j=0; j<this.getKolom(); j++){
            float valRow1 = MTarget[row1][j];
            float valRow2 = MTarget[row2][j];

            float newValue = valRow1 - (valRow2*multiplier);
            
            MTarget[row1][j] = newValue;
        }
    }

    public float[][] matriksToGauss(){
        
        float[][] MGauss = new float[this.baris][this.kolom];
        MGauss = this.tabFloat;
        for (int i=0; i<this.getBaris(); i++){
            for (int j=0; j<i+1; j++){
                if (i!=j){
                    if (MGauss[i][j]!=0){
                        makeElmtBeforeLeadingToZero(i, j+1, MGauss);
                    }
                }else if (i==j){
                    if (MGauss[i][j]==0){
                        searchNonZeroValue(i, j, MGauss);
                        makeElmtBeforeLeadingToZero(i, j, MGauss); 
                        divideAllbyLeading(i, MGauss);               
                    }else if (MGauss[i][j]!=1){
                        divideAllbyLeading(i, MGauss);
                    }
                }
            }
        }



        return MGauss;
    }

}