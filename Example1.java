import java.time.LocalTime;
import java.util.Scanner;

public class Example1 {
    public static void main(String[] args) throws InterruptedException {
        GetEnterPress a = new GetEnterPress();
        a.start();
        while(true){
            LocalTime currentTime = LocalTime.now();
            System.out.println("Time: " + currentTime);
            System.out.println("Press Enter to exit");
            Thread.sleep(500);
            clearScreen();
            if (!a.isAlive()){
                break;
            }
        }
    }

    public static void clearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}


class GetEnterPress extends Thread{
    @Override
    public void run() {
        Scanner s = new Scanner(System.in);
        String a = s.nextLine();
    }
}
