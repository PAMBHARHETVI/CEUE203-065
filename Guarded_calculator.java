import java.util.Scanner;

class MyDivideByZeroException extends Exception {
    public MyDivideByZeroException(String message) {
        super(message);
    }
}

public class Guarded_calculator {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        boolean succeed = false;

        while (!succeed) {
            try {
                System.out.print("Enter first number: ");
                int a = sc.nextInt();

                System.out.print("Enter operator (+, -, *, /): ");
                char op = sc.next().charAt(0);

                System.out.print("Enter second number: ");
                int b = sc.nextInt();

                int ans = 0;

                switch (op) {
                    case '+':
                        ans = a + b;
                        break;

                    case '-':
                        ans = a - b;
                        break;

                    case '*':
                        ans = a * b;
                        break;

                    case '/':
                        if (b == 0) {
                            throw new MyDivideByZeroException("Cannot divide by zero!");
                        }
                        ans = a / b;
                        break;

                    default:
                        System.out.println("Invalid operator!");
                        continue;
                }

                System.out.println("Result: " + ans);
                succeed = true;
            }
            catch (MyDivideByZeroException e) {
                System.out.println(e.getMessage());
            }
            finally {
                System.out.println("Calculation attempt logged.\n");
            }
        }

        
    }
}