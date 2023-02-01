package Lab1;

import org.junit.jupiter.api.Test;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.*;

class DriverTest {
    Driver driver1 = new Driver("Henry",12345);

    //Test constructor
    @Test
    public void getDriverName(){
        assertEquals("Henry",driver1.getDriverName());
    }

    @Test
    public void getDriverNum(){
        assertEquals(12345,driver1.getDriverNum());
    }

    @Test
    public void test_DriverNameFail(){
        assertThrows(IllegalArgumentException.class, ()->{
            Driver Rick = new Driver("",101);
        });
    }

    @Test
    public void test_DriverNumFail(){
        assertThrows(IllegalArgumentException.class, ()->{
            Driver Ricky = new Driver("Ricky",80);
        });
    }

    @Test
    public void checkStatusBanned(){
        assertFalse(driver1.check_status());
    }

    @Test
    void timeoutExceeded(){
        assertTimeout(ofMillis(10),()->{
            driver1.waitTillbanned();
        });
    }
}