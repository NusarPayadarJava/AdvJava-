import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args)  {


        JTextField tf=new JTextField("skriv namn"); tf.setFont(new Font("Serif", Font.PLAIN, 22));
        JTextField tf2=new JTextField("skriv tel nr"); tf2.setFont(new Font("Serif", Font.PLAIN, 22));
        JTextField tf3=new JTextField("skriv e-post"); tf3.setFont(new Font("Serif", Font.PLAIN, 22));
        JTextArea ta=new JTextArea(); ta.setFont(new Font("Serif", Font.PLAIN, 22));
        JFrame f=new JFrame("Java Lab"); 

    tf.setBounds(50,50, 250,30); tf2.setBounds(50,80, 250,30); tf3.setBounds(50,110, 250,30);
    ta.setBounds(50,180, 250,200);  
  
    JButton b=new JButton("Click"); b.setBounds(50,140,100,30); 
   
    b.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e){  

            //**************************************************
            String p="[A-Za-z]";
            String p2="[0-9]";
            String p3="[A-Za-z]+@+[A-Za-z]+\\.+[A-Za-z]";
            //*************************************************

            Pattern pattern = Pattern.compile(p);
            Pattern pattern2 = Pattern.compile(p2);
            Pattern pattern3 = Pattern.compile(p3);
            
            Matcher matcher = pattern.matcher(tf.getText());
            Matcher matcher2 = pattern2.matcher(tf2.getText());
            Matcher matcher3 = pattern3.matcher(tf3.getText());

            boolean search = matcher.find(); 
            boolean  search2 = matcher2.find();
            boolean  search3 = matcher3.find();

            if(search && search2 && search3 ) {
                ta.setText(   tf.getText()+"\n"+ tf2.getText()+ "\n"+tf3.getText()  );
      
              } else {
                ta.setText("Match not found");
              }
                
        }  
        });
    
    f.add(tf);  f.add(tf2);  f.add(tf3); 
    f.add(b);
    f.add(ta);

    f.setSize(600,600); f.setLayout(null); f.setVisible(true);   

    }
}
