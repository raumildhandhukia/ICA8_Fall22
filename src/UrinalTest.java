import org.junit.jupiter.api.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;

class UrinalTest {
    File fr = null;
    ArrayList<String> data = null;

    Urinal u = new Urinal();

    @BeforeEach
    void setUp() {
        fr = u.readDataFile();
    }

    @AfterEach
    void tearDown() {
    }


    @Test
    public void ReadDataFIleTest(){
        fr = u.readDataFile();
        Assertions.assertNotNull(fr);
    }

    @Test
    public void readDataFromFile(){
        data = u.readDataFromFile(fr);
        Assertions.assertNotNull(data);
    }


}