class Counter {
    int count = 0;

    synchronized void increment() {
        count++;
    }
}

public class Counter_race {
    public static void main(String[] args) throws InterruptedException {

        Counter c1 = new Counter();

        int threadCount = 5;
        int incrementsPerThread = 100000;

        Thread[] threads = new Thread[threadCount];

        for (int i = 0; i < threadCount; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < incrementsPerThread; j++) {
                    c1.increment();
                }
            });

            threads[i].start();
        }

        for (Thread t : threads) {
            t.join();
        }

        int expected = threadCount * incrementsPerThread;

        System.out.println("Expected: " + expected);
        System.out.println("Actual:   " + c1.count);
    }
}