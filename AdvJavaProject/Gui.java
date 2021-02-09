import javax.swing.*;


import java.awt.*;
import java.awt.event.ActionListener;

/*Extremt enkelt Gui för att kunna komma igång.
Snygga gärna till/gör ett eget. 
Men tänk på att gör GUI:s INTE är ett kursmoment - så fastna inte här!
 */

    public class Gui extends JFrame {

        private static final long serialVersionUID = 1L;  //Gui-gul understrek
        private JPanel panel;
        private JTextArea  showRoom1, showRoom2,showRoom3,showRoom4;
        private JTextField input;
        private JTextArea inventory;
        private String command;
        private boolean gotCommand;
        private JButton button;


        public Gui(){
            Font font= new Font("Serif", Font.PLAIN, 32);
            Font font2= new Font("Serif", Font.PLAIN, 18);

            this.gotCommand = false;
            this.command = "";
            this.setTitle("Game");
            this.setSize(1200, 800);
            this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setUpElements();
            setUpPanel();
            this.add(panel);
            this.setVisible(true);
            this.setResizable(false);
            
            this.input.setFont(font ); 
            this.showRoom1.setFont(font2 );this.showRoom2.setFont(font2 );
            this.showRoom3.setFont(font2 );this.showRoom4.setFont(font2 );

            this.inventory.setFont(font2 );

        }

        //Returnera det senaste commitade kommandot
        public String getCommand(){
            if (this.gotCommand){
                return this.command;
            }
            return "-1";

        }
        
        //Här kan man updatera respektive fält:
         public void setShowRoom1(String roomDescription){
            this.showRoom1.setText("\n Rum1: \n"+roomDescription);
            }
         public void setShowRoom2(String roomDescription){
            this.showRoom2.setText("\n Rum2:\n "+roomDescription);
            }
         public void setShowRoom3(String roomDescription){
            this.showRoom3.setText("\n Rum3: \n"+roomDescription);
            }
         public void setShowRoom4(String roomDescription){
            this.showRoom4.setText("\n Rum4: \n"+roomDescription);
            }
         
        public void setShowInventory(Inventory i){
            this.inventory.setText("---3333---\n"+i.toString());
        }
            //******************* 
            public void setShowPlayer( Person p, Room room, int position) {
           
                if (position==0){
                    this.showRoom1.setText("\n \n"+p.toString() +" \n"+room);
                }

                if (position==1){
                    this.showRoom2.setText("\n \n"+p.toString()+"\n"+room);
                }
                if (position==2){
                    this.showRoom3.setText(" \n \n"+p.toString() +" \n"+room);
                    }
                if (position==3){
                    this.showRoom4.setText("\n"+p.toString() +"\n"+room);
                   }
		}
      
        //Nedantåenda spaghetti är inte vacker...

        public void gotCommand(){
            this.gotCommand = false;
        }

        private void setUpPanel(){
           
            this.panel.add(showRoom1); 
            this.panel.add(showRoom2);
            this.panel.add(showRoom3); 
            this.panel.add(showRoom4);

            this.panel.add(input);
            this.panel.add(inventory);
            this.panel.add(button);

        }

        private void setUpElements(){
            this.panel = new JPanel(new GridLayout(4,4));
            //this.showRoom = new JTextArea("Room: ");
            this.showRoom1 = new JTextArea("r1: \n");//nunu
            this.showRoom2 = new JTextArea("r2: \n");//nunu
            this.showRoom3 = new JTextArea("r3: \n");//nunu
            this.showRoom4 = new JTextArea("r4: \n");//nunu


            //this.showPersons = new JTextArea("Persons");
            this.inventory = new JTextArea("Inventory");
            this.input = new JTextField("");
            

           // this.showPersons.setEditable(false);
            this.showRoom1.setEditable(false);
            this.inventory.setEditable(false);

            ActionListener inputListener = e -> {
                this.command = input.getText();
                this.gotCommand = true;
            };

            input.addActionListener(inputListener);

            this.button = new JButton("commit");
            this.button.addActionListener(inputListener);

        }

		

		

    }
