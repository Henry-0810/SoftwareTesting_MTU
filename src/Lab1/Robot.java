package Lab1;
import static java.lang.Thread.sleep;

public class Robot {
    private String name;
    public boolean working;
    public Robot(String name) {
        setName(name);
    }

    public void setName(String name) {
        if(name.isEmpty()){
            throw new IllegalArgumentException();
        }
        this.name = name;
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
}