import java.util.LinkedList;
import java.util.Queue;

class SharedBuffer {

    private Queue<Integer> buffer = new LinkedList<>();
    private final int capacity = 3;

    public synchronized void produce(int value) throws InterruptedException {

        while (buffer.size() == capacity) {
            wait();
        }

        buffer.add(value);

        System.out.println("Produced: " + value);

        notify();
    }

    public synchronized int consume() throws InterruptedException {

        while (buffer.isEmpty()) {
            wait();
        }

        int value = buffer.remove();

        System.out.println("Consumed: " + value);

        notify();

        return value;
    }
}

public class Producer_consumer {

    public static void main(String[] args) throws InterruptedException {

        SharedBuffer buffer = new SharedBuffer();

        int totalItems = 10;

        Thread producer = new Thread(() -> {

            try {
                for (int i = 1; i <= totalItems; i++) {
                    buffer.produce(i);
                    Thread.sleep(100);
                }

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumer = new Thread(() -> {

            try {
                for (int i = 1; i <= totalItems; i++) {
                    buffer.consume();
                    Thread.sleep(150);
                }

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();

        System.out.println("All items produced and consumed.");
    }
}