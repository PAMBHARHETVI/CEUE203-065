import java.util.Scanner;

public class Driver{
    public static void main(String Args[])
    {
        Scanner sc = new Scanner(System.in);

        String logs[] = {
            "10:05 alice Hello there",
            "01:56 charlie How are you?",
            "MultiDimenstion",
            "20:34 riya hello"
        };
        System.out.println("Enter your keyword : ");

        String key = sc.nextLine();

        ChatFilter chatfilter = new ChatFilter();

        chatfilter.filterchat(logs, key);
    }
}