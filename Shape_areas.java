abstract class Shape{
    abstract double area();
}

class Circle extends Shape{

    double area;
    int radius;

    Circle(int radius)
    {
        this.radius = radius;
    }
    double area()
    {
        area = 3.14 * radius * radius;
        return area;    
    }
}

class Rectangle extends Shape{
    int length;
    int width;
    double area;

    Rectangle(int length , int width)
    {

        this.length = length;
        this.width = width;
    }
    double area()
    {
        return area = length * width;
    }
}

class Triangle extends Shape
{
    double base;
    double height;
    double area;

    Triangle(double  base , double height)
    {
        this.base = base;
        this.height = height;
    }
    double area()
    {
        return area = 0.5 * base * height; 
    }
}


abstract public class Shape_areas {
    public static void main(String[] args) {
        Shape S[] = {
            new Circle(5),
            new Rectangle(10, 10),
            new Triangle(5.0, 4.0)
        };

        double total = 0;
        double largest = 0;

        for(int i =0 ; i<3 ; i++)
        {
            System.out.println(S[i].area());
            total += S[i].area();
             
        }
            for(int j = 0 ; j<3 ; j++)
            {
                if(largest < S[j].area())
                {
                    largest = S[j].area();
                }
            }
        System.out.println(total);
        System.out.println(largest);
       
    }
}
