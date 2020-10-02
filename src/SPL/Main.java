package SPL;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        System.out.println("MENU");
        System.out.println("1. Sistem Persamaan Linier");
        System.out.println("2. Determinan");
        System.out.println("3. Matriks balikan");
        System.out.println("4. Interpolasi Polinom");
        System.out.println("5. Regresi linier berganda");
        System.out.println("6. Keluar");

        int menu = scan.nextInt();

        if (menu == 1) {
            Menu.SPL();
        } else if (menu == 2) { // Determinan
            Menu.Determinan();
        } else if (menu == 3) { //matriks balikan
            Menu.MatriksBalikan();
        } else if (menu == 4) { //interpolasi
            Menu.Interpolasi();
        } else if (menu == 5) {
            Menu.Regresi();
        } else if (menu == 6) {
            System.out.println("Terima kasih!");
            return;
        }
    }
}






