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
        Assertions.assertEquals(1, u.goodString("10001"));
        Assertions.assertEquals(1, u.goodString("1001"));
        Assertions.assertEquals(1, u.goodString("00000"));
        Assertions.assertEquals(1, u.goodString("0000"));
        Assertions.assertEquals(1, u.goodString("01000"));
        Assertions.assertEquals(-1, u.goodString("011"));
        Assertions.assertEquals(-1, u.goodString("NAN"));
        System.out.println("====Raumil Dhandhukia==== Test Three Executed ====");
    }


}