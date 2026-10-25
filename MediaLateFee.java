abstract class Media {
    String title;
    int lateDays;

    Media(String title, int lateDays) {
        this.title = title;
        this.lateDays = lateDays;
    }

    abstract double calculateLateFee();
}

class Book extends Media {
    Book(String title, int lateDays) {
        super(title, lateDays);
    }

    double calculateLateFee() {
        return lateDays * 2.0;
    }
}

class DVD extends Media {
    DVD(String title, int lateDays) {
        super(title, lateDays);
    }

    double calculateLateFee() {
        return lateDays * 5.0;
    }
}

class Magazine extends Media {
    Magazine(String title, int lateDays) {
        super(title, lateDays);
    }

    double calculateLateFee() {
        return lateDays * 1.0;
    }
}

public class MediaLateFee {
    public static void main(String[] args) {
        Media[] returnedItems = {
            new Book("Java Programming", 3),
            new DVD("Avengers", 2),
            new Magazine("Science Today", 4)
        };

        double total = 0;

        for (Media item : returnedItems) {
            double fee = item.calculateLateFee();

            System.out.println(item.title + " - Late Fee: Rs. " + fee);

            total += fee;
        }

        System.out.println("Total Late Fees: Rs. " + total);
    }
}