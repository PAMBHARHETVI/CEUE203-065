package discount;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Double> prices =
                Arrays.asList(500.0, 1000.0, 1500.0);

        System.out.println("1. 10% Discount");
        System.out.println("2. 20% Discount");
        System.out.println("3. Flat Rs.100 Discount");
        System.out.println("4. No Discount");

        System.out.print("Choose discount rule: ");
        int choice = sc.nextInt();

        DiscountRule rule;

        switch (choice) {
            case 1:
                rule = DiscountRules.tenPercent;
                break;
            case 2:
                rule = DiscountRules.twentyPercent;
                break;
            case 3:
                rule = DiscountRules.flat100;
                break;
            case 4:
                rule = DiscountRules.noDiscount;
                break;
            default:
                System.out.println("Invalid choice");
                sc.close();
                return;
        }

        System.out.println("\nOriginal Price -> Final Price");

        for (double price : prices) {
            System.out.printf("%.2f -> %.2f%n",
                    price, rule.apply(price));
        }

        sc.close();
    }
}