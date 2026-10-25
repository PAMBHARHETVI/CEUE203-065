class Stack<T> {
    private Object[] items;
    private int top = -1;

    Stack(int size) {
        items = new Object[size];
    }

    void push(T value) {
        if (top == items.length - 1) {
            System.out.println("Stack is full");
            return;
        }

        items[++top] = value;
    }

    @SuppressWarnings("unchecked")
    T pop() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return null;
        }

        T value = (T) items[top];
        items[top--] = null;
        return value;
    }
}

public class GenericStack {
    public static void main(String[] args) {
        Stack<Integer> s1 = new Stack<>(5);
        s1.push(10);
        s1.push(20);

        System.out.println("Integer popped: " + s1.pop());

        Stack<String> s2 = new Stack<>(5);
        s2.push("Java");
        s2.push("Python");

        System.out.println("String popped: " + s2.pop());

        System.out.println("Empty stack: " + s2.pop());
    }
}