public class Example5 {
    public static void main(String[] args) throws InterruptedException {
        int size = 1_000_000_00;
        int[] array = createArray(size);
        long startTime = System.currentTimeMillis();
        double totalSum = 0;

//        for (int i = 0; i < size; i++) {
//            totalSum += Math.sqrt(array[i]);
//        }

        int numThreads = 4;
        int chunkSize = array.length / numThreads;
        SumCalculator[] calculators = new SumCalculator[numThreads];
        Thread[] threads = new Thread[numThreads];


        // Create and start threads
        for (int i = 0; i < numThreads; i++) {
            int startIndex = i * chunkSize;
            int endIndex = (i + 1) * chunkSize;
            calculators[i] = new SumCalculator(array, startIndex, endIndex);
            threads[i] = new Thread(calculators[i]);
            threads[i].start();
        }

        // Wait for all threads to finish
        for (Thread thread : threads) {
            thread.join();
        }

        // Combine results
        for (SumCalculator calculator : calculators) {
            totalSum += calculator.getSum();
        }

        long duration = System.currentTimeMillis() - startTime;

        System.out.println("Total sum: " + totalSum);
        System.out.println("Time taken: " + duration + " milliseconds");
    }

    private static int[] createArray(int size){
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = i + 1;
        }
        return array;
    }
}





class SumCalculator extends Thread {
    private final int[] array;
    private final int startIndex;
    private final int endIndex;
    private double sum;

    public SumCalculator(int[] array, int startIndex, int endIndex) {
        this.array = array;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }
    @Override
    public void run() {
        sum = 0;
        for (int i = startIndex; i < endIndex; i++) {
            sum += Math.sqrt(array[i]);
        }
    }

    public double getSum() {
        return sum;
    }
}
