// Race, syncronize
public class Example6 {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
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

class Counter {
    private int n = 0;

    public synchronized void increment() { // monitor, lock, mutex
        n = n + 1;
    }
    public int getN() {
        return n;
    }
}