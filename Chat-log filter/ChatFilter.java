public class ChatFilter
{
    void filterchat(String[] logs, String key){

        StringBuffer report = new StringBuffer();
        int count = 0 ;
        for(String line : logs){

            String[] parts = line.split(" ", 3);
            if(parts.length>=3){

                String Time = parts[0];
                
                String Name = parts[1];
                
                String Message = parts[2];

                if(Message.toLowerCase().contains(key))
                {
                    count++;
                    report.append(Time);
                    report.append(" ");
                    report.append(Name);
                    report.append(":");
                    report.append(Message);
                    report.append("\n");
                }
            }
        }
        System.err.println("Matches: " + count);
        System.out.println(report);
    }
}