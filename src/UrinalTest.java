import org.junit.jupiter.api.*;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class UrinalTest {

    Urinal u = new Urinal();

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }


    @Test
    public void ReadDataFIleTest(){
        FileReader test2 = u.readDataFile();
        Assertions.assertNotNull(test2);
    }


}