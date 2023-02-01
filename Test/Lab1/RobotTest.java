package Lab1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.*;

    class RobotTest {
        Robot buddy = new Robot("buddy");

        @Test
        public void getName(){
            assertEquals("buddy",buddy.getName());
        }

        @Test
        public void isNotWorking() {
            assertFalse(buddy.isWorking());
        }

        @Test
        public void isWorking() {
            buddy.talkToRobot();
            assertTrue(buddy.isWorking());
        }

        @Test
        public void getWorkingMsg(){
            buddy.talkToRobot();
            assertEquals("I am in working mode",buddy.getWorkingMsg());
        }

        @Test
        @DisplayName("getWorkingMsgFail catch the exception")
        public void getWorkingMsgFail(){
            assertThrows(IllegalStateException.class, ()->{
                buddy.getWorkingMsg();
            });
        }

        @Test
        void timeoutExceeded(){
            assertTimeout(ofMillis(10),()->
            {
                buddy.waitTillWorking();
            });
        }

    }
