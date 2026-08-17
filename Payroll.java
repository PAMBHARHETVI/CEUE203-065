abstract class Employee
{
    int id;
    String name;
    abstract double monthlySalary();

    Employee(String name , int id)
    {
        this.name = name;
        this.id = id;
    }
}

class FullTime extends Employee
{
    double fixedSalary;

    FullTime(String name ,int id ,double fixedSalary) {
        super(name , id);
        this.fixedSalary = fixedSalary;
    }
    double monthlySalary()
    {
        return fixedSalary;
    }
}

class PartTime extends Employee
{

    int hours ;
    double rate;
    double salary;

    PartTime(String name, int id,int hours ,double rate)
    {
        super(name, id);
        this.hours = hours;
        this.rate = rate;
    }

    double monthlySalary()
    {
        return salary = hours * rate;
    }
}

class Intern extends Employee
{
    double stipend;
     
    Intern(String name, int id,double stipend)
    {
        super(name, id);
        this.stipend = stipend;
    }
    double monthlySalary()
    {
        return stipend;
    }
}

public class Payroll {
    public static void main(String[] args) {
        Employee e[] = {
            new FullTime("Hetvi" , 65 , 50000),
            new PartTime("Vrunda" , 61 , 6 , 10000),
            new Intern("Dimpal" , 63 , 10000)
        };

        double total = 0;

        for(int i = 0 ; i<3 ; i++)
        {
            if(e[i] instanceof Intern)
            {
                System.out.println("This is Intern");
            }
            System.out.println(e[i].monthlySalary());
            total += e[i].monthlySalary();
        }

        System.out.println("total : " + total);
    }
}
