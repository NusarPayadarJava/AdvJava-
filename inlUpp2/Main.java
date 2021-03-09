import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main  {

  public static int count=0;

  public static void main(String[] args) throws FileNotFoundException {
      
    Scanner sc= new Scanner(new File( "C:\\text.txt") ); 
             while (sc.hasNextLine() ){
                count++;
                String pattern;
               // pattern = "Aa[a-zA-Z]Zz$";
               // pattern= "^Olas$";//Olas
                 // pattern= "a+{1-4}";
                  pattern= "^@";


                finder(sc.nextLine(), pattern);

               // System.out.println(sc.nextLine());
             }
             System.out.println("--- klart ---");
             
               
    }

    public static void finder (String content, String pat){

        Pattern p = Pattern.compile(pat);
        Matcher matcher = p.matcher(content);

        while(matcher.find()){
          count++;
            if(matcher.group().length() != 0) {
                System.out.println(matcher.group());
                System.out.println("Line no: "+count);
            }
            System.out.print ("Start: "+matcher.start()+" " );
            System.out.println("slut: "+matcher.end() );
        }
        
    
  }
}