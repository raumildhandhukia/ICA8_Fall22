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
    public void ReadDataFIleTest() {
        fr = u.readDataFile();
        Assertions.assertNotNull(fr);
        System.out.println("====Raumil Dhandhukia==== Test One Executed ====");
    }

    @Test
    public void readDataFromFile() {
        data = u.readDataFromFile(fr);
        Assertions.assertNotNull(data);
        System.out.println("====Raumil Dhandhukia==== Test Two Executed ====");
    }

    @Test
    public void goodString() {
        assertTrue(u.goodString("10001"));
        assertTrue(u.goodString("1001"));
        assertTrue(u.goodString("00000"));
        assertTrue(u.goodString("0000"));
        assertTrue(u.goodString("01000"));
        assertFalse(u.goodString("011"));
        assertFalse(u.goodString("NAN"));
        System.out.println("====Raumil Dhandhukia==== Test Three Executed ====");
    }

    @Test
    public void getAvailableUrinals(){
        assertEquals(1, (u.getAvailableUrinals("10001")));
        assertEquals(0, (u.getAvailableUrinals("10101")));
        assertEquals(3, (u.getAvailableUrinals("00000")));
        assertEquals(2, (u.getAvailableUrinals("10000")));
        assertEquals(0, (u.getAvailableUrinals("010")));
        assertEquals(1, (u.getAvailableUrinals("100010")));
        System.out.println("====Raumil Dhandhukia==== Test Four Executed ====");
    }
    @Test
    public void getNextFileName(){
        Assertions.assertTrue(u.getNextFileName() != null);
        System.out.println("====Raumil Dhandhukia==== Test Five Executed ====");
    }
    @Test
    public void createOutputFile() throws IOException {
        fr = u.readDataFile();
        Assertions.assertNotNull(fr);
        data = u.readDataFromFile(fr);
        Assertions.assertNotNull(data);
        Assertions.assertTrue(u.createOutputFile(data));
        System.out.println("====Raumil Dhandhukia==== Test Six Executed ====");
    }


}