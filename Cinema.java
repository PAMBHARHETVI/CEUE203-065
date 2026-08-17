public class Cinema {
    private String title;
    private int seatsAvailable;
    private final int capacity;
    private static int totalBooked = 0;

    public Cinema(String title ,int capacity)
    {
        this.title = title;
        this.capacity = capacity;

        seatsAvailable = capacity;
    }

    public Cinema(String title)
    {
        this(title , 100);
    }

    boolean book(int n)
    {
        if(n <= seatsAvailable)
        {
            seatsAvailable -= n;
            totalBooked += n;
            return true;
        }
        else
        {
            return false;
        }
    }

    void cancel(int n)
    {
        if(seatsAvailable < capacity)
        {
            seatsAvailable += n;
        }
        else{
            System.out.println("above capacity");
        }
    }

    int getSeatsAvailable()
    {
        return seatsAvailable;
    }

    static int getTotalBooked()
    {
        return totalBooked;
    }

    public static void main(String[] args) {
        Cinema c1 = new Cinema("Hello");
        Cinema c2 = new Cinema ("bye");

        c1.book(100);
        c1.cancel(10);

        System.out.println("Available Seats : " + c1.getSeatsAvailable());
        System.out.println("Total Booking : " +  c1.getTotalBooked());

        c2.book(15);
        c2.cancel(2);

        System.out.println("Available Seats : " + c2.getSeatsAvailable());
        System.out.println("Total Booking : " + c2.getTotalBooked());

        
    }
}
