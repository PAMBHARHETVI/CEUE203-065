import java.util.concurrent.atomic.AtomicLong;

public class ThreadSum {

    static long total = 0;
    static long syncTotal = 0;
    static AtomicLong atomicTotal = new AtomicLong(0);

    static final int SIZE = 1000000;
    static final int THREADS = 4;
    static int[] numbers = new int[SIZE];

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < SIZE; i++) {
            numbers[i] = 1;
        }

        // 1. Wrong method: Race condition
        total = 0;
        long start = System.nanoTime();
        runThreads(0);
        long wrongTime = System.nanoTime() - start;
        System.out.println("Wrong total: " + total);
        System.out.println("Wrong method time: " + wrongTime + " ns");

        // 2. Fix using synchronized
        syncTotal = 0;
        start = System.nanoTime();
        runThreads(1);
        long syncTime = System.nanoTime() - start;
        System.out.println("Synchronized total: " + syncTotal);
        System.out.println("Synchronized time: " + syncTime + " ns");

        // 3. Fix using AtomicLong
        atomicTotal.set(0);
        start = System.nanoTime();
        runThreads(2);
        long atomicTime = System.nanoTime() - start;
        System.out.println("Atomic total: " + atomicTotal.get());
        System.out.println("Atomic time: " + atomicTime + " ns");

    }

    static void runThreads(int method) throws InterruptedException {

        Thread[] threads = new Thread[THREADS];

        for (int t = 0; t < THREADS; t++) {
            final int start = t * SIZE / THREADS;
            final int end = (t + 1) * SIZE / THREADS;

            threads[t] = new Thread(() -> {
                for (int i = start; i < end; i++) {
                    if (method == 0) {
                        total += numbers[i];
                    } else if (method == 1) {
                        synchronized (ThreadSum.class) {
                            syncTotal += numbers[i];
                        }
                    } else {
                        atomicTotal.addAndGet(numbers[i]);
                    }
                }
            });

            threads[t].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }
    }
}