public class Example3 {
    public static class testRunnable0 implements Runnable{
        @Override
        public void run(){
            int a0 = 0;
            System.out.println("Hello! I am testRunnable0 and RUNNING!");
        }
    }
    public static class testRunnable1 implements Runnable{
        @Override
        public void run(){
            int a1 = 1;
            System.out.println("Hello! I am testRunnable1 and RUNNING!");
        }
    }
    public static class testRunnable2 implements Runnable{
        @Override
        public void run(){
            int a2 = 2;
            System.out.println("Hello! I am testRunnable2 and RUNNING!");
        }
    }

    public static void main(String[] args) {
        int a = 10;
        Thread thread0 = new Thread(new Example3.testRunnable0());
        Thread thread1 = new Thread(new Example3.testRunnable1());
        Thread thread2 = new Thread(new Example3.testRunnable2());

        thread0.start();
        thread1.start();
        thread2.start();
    }
}
