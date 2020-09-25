package SPL;

/**
 * spl
 */
public class spl {

    private int baris,kolom;
    private float[][] SPL;

    public void makeSPL(int row, int column){
        this.baris = row;
        this.kolom = column;
        this.SPL = new float[row][column];
    }

    public int getBaris(){
        return baris;
    }

    public int getKolom(){
        return kolom;
    }

    public float getElmt(int row, int column){
        return SPL[row][column];
    }

    public void setElmt(float value, int row, int column){
        this.SPL[row][column] = value;
    }

}