import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter numerator of first fraction: ");
        int num1 = sc.nextInt();

        System.out.print("Enter denominator of first fraction: ");
        int den1 = sc.nextInt();

        Fraction f1 = new Fraction(num1, den1);

        System.out.print("Enter numerator of second fraction: ");
        int num2 = sc.nextInt();

        System.out.print("Enter denominator of second fraction: ");
        int den2 = sc.nextInt();

        Fraction f2 = new Fraction(num2, den2);

        System.out.println("\nFirst fraction: " + f1);
        System.out.println("Second fraction: " + f2);

        System.out.println("Are both fractions equal? " + f1.equals(f2));

        sc.close();
    }
}