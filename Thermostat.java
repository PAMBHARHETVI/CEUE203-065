class Thermostat
{
    private String location;
    private int temperature;
    
    private static final int MIN = 16;
    private static final int MAX = 30;
    private static int Count = 0;

    public Thermostat(String location,int startTemp) {
        this.location = location;

        if (startTemp >= MIN && startTemp <= MAX)
        { 
            temperature = startTemp;
        }
        else 
        {
             temperature = 22; 
        }
        Count ++;
    }

    Thermostat(String location)
    {
        this(location,22);
    }

    void raise()
    {
        if(temperature < MAX)
        {
            temperature++;
        }
        else
        {
            System.out.println("Already at maximum(30)");
        }
    }

    void lower()
    {
        if(temperature > MIN)
        {
            temperature--;
        }
        else
        {
            System.out.println("Already at minimum(16)");
        }

    }

    public int getTemperature() {
        return temperature;
    }

    static int getActiveCount()
    {
        return Count;
    }
    
    public static void main(String[] args) {
        Thermostat t1 = new Thermostat("rajkot");
        Thermostat t2 = new Thermostat("vadodara");

        for(int i=0 ; i<10 ; i++)
        {
            t1.raise();
            System.out.println("raise " + i + ": " + t1.getTemperature());
        }

        for(int i=0 ; i<20 ; i++)
        {
            t1.lower();
            System.out.println("lower" + i + ": " + t1.getTemperature());
        }

        System.out.println("count : " + getActiveCount());
    }
}