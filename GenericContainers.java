class Box<T> {
    private T value;

    void set(T value) {
        this.value = value;
    }

    T get() {
        return value;
    }
}

class Pair<A, B> {
    A first;
    B second;

    Pair(A first, B second) {
        this.first = first;
        this.second = second;
    }
}

public class GenericContainers {

    static <T> T firstElement(T[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }
        return array[0];
    }

    public static void main(String[] args) {
        Box<Integer> b1 = new Box<>();
        b1.set(100);
        System.out.println("Box value: " + b1.get());

        Pair<String, Integer> p = new Pair<>("Hetvi", 20);
        System.out.println("Name: " + p.first);
        System.out.println("Age: " + p.second);

        String[] names = {"Hetvi", "Smit", "Rahul"};
        Integer[] numbers = {10, 20, 30};

        System.out.println("First name: " + firstElement(names));
        System.out.println("First number: " + firstElement(numbers));
    }
}