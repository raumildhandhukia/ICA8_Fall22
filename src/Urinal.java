import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Urinal {

    public boolean goodString(String input){
        int len = input.length();
        for(int i = 0;i < len; i++){
           if (input.charAt(i) != '1' && input.charAt(i) != '0'){
               return false;
           }
           if (input.charAt(i) == '1'){
               if (i+1 < len && input.charAt(i+1) == '1'){
                   return false;
               }
           }
        }
        return true;
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

    public int getAvailableUrinals(String input){
        int counter=0;
        int len = input.length();
        StringBuffer SB = new StringBuffer(input);
        {
            for(int i=0;i<len;i++){
                if (i==0){
                if(SB.charAt(0)=='0' && SB.charAt(1)=='0'){
                    counter++;
                    SB.setCharAt(0, '1');
                }} else if (i==len-1){
                    if(SB.charAt(len-1)=='0' && SB.charAt(len-2)=='0'){
                        counter++;
                        SB.setCharAt(len-1, '1');
                    }
                }else{
                if(SB.charAt(i-1)=='0' && SB.charAt(i+1)=='0'  && SB.charAt(i)=='0'){
                    counter++;
                    SB.setCharAt(i, '1');
                }}

            }

        }
        return counter;

    }

}
