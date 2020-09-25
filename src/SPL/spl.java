package SPL;
import java.util.Scanner;

/**
 * spl
 */
public class spl {
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            System.out.println("Input your row of matrix : ");
            int row = scan.nextInt();
            System.out.println("Input your column of matrix : ");
            int column = scan.nextInt();
            int[][] matrix = new int[row][column];
            
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    System.out.println("Masukkan nilai elemen baris ke-" + (i+1) + " kolom ke-" + (j+1) +": ");
                    matrix[i][j] = scan.nextInt();
                }
            }
            
        } catch (Exception e) {
            System.out.println("Invalid input");
        }
    }
}