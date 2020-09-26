package SPL;


public class Main {
    public static void main(String[] args) {
        
        matriks M1 = new matriks();
        M1.makeSPL();
        
        //Matriks M2, matriks yang berisi matriks setelah
        matriks M2 = new matriks();
        M2.copyMatriks(M1);

        M2.setWholeTabFloat(M1.matriksToGauss());

        for(int i=0; i<M2.getBaris(); i++){
            for(int j=0; j<M2.getKolom(); j++){
                System.out.println(M2.getElmt(i, j));
            }
        }
        
        
        
    }
}
