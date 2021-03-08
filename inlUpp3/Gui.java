import javax.swing.*;
import java.awt.Color;
import java.awt.*;
import java.awt.event.ActionListener;

/*Extremt enkelt Gui för att kunna komma igång.
Snygga gärna till/gör ett eget. 
Men tänk på att gör GUI:s INTE är ett kursmoment - så fastna inte här!
 */

    public class Gui extends JFrame {

        private static final long serialVersionUID = 1L;  //Gui-gul understrek
         JPanel panel;
        private JTextArea  showRoom1, showRoom2,showRoom3,showRoom4;
        private JTextField input;
        private JTextArea inventory;
        private String command;
        private boolean gotCommand;
        private JButton button;
        static JLabel text = new JLabel();
        double slump = 8*Math.random();


        


        public Gui(){
            Font font= new Font("ariel", Font.BOLD, 32);
            Font font2= new Font("Serif", Font.PLAIN, 20);
            Font font3= new Font("Serif", Font.ITALIC, 28);


            this.gotCommand = false;
            this.command = "";
            this.setTitle("Game");
            this.setSize(1000, 800);
            this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setUpElements();
            setUpPanel();
            this.add(panel);
            this.setVisible(true);
            this.setResizable(false);
            
            this.panel.add(text); 

            this.panel.setBackground(Color.ORANGE);
            text.setFont(font2);            
            text.setText("\n");

        
            input.setFont(font);
            showRoom1.setFont(font2);
            showRoom2.setFont(font2);
            showRoom3.setFont(font2);
            showRoom4.setFont(font2);

            this.inventory.setFont(font2);
            this.button.setFont(font3);

            this.showRoom2.setBackground(Color.LIGHT_GRAY);
            this.showRoom4.setBackground(Color.gray);
            this.showRoom3.setBackground(Color.LIGHT_GRAY);

        }

        // Returnera det senaste commitade kommandot
        public String getCommand() {
            if (this.gotCommand) {
                return this.command;
            }
            return "-1";

        }

        // Här kan man updatera respektive fält:
        
        public void setShowRoom1(String roomDescription) {
            this.showRoom1.setText( roomDescription+"\n ");
        }

        public void setShowRoom2(String roomDescription) {
            this.showRoom2.setText( roomDescription+"\n ");
        }

        public void setShowRoom3(String roomDescription) {
            this.showRoom3.setText( roomDescription+"\n ");
        }

        public void setShowRoom4(String roomDescription) {
            this.showRoom4.setText( roomDescription+"\n ");
        }

        public void setShowInventory(Inventory i) {
            this.inventory.setText("---3333---\n" + i.toString() );
        }

        // *******************

        public void setShowPlayer(Npc n,Person p, Room room, int position) {
            
            
            if (position == 0) {
               
                this.showRoom1.setText(p.toString() + " \n" + room +" \n");

                if (slump >  2 && slump < 4){
                   this.showRoom1.setText( n.toString2()+"\n"+p.toString() + " \n" + room +" \n");
                }
                
                
            }
            
            if (position == 1) {

                this.showRoom2.setText(p.toString() + " \n" + room +" \n");

                if ( slump >  4 && slump < 6 ){
                    this.showRoom2.setText(n.toString2()+"\n"+p.toString() + " \n" + room +" \n");
                 }
                 
            }
            
            if (position == 2) {
                this.showRoom3.setText(p.toString() + " \n" + room +" \n");

                if (slump >  4 && slump < 6 ){

                    this.showRoom3.setText(n.toString2()+"\n"+p.toString() + " \n" + room +" \n");
                 }
                 
            }

            if (position == 3) {

                this.showRoom4.setText(p.toString() + " \n" + room +" \n");

                if (slump >  6 ){

                    this.showRoom4.setText(n.toString2()+p.toString() + " \n" + room +" \n");
                 }
                 
            }


        }
        

            
        

        // Nedantåenda spaghetti är inte vacker...

        public void gotCommand() {
            this.gotCommand = false;
        }

        private void setUpPanel() {

            this.panel.add(showRoom1);
            this.panel.add(showRoom2);
            this.panel.add(showRoom3);
            this.panel.add(showRoom4);

            this.panel.add(input);
            this.panel.add(inventory);
            this.panel.add(button);

        }

        private void setUpElements() {
            this.panel = new JPanel(new GridLayout(4, 4));

            this.showRoom1 = new JTextArea("r1: \n");// nunu
            this.showRoom2 = new JTextArea("r2: \n");// nunu
            this.showRoom3 = new JTextArea("r3: \n");// nunu
            this.showRoom4 = new JTextArea("r4: \n");// nunu

            // this.showPersons = new JTextArea("Persons");
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

        public void setMessage(String string) {
            text.setText("fyttarum:kod [1-4] plocka:kod [add] lämna:kod [give] ");
		}

		

		


		


		

    }
