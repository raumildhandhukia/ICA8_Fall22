import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Urinal {

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


}
