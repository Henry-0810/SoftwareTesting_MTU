package Lab1;
import org.junit.jupiter.api.Disabled;

import static java.lang.Thread.sleep;

public class Robot {
    private String name;
    private int age;

    public boolean working;
    public Robot(String name,int age) {
        setName(name);
        setAge(age);
    }

    public void setName(String name) {
        if(name.isEmpty()){
            throw new IllegalArgumentException();
        }
        this.name = name;
    }
    public void setAge(int age) {
        if(age <= 30) this.age = age;
        else throw new IllegalArgumentException();
    }

    public String getName() {
        return name;
    }

    public boolean isWorking() {
        return working;
    }

    public void talkToRobot(){
        working = true;
    }

    public String getWorkingMsg() {
        if (!working) {
            throw new IllegalStateException();
        }
        return "I am in working mode";
    }
    public void waitTillWorking() throws InterruptedException{
        {
            sleep(100);
        }
    }

    public void turnoffRobot() { working=false; }

    public String checkAge(){
        return (age<=20)?"Age ok":"Too old";
    }

    public double checkCost(){
        if (age <= 5) {
            return 10000.00;
        }
        else if (age <= 10) {
            return 7500.00;
        }
        else return 5000.00;
    }

    public void sendAgeMsg() throws IllegalArgumentException{
        try{
            if(age > 25){
                throw new IllegalArgumentException("Age too old");
            }
        }
        catch(IllegalArgumentException e){
            System.out.println("Error " + e.getMessage());
        }
        System.out.println("Age ok");
    }
}