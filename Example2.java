public class Example2 {

    public static class testRunnable implements Runnable{
        @Override
        public void run(){
            System.out.println("Hello! I am testRunnable and RUNNING!");
        }
    }
    public static void main(String[] args) {
        Thread thread = new Thread(new testRunnable());
        thread.start();
    }
}
