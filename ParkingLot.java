
public class ParkingLot {
    private int twoWheelers = 0;
    private int fourwheelers = 0;
    private final int twoCap = 10;
    private final int fourCap = 10;
    private static long revenue = 0;

     void park(String type)
    {
        if(type.equals("two"))
        {
            if(twoWheelers < twoCap)
            {
                revenue += 20;
                twoWheelers ++;
            }
            else 
            {
                System.out.println("Parking is full");
            }
        }
        
        if(type.equals("four"))
        {
            if(fourwheelers < fourCap)
            {
                revenue += 40;
                fourwheelers ++;
            }
            else 
            {
                System.out.println("Parking is full");
            }
        }
    }

    void leave (String type)
    {
        if(type.equals("two"))
        {
            if(twoWheelers > 0)
            {
                twoWheelers --;
            }
            else
            {
                System.out.println("there is no two wheelers to leave");
            }
        }

        if(type.equals("four"))
        {
            if(fourwheelers > 0)
            {
                fourwheelers --;
            }
            else
            {
                System.out.println("there is no four wheelers to leave");
            }
        }
    }


    int getOccupancy(String type)
    {
        if(type.equals("two"))
        {
            return twoWheelers;
        }

        if(type.equals("four"))
        {
            return (fourCap - fourwheelers);
        }

        return -1;
    }

    long getRevenue()
    {
        return revenue;
    }
    public static void main(String[] args) {
        ParkingLot p = new ParkingLot();

        p.park("two");
        p.park("two");
        p.park("four");
        p.park("four");

        p.leave("two");
        p.leave("four");

        p.leave("two");
        p.leave("two");

        System.out.println("occupancy : " + p.getOccupancy("two"));
        System.out.println("occupancy : " + p.getOccupancy("four"));
        System.out.println("revenue : " + p.getRevenue());
    }
}
