class TicketBooking{
    int seatsLeft = 5;

    void book()
    {
        if(seatsLeft > 0)
        {
            try{
                Thread.sleep(10);
            }
            catch(InterruptedException e)
            {
                Thread.currentThread().interrupt();
            }

            seatsLeft--;
            System.out.println(Thread.currentThread().getName() + " booked a seat.");
        }
    }
}

public class Seat_Booking_Race {
    public static void main(String args[]) throws InterruptedException {
        TicketBooking t1 = new TicketBooking();

        Thread[] threads = new Thread[10];

        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(
                    t1::book,
                    "Thread-" + (i + 1)
            );
            threads[i].start();
        }

        for (Thread t : threads) {
            t.join();
        }

        System.out.println("Seats left: " + t1.seatsLeft);
    }
}
