package discount;

public class DiscountRules {

    public static DiscountRule tenPercent =
            price -> price * 0.90;

    public static DiscountRule twentyPercent =
            price -> price * 0.80;

    public static DiscountRule flat100 =
            price -> Math.max(0, price - 100);

    public static DiscountRule noDiscount =
            price -> price;
}