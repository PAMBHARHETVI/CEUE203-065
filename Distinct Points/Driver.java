public class Driver {
    public static void main(String[] args) {
        Point[] points = {
            new Point(1, 2),
            new Point(3, 4),
            new Point(1, 2),
            new Point(5, 6),
            new Point(3, 4),
            new Point(9,5)
        };

        int distinct = 0;

        for(int i=0 ; i<6; i++)
        {
            boolean alreadyadded = false;
            for(int j=0 ; j<i ; j++)
            {
                if(points[i].equals(points[j]))
                {
                    alreadyadded = true;
                }
            }
            if(!alreadyadded)
            {
                distinct++;
            }
        }

        System.out.println("Distinct: " + distinct);
    }
}
