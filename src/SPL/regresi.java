package SPL;
import java.util.Scanner;

public class regresi {
    private int baris,kolom;
    private float[][] tabFloat;

    public void makeRegresi() {
        try (Scanner scan = new Scanner(System.in)) {
            System.out.println("Masukkan jumlah peubah x : ");
            int col = scan.nextInt()+1;
            System.out.println("Masukkan jumlah baris data : ");
            int row = scan.nextInt();

            this.baris = row;
            this.kolom = col;
            this.tabFloat = new float[row][col];

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (j == col-1) {
                        System.out.println("Masukkan nilai dari y pada kolom ke-" + (i+1) + " : ");
                        this.tabFloat[i][j] = scan.nextFloat();
                    }
                    else {
                        System.out.println("Masukkan nilai x ke-" + (j+1) + " : ");
                        this.tabFloat[i][j] = scan.nextFloat();
                    }
                }
            }

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    System.out.print(this.tabFloat[i][j] + " ");
                }
                System.out.println();
            }

            
        } catch (Exception e) {
            System.out.println("Invalid input");
        }
    }

    public void metodeRegresi() {
        
    }
}
