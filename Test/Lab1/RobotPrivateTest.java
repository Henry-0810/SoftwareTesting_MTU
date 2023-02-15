package Lab1;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class RobotPrivateTest {
    @Test
    public void testageMember() throws Exception {
        System.out.println("testageMember");
        Robot target = new Robot("robbie", 5);

        Class secretClass = target.getClass();

        //retrieve field age
        Field f = secretClass.getDeclaredField("age");

        //make sure the field is accessible
        f.setAccessible(true);

        //get the value of the field
        System.out.println("The value in f (age) is " + f.get(target));

        int result = f.getInt(target);

        assertEquals(5,result);
    }
}