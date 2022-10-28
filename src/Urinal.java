import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Urinal {

    public int goodString(String input){
        int len = input.length();
        for(int i = 0;i < len; i++){
           if (input.charAt(i) != '1' && input.charAt(i) != '0'){
               return -1;
           }
           if (input.charAt(i) == '1'){
               if (i+1 < len && input.charAt(i+1) == '1'){
                   return -1;
               }
           }
        }
        return 1;
    }

    public File readDataFile() {
        try {
            File file = new File("src/urinal.dat");
            return file;
        } catch (Exception e) {
            return null;
        }
    }

    public ArrayList<String> readDataFromFile(File file) {
        int i;
        ArrayList<String> data = new ArrayList<String>();
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                data.add(sc.nextLine());
            }
            return data;
        } catch (FileNotFoundException ex) {
            System.out.println("File not found...");
            return null;
        }
    }

    public void createOutputFile(ArrayList<String> data){
        for (String input : data) {
            System.out.println(input);
        }
    }
}
