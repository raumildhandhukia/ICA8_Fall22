import org.junit.jupiter.api.Assertions;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;


public class Urinal {


    public static boolean goodString(String input) {
        int len = input.length();
        if (len > 20) {
            return false;
        }
        for (int i = 0; i < len; i++) {
            if (input.charAt(i) != '1' && input.charAt(i) != '0') {
                return false;
            }
            if (input.charAt(i) == '1') {
                if (i + 1 < len && input.charAt(i + 1) == '1') {
                    return false;
                }
            }
        }
        return true;
    }

    public static File readDataFile(String fileName) {
        try {
            File file = new File(fileName);
            return file;
        } catch (Exception e) {
            return null;
        }
    }

    public static ArrayList<String> readDataFromFile(File file) throws FileNotFoundException {
        int i;
        ArrayList<String> data = new ArrayList<String>();
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                data.add(sc.nextLine());
            }
            return data;
        } catch (Exception e){
            System.out.println("Caught inside readDataFromFile");
            return null;
        }
    }

    public static String getNextFileName() {
        File folder = new File("src/");
        File[] listOfFiles = folder.listFiles();
        String fileName;
        int number = 0;
        int k;
        int len = listOfFiles.length;
        if (len > 0) {
            for (int i = 0; i < len; i++) {
                if (listOfFiles[i].isFile()) {
                    fileName = listOfFiles[i].getName();
                    int fileNameLength = fileName.length();
                    if (fileNameLength > 8) {
                        if (fileName.substring(0, 4).equals("rule") && fileName.substring(fileNameLength - 4, fileNameLength).equals(".txt")) {
                            String FN = fileName.substring(0,fileNameLength - 4);
                            String numberString = fileName.substring(0,fileNameLength - 4).split("rule",2)[1];
                            try{
                                k = Integer.parseInt(numberString);
                                if (k > number){
                                    number = k;
                                }
                            }
                            catch (Exception e){
                                System.out.println("Not a rule file.");
                            }
                        }
                    }
                }
            }
        }
        number++;
        String num = Integer.toString(number);
//        System.out.println("rule" + num + ".txt");
        return "rule" + num + ".txt";

    }

    public static boolean createOutputFile(ArrayList<String> data) throws IOException {
        String fileName=getNextFileName();
        File file = new File("src/" + fileName);
        FileWriter writer = new FileWriter(file);
        boolean hasWritten = false;
        for (String input : data) {
            if (goodString(input)) {
                int count = getAvailableUrinals(input);
                writer.write(String.valueOf(count));
                writer.write("\n");
                hasWritten = true;
            } else{
                writer.write(String.valueOf(-1));
                writer.write("\n");
                hasWritten = true;
            }
        }
        if (hasWritten){
            System.out.println("Output file has been written. File name is " + fileName);
        }
        writer.close();
        return hasWritten;
    }

    public static int getAvailableUrinals(String input) {
        int counter = 0;
        int len = input.length();
        StringBuffer SB = new StringBuffer(input);
        {
            for (int i = 0; i < len; i++) {
                if (i == 0) {
                    if (SB.charAt(0) == '0' && SB.charAt(1) == '0') {
                        counter++;
                        SB.setCharAt(0, '1');
                    }
                } else if (i == len - 1) {
                    if (SB.charAt(len - 1) == '0' && SB.charAt(len - 2) == '0') {
                        counter++;
                        SB.setCharAt(len - 1, '1');
                    }
                } else {
                    if (SB.charAt(i - 1) == '0' && SB.charAt(i + 1) == '0' && SB.charAt(i) == '0') {
                        counter++;
                        SB.setCharAt(i, '1');
                    }
                }

            }

        }
        return counter;

    }
    public static void main(String[] args) throws IOException {

        File fr = null;
        ArrayList<String> data = null;
        boolean statusWrite = false;
        fr = Urinal.readDataFile("src/urinal.dat");
        data = Urinal.readDataFromFile(fr);
        statusWrite = Urinal.createOutputFile(data);
    }

}
