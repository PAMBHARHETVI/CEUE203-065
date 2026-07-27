import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class Password{
        void checkPassword(String password)
        {
        int count=0;
        if(password.matches(".{8,}"))
        {
            System.out.println("Password length is valid");
            count++;
        }
        else
        {
            System.out.println("Password length is invalid");
        }
        if(password.matches(".*[A-Z].*") ){
            System.out.println("Uppercase");
            count++;
        }
        if(password.matches(".*[0-9].*")){
            System.out.println("Numbers");
            count++;
        }
        if(password.matches(".*[&$#@].*")){
            System.out.println("Special Characters");
            count++;
        }
        
        if(count==4)
        {
            System.out.println("Password is Strong");
        }
       
        else if(count==2 || count==3)
        {
            System.out.println("Password is Medium");
        }
        else if(count==1 || count==0)
        {
            System.out.println("Password is Weak");
        }
        




        String password1="Password@123";
        int count1=0;

        Pattern pattern = Pattern.compile(".*[A-Z].*");
        Pattern pattern1 = Pattern.compile(".*[0-9].*");
        Pattern pattern2 = Pattern.compile(".*[&$#@].*");
        Pattern pattern3 = Pattern.compile(".{8,}");
        Matcher matcher = pattern.matcher(password1);
        Matcher matcher1 = pattern1.matcher(password1);
        Matcher matcher2 = pattern2.matcher(password1);
        Matcher matcher3 = pattern3.matcher(password1);
        if(matcher.matches())
        {
            
            count1++;
        }
        if(matcher1.matches())
        {
           
            count1++;
        }
        if(matcher2.matches())
        {
            
            count1++;
        }
        if(matcher3.matches())
        {
           
            count1++;
        }
        


        if(count1==4)
        {
            System.out.println("Password is Strong");
        }
       
        else if(count1==2 || count1==3)
        {
            System.out.println("Password is Medium");
        }
        else if(count1==1 || count1==0)
        {
            System.out.println("Password is Weak");
        }
        



    }

}
