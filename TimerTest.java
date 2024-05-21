import java.util.*;

public class TimerTest {
    public static void main(String[] args) {

        // creating timer task, timer
        TimerTask tasknew = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Hello!!!");
            }
        };
        Timer timer = new Timer();

        // scheduling the task at interval
        timer.schedule(tasknew,1, 1000);
    }
    // this method performs the task

    public void run() {
        System.out.println("timer working");
    }
}