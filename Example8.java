public class Example8 {
    public static void main(String[] args) throws InterruptedException {
        Counter1 counter = new Counter1();
        Runnable add50 = () -> {
            for (int i = 0; i < 50; i++) {
                counter.increment();
            }
        };
        Thread t1 = new Thread(add50);
        Thread t2 = new Thread(add50);
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(counter.getN());
    }
}

class Counter1 {
    private Integer n = 0;
    private final Object lock = new Object();

    public void increment() {
        synchronized (this){
            n = n + 1;
        }

    }
    public int getN() {
        return n;
    }
}