package SPL;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileInputStream;

import java.util.Arrays;
import java.util.Scanner;

public class Input {
    private static int menghitungKolom(String namaFile) {
        File file = new File(namaFile);
        Scanner scanner;
        int number = 0;
        try{
            scanner = new Scanner(file);
            if (scanner.hasNextLine()) {
                number = scanner.nextLine().split(" ").length;
            }
            scanner.close();
        }catch (FileNotFoundException e){
        }
        return number;
    }

    private static int menghitungBaris(String namaFile) throws Exception{
        File file = new File(namaFile);
        
        FileInputStream fis = new FileInputStream(file);
        byte[] byteArray = new byte[(int)file.length()];
        fis.read(byteArray);
        String data = new String(byteArray);
        String[] stringArray = data.split("\r\n");
        fis.close();
        return stringArray.length;
        
    }

    public static float[][] input(String namaFile) throws Exception {

        String pathFile = "test\\" + namaFile;
        Scanner sc = new Scanner(new BufferedReader(new FileReader(pathFile)));
      
        int kolomFile = menghitungKolom(pathFile);
        int barisFile = menghitungBaris(pathFile);

        float [][] matriksDibaca = new float[barisFile][kolomFile];
        while(sc.hasNextLine()) {
            for (int i=0; i<matriksDibaca.length; i++) {
                String[] line = sc.nextLine().trim().split(" ");
            for (int j=0; j<line.length; j++) {
                matriksDibaca[i][j] = Integer.parseInt(line[j]);
            }
         }
      }
      return matriksDibaca;
   }



}