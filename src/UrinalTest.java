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
        fr = Urinal.readDataFile("src/urinal.dat");
    }

    @AfterEach
    void tearDown() {
    }


    @Test
    public void ReadDataFIleTest() {
        fr = Urinal.readDataFile("src/urinal.dat");
        Assertions.assertNotNull(fr);
        System.out.println("====Raumil Dhandhukia==== Test One Executed ====");
    }

    @Test
    public void readDataFromFile() {
        data = Urinal.readDataFromFile(fr);
        Assertions.assertNotNull(data);
        System.out.println("====Raumil Dhandhukia==== Test Two Executed ====");
    }

    @Test
    public void goodString() {
        assertTrue(Urinal.goodString("10001"));
        assertTrue(Urinal.goodString("1001"));
        assertTrue(Urinal.goodString("00000"));
        assertTrue(Urinal.goodString("0000"));
        assertTrue(Urinal.goodString("01000"));
        assertFalse(Urinal.goodString("011"));
        assertFalse(Urinal.goodString("NAN"));
        System.out.println("====Raumil Dhandhukia==== Test Three Executed ====");
    }

    @Test
    public void getAvailableUrinals(){
        assertEquals(1, (Urinal.getAvailableUrinals("10001")));
        assertEquals(0, (Urinal.getAvailableUrinals("1001")));
        assertEquals(3, (Urinal.getAvailableUrinals("00000")));
        assertEquals(2, (Urinal.getAvailableUrinals("0000")));
        assertEquals(1, (Urinal.getAvailableUrinals("01000")));
        assertEquals(0, (Urinal.getAvailableUrinals("011")));
        System.out.println("====Raumil Dhandhukia==== Test Four Executed ====");
    }
    @Test
    public void getNextFileName(){
        Assertions.assertTrue(Urinal.getNextFileName() != null);
        System.out.println("====Raumil Dhandhukia==== Test Five Executed ====");
    }
    @Test
    public void createOutputFile() throws IOException {
        fr = Urinal.readDataFile("src/urinal.dat");
        Assertions.assertNotNull(fr);
        data = Urinal.readDataFromFile(fr);
        Assertions.assertNotNull(data);
        Assertions.assertTrue(Urinal.createOutputFile(data));
        System.out.println("====Raumil Dhandhukia==== Test Six Executed ====");
    }

    @Test
    public void createOutputFileWithEmptyData() throws IOException {
        fr = Urinal.readDataFile("src/urinal_empty.dat");
        Assertions.assertNotNull(fr);
        data = Urinal.readDataFromFile(fr);
        Assertions.assertNotNull(data);
        Assertions.assertFalse(Urinal.createOutputFile(data));
        System.out.println("====Raumil Dhandhukia==== Test Seven Executed ====");
    }

    @Test
    public void FileNotExistsTest() throws IOException {
        fr = Urinal.readDataFile("src/urinal_x.dat");
        Assertions.assertNotNull(fr);
        data = Urinal.readDataFromFile(fr);
        Assertions.assertNull(data);
        System.out.println("====Raumil Dhandhukia==== Test Eight Executed ====");


    }


}