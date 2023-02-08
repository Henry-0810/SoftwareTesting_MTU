package Lab1;

import org.junit.jupiter.api.*;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.*;

    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class RobotTest {
        Robot buddy;

        @BeforeAll
        public void setup() {
            buddy = new Robot("buddy",10);
            System.out.println("in setup");
        }

        @BeforeEach
        void init() throws NoSuchFieldException, IllegalAccessException {
            buddy.turnoffRobot();

            System.out.println("Run's everytime a test is tested");
        }

        @Test
        @Order(1)
        public void getName(){
            assertEquals("buddy",buddy.getName());
        }

        @Test
        @Order(3)
        public void isNotWorking() {
            assertFalse(buddy.isWorking());
        }

        @Test
        @Order(2)
        public void isWorking() {
            buddy.talkToRobot();
            assertTrue(buddy.isWorking());
        }

        @Test
        @Order(4)
        public void getWorkingMsg(){
            buddy.talkToRobot();
            assertEquals("I am in working mode",buddy.getWorkingMsg());
        }

        @Test
        @Order(6)
        @DisplayName("getWorkingMsgFail catch the exception")
        public void getWorkingMsgFail(){
            assertThrows(IllegalStateException.class, ()->{
                buddy.getWorkingMsg();
            });
        }

        @Test
        @Order(5)
        @Disabled("Disable until DB connected")
        void timeoutExceeded(){
            assertTimeout(ofMillis(10),()->
            {
                buddy.waitTillWorking();
            });
        }

        @AfterAll
        public static void cleanUp(){
            System.out.println("All test done");
        }

        @AfterEach
        public void cleanUpEach(){
            System.out.println("Test done after each");
        }
    }
