class MyResource implements AutoCloseable {

    public MyResource() {
        System.out.println("Resource opened");
    }

    @Override
    public void close() {
        System.out.println("Resource closed");
    }
}

public class AutoCloseDemo {

    public static void main(String[] args) {

        try (MyResource resource = new MyResource()) {
            System.out.println("Inside try block");

            throw new RuntimeException("Original error occurred");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}