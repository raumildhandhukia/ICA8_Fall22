import java.io.*;
public class Urinal {

    public FileReader readDataFile(){

        try{
            FileReader fr = new FileReader("src/urinal.dat");
            return fr;
        }
        catch (Exception e){
            return null;
        }

    }
}
