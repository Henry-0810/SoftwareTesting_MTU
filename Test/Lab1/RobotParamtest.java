package Lab1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class RobotParamtest {
    private String expected;
    private int age;

    @ParameterizedTest
    @CsvSource({"10,Age ok","20,Age ok","25,Too old"})
    void testCheckAgeAll(int age, String expected){
        Robot buddy = new Robot("buddy",age);
        assertEquals(expected,buddy.checkAge());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "TestResources/ParamTestFile.csv",numLinesToSkip = 1)
    void testCheckAgeAll2(int age,String expected){
        Robot buddy = new Robot("buddy",age);
        assertEquals(expected,buddy.checkAge());
    }

    @ParameterizedTest
    @CsvSource({"10,7500.00","5,10000.00","20,5000.00"})
    void testCheckCostAll(int age, double expectedCost){
        Robot robot1 = new Robot("Robot1",age);
        assertEquals(expectedCost,robot1.checkCost());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "TestResources/ParamTestFileCost.csv",numLinesToSkip = 2)
    void testCheckCostAll2(int age,double expectedCost){
        Robot buddy = new Robot("buddy",age);
        assertEquals(expectedCost,buddy.checkCost());
    }
}