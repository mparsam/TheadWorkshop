public class Example4 {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.println("This from inline runnable "+ Thread.currentThread().getName());
        };

        Thread t = new Thread(runnable, "myThread"); // add name
        t.start();
    }
}
