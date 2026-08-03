import java.util.Scanner;

public class Driver {
    public static void main(String args[])
    {
        Scanner sc = new Scanner ( System.in );
        String password = sc.next();
        // String password="Password@123";
        Password pwd = new Password();
        pwd.checkPassword(password);
    }
}
