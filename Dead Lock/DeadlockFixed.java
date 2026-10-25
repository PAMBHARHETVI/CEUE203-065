public class DeadlockFixed {

    static Object lockA = new Object();
    static Object lockB = new Object();

    static void task() {
        synchronized (lockA) {
            synchronized (lockB) {
                System.out.println(
                    Thread.currentThread().getName() + " acquired both locks"
                );
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(DeadlockFixed::task, "Thread 1");
        Thread t2 = new Thread(DeadlockFixed::task, "Thread 2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Program completed without deadlock");
    }
}