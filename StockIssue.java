import java.util.*;

class OutOfStockException extends Exception {
    int shortfall;

    OutOfStockException(int shortfall) {
        super("Out of stock! Shortfall: " + shortfall);
        this.shortfall = shortfall;
    }
}

class InvalidQuantityException extends Exception {
    InvalidQuantityException(String message) {
        super(message);
    }
}

class Warehouse {
    int stock = 10;

    void issue(String item, int qty)
            throws OutOfStockException, InvalidQuantityException {

        if (qty <= 0) {
            throw new InvalidQuantityException(
                    "Quantity must be greater than zero");
        }

        if (qty > stock) {
            throw new OutOfStockException(qty - stock);
        }

        stock -= qty;
        System.out.println("Issued " + qty + " units of " + item);
    }
}

public class StockIssue {
    public static void main(String[] args) {

        Warehouse w = new Warehouse();

        String[] items = {"Pen", "Book", "Pencil", "Eraser"};
        int[] quantities = {4, 8, 0, 3};

        for (int i = 0; i < quantities.length; i++) {
            try {
                w.issue(items[i], quantities[i]);
            } catch (OutOfStockException e) {
                System.out.println(items[i] + ": " + e.getMessage());
            } catch (InvalidQuantityException e) {
                System.out.println(items[i] + ": " + e.getMessage());
            }
        }

        System.out.println("Remaining stock: " + w.stock);
    }
}