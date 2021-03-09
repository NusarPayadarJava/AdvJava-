import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;
public class Main {  
    public static void main(String[] args) throws FileNotFoundException{  
        
        ArrayList<String> content = new ArrayList<String>();  

        File f = new File("C:\\Arrayer.txt");
        Scanner sc = new Scanner(f);
      
        while (sc.hasNext()) {
                 
                 content.add( sc.nextLine() ); //System.out.println(content);
                 
                 Stream<ArrayList<String>> stream = Stream.of(content);
                  stream.forEach(p -> System.out.println(p));
                   
                 
                 Object obj = content.stream().filter(string -> string.length() > 8).count();
                 System.out.println("ord med fler än 8 bokstäver : " + obj); 

                 Object obj2 = content.stream().filter(string -> string.length() > 8).count();
                 System.out.println("2. Hur många unika ord innehåller texten? : " + content.size()); 
                 
          }
               sc.close();

        
        
    }  
}  