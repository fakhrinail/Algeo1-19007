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

    public float[][] getWholeTab(){
        return this.tabFloat;
    }

    /*METHOD*/
    public void copyMatriks(matriks MSource){
        this.baris = MSource.baris;
        this.kolom = MSource.kolom;
        this.tabFloat = MSource.tabFloat;
    }

    private void divideAllbyLeading(int rowLeading, int columnLeading, float[][] MTarget){
        float divider = MTarget[rowLeading][columnLeading];
        for (int j=columnLeading; j<this.getKolom();j++){
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
        int i = row;
        int j = column;

        while (j<this.getKolom() && MTarget[i][j]==0){
            j+=1;
        }
                  
        j-=1;               //dikurangi 1 karena kita ingin indeks menunjuk elemen yang bernilai 0 paling kanan dari kolom leading        

        while (i < this.getBaris() && !ketemu && j>=0){
            if (MTarget[i][j]!=0){
                exchangeRow(row, i, MTarget);
                ketemu = true;
            }
            
            if (i==this.getBaris()-1 && ketemu==false){        //belum ketemu dan sudah mentok
                i = row;
                j -= 1;
            }else{
                i+=1;
            }  
        }
    }

    private void makeElmtBeforeLeadingToZero(int row, int column, int rowLeading, float[][] MTarget){
        for (int j=0; j<column; j++){
            if (row>j){
                if (MTarget[row][j]!=0){
                    substractionRow(row, j, MTarget);
                }
            }else{
                if (MTarget[row][j]!=0){
                    float multiplier = MTarget[row][j] / MTarget[rowLeading-1][j];  //ini j tadinya column, sebelum soal c
                    for (int k=0; k<this.getKolom(); k++){
                        float valRow1 = MTarget[row][k];
                        float valRow2 = MTarget[rowLeading-1][k];
            
                        float newValue = valRow1 - (valRow2*multiplier);
                        
                        MTarget[row][k] = newValue;
                    }
                }
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

        int rowLeading=0;
        int columnLeading=0;

        for (int i=0; i<this.getBaris(); i++){
            
            for (int j=0; j<columnLeading+1 && j<this.getKolom(); j++){
                if (i!=rowLeading || j!=columnLeading){
                    if (MGauss[i][j]!=0){
                        makeElmtBeforeLeadingToZero(i, j+1, rowLeading, MGauss);
                    }
                }else{
                    if (MGauss[rowLeading][columnLeading]==0){
                        
                        int iterasiMentok = 0;
                        while (MGauss[rowLeading][columnLeading]==0 && iterasiMentok < this.getBaris()-i){        //mengantisipasi kemungkinan setelah diproses masih 0 0 juga
                            searchNonZeroValue(rowLeading, columnLeading, MGauss);
                            makeElmtBeforeLeadingToZero(rowLeading, columnLeading, rowLeading, MGauss);
                            iterasiMentok += 1;
                        }
                        if (MGauss[rowLeading][columnLeading]==0){   // jika setelah dicari element leading masih 0
                            boolean nol = true;
                            int k = columnLeading;      //variabel iterasi di kolom baris i
                            while (nol && k<this.getKolom()){
                                if (MGauss[rowLeading][k]!=0){       //elemen yang tidak bernilai 0 ketemu
                                    nol = false;
                                    divideAllbyLeading(rowLeading, k, MGauss);
                                    columnLeading = k;
                                }else{
                                    k+=1;
                                }
                                
                            }
                        }else{
                            makeElmtBeforeLeadingToZero(i, j, rowLeading, MGauss);
                            divideAllbyLeading(i, j, MGauss);
                        } 
                                       
                    }else if (MGauss[rowLeading][columnLeading]!=1 && MGauss[rowLeading][columnLeading]!=0){
                        divideAllbyLeading(i, j, MGauss);
                    }
                }
            }
            rowLeading+=1;
            columnLeading+=1;
        }

        return MGauss;
    }
    
    public void gaussToGaussJordan(float[][] MGaussToJordan){
        for (int i=0; i<this.getBaris()-1;i++){
            for (int iterasiBaris=i+1; iterasiBaris<this.getBaris(); iterasiBaris++){
                int j = 0;
                while (j<this.getKolom()-2 && MGaussToJordan[iterasiBaris][j]==0){  //dikurangi 2 agar pada kasus tidak terdefinisi nilai y tidak menjadi 0
                    j+=1;
                }
                if (MGaussToJordan[iterasiBaris][j]==1){
                    float pengali = MGaussToJordan[i][j];
                    for (int k=0; k<this.getKolom(); k++){
                        float val1 = MGaussToJordan[i][k];
                        float val2 = MGaussToJordan[iterasiBaris][k];
                        MGaussToJordan[i][k] = val1 - (pengali*val2);
                    }
                }
            }
        }
    }

    public void outputHasil(float[][] matriksFix){
        String[] penyimpanNilai = new String[this.getKolom()-1];
        
        for (int k=0; k<this.getKolom()-1; k++){
            penyimpanNilai[k] = "x" + (k+1);
        }

        boolean define = true;
        int i=this.getBaris()-1;
        while (i>=0 && define==true){
            int j=0;
            
            String perLine =  matriksFix[i][this.getKolom()-1] + "";
        
            while(j<=this.getKolom()-2 && matriksFix[i][j]==0){
                    j+=1;
            }
            if (j == this.getKolom()-1 && matriksFix[i][j]!=0){
                System.out.println("Solusi tidak ada.");
                define=false;
                i-=1;
            }else if(j == this.getKolom()-1 && matriksFix[i][j]==0){
                i-=1;
            }else{
                int l;
                for (l=j+1; l<=this.getKolom()-2; l++){
                    if (matriksFix[i][l]!=0){
                        if (matriksFix[i][l]>=0){
                            perLine = perLine + " - " + matriksFix[i][l] + penyimpanNilai[l];
                        }else{
                            perLine = perLine + " + " + (-matriksFix[i][l]) + penyimpanNilai[l];
                        }
                        
                    }
                }
                System.out.println(penyimpanNilai[j] + " = " + perLine);
                penyimpanNilai[j] = "DONE";
                i-=1;
            } 
        }
        if (define){
            for (int m=0; m<this.getKolom()-1; m++){
                if (penyimpanNilai[m]!="DONE"){
                    System.out.println(penyimpanNilai[m] + " = " + penyimpanNilai[m]);
                }
            }
        }
    }

    public void printTxt(float[][] matriksFix) {
        try {
            String filename = "hasilgauss.txt";
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

}