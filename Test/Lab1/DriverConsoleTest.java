package Lab1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class DriverConsoleTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @BeforeEach
    //for console output testing
    public void setUpStreams(){
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @Test
    public void testDriverNumValidMsg() throws IOException{
        System.setOut(new PrintStream(outContent));
        Driver driver1 = new Driver("Ben",4000);
        driver1.checkNumberValid();
        outContent.flush();
        String[] linesOfOutput = outContent.toString().split(System.lineSeparator());
        assertEquals("Driver number valid",linesOfOutput[0]);
    }

    @Test
    public void testDriverNumValidMsg2() throws IOException{
        System.setOut(new PrintStream(outContent));
        Driver driver1 = new Driver("Ben",5001);
        driver1.checkNumberValid();
        outContent.flush();
        String[] linesOfOutput = outContent.toString().split(System.lineSeparator());
        assertEquals("Error Driver number not valid",linesOfOutput[0]);
    }
}