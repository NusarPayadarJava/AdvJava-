import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class dateTime {

    public static void main(String[] args) throws InterruptedException {

        LocalDateTime dt= LocalDateTime.now();
        DateTimeFormatter dateFormat= DateTimeFormatter.ofPattern("dd/MM-yyyy"); 
        DateTimeFormatter timeFormat= DateTimeFormatter.ofPattern("HH:mm"); 

        String newDateFormat= dt.format(dateFormat);
        String newTimeFormat= dt.format(timeFormat);


        Date date = new Date();
        System.out.println("Datum format: ["+newDateFormat+"]");
        System.out.println("Tid format  : ["+newTimeFormat+"]");        

        System.out.println("Normal format Date(): ["+date+"]"); //vanligt utan format Date();


        


        
    }
    
}
