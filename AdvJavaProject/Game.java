import java.awt.Color;

public class Game {
    private Gui gui;
    private Room room1, room2, room3, room4;
    private Room map[] ;

    public Game(){
        

        //Skapa rum!
        room1 = new Room("(Room1) \n Vardagsrum ","Stor och fult med en soffa");
        room2 = new Room("(Room2) \n Hall ", "liten, trång med ful tapet");
        room3 = new Room("(Room3) \n sovrum1 ", "liten, trång med rosa tapet");
        room4 = new Room("(Room4) \n sovrum2 ", "stor, trång med blå tapet ");
        
        map = new Room[4];
        map[0] = room1;  map[1] = room2; map[2] = room3; map[3] = room4;

        //Gameobjects
        GameObject lampa = new GameObject("Taklampa", false);
        GameObject kanin = new GameObject("kanin",true);
        GameObject stol = new GameObject("stol",false);
        GameObject kudde = new GameObject("kudde",false);
       
        Container box = new Container("BLUE BOX", false, true);
        
        room1.addObject(kanin); room1.addObject(box);
        room2.addObject(lampa); room2.addObject(box);
        room3.addObject(stol); room3.addObject(box);
        room4.addObject(kudde); room4.addObject(box);


        Person newPlayer1 = new Person("Spelare1");        
        //add person till splelet 

        Inventory inventory = new Inventory(4);
        inventory.addObject(kanin);
        inventory.addObject(lampa);
        inventory.addObject(kudde);
        inventory.addObject(stol);

        //Starta guit!
        this.gui = new Gui();

        boolean gameon=true;        
        int rumIndex=0;

        while (gameon) {

            String command = gui.getCommand();
            if (!command.equals("-1")) {

                 //Rum 1 
                if (command.equals("1")  ) {
                  // rumIndex  = 0;
                   if (rumIndex == 1 ){
                      rumIndex = 0;
                      gui.panel.setBackground(Color.GREEN);
                    }
                   
                    
                }

                if (command.equals("2")) {
                    //Rum 2 rumIndex  = 1;
                    if (rumIndex == 0 || rumIndex== 2){
                        rumIndex = 1;
                        gui.panel.setBackground(Color.GREEN);

                    }
                    
                }
                         if (command.equals("3")) {
                        //Rum 3 rumIndex  = 2;
                            if (rumIndex == 1 || rumIndex== 3){
                            rumIndex = 2;
                            gui.panel.setBackground(Color.GREEN);
    
                        }
                        else {
                            gui.panel.setBackground(Color.RED);
 
                        }
                       
                    }
                        if (command.equals("4")) {
                            //Rum 4 rumIndex= 3;
                            if (rumIndex == 2){
                                rumIndex = 3;
                                gui.panel.setBackground(Color.GREEN);
                                }
                            
                       
                         }

                
                //take 
                if (command.contains("add")  ) {
                    
                       if (command.contains("stol")  ) {
                            map[rumIndex].removeObject( stol);
                            newPlayer1.getInventory().addObject(stol);
                         }
                         if (command.contains("kanin")  ) {
                            map[rumIndex].removeObject( kanin);
                            newPlayer1.getInventory().addObject(kanin);
                         }
                         if (command.contains("lampa")  ) {
                            map[rumIndex].removeObject( lampa);
                            newPlayer1.getInventory().addObject(lampa);
                         }
                         if (command.contains("kudde")  ) {
                            map[rumIndex].removeObject( kudde);
                            newPlayer1.getInventory().addObject(kudde);
                         }
                
                } //slut take              

                //****** lämna 
                if (command.contains("give")  ) {

                    if (command.contains("stol")  ) {
                        map[rumIndex].addObject(stol );
                       newPlayer1.getInventory().removeObject(stol);
                    }
                    if (command.contains("kudde")  ) {
                        map[rumIndex].addObject(kudde );
                       newPlayer1.getInventory().removeObject(kudde);
                    }
                    if (command.contains("lampa")  ) {
                        map[rumIndex].addObject(lampa );
                       newPlayer1.getInventory().removeObject(lampa);
                    }
                    if (command.contains("kanin")  ) {
                        map[rumIndex].addObject(kanin );
                       newPlayer1.getInventory().removeObject(kanin);
                    }
                }//slut lämna
                
                if (command.equals("slut")  ) {
                    
                    gui.setMessage("Game over");
                    gameon=false;
  
                }
                            
            } 
            
        

                gui.setShowPlayer(newPlayer1,map[rumIndex],rumIndex );
                gui.setShowInventory(inventory);


                gui.setShowRoom1("\n "+map[0]);
                gui.setShowPlayer(newPlayer1,map[rumIndex],rumIndex );


                gui.setShowRoom2("\n "+map[1]);
                gui.setShowPlayer(newPlayer1,map[rumIndex],rumIndex );


                gui.setShowRoom3("\n "+map[2]);
                gui.setShowPlayer(newPlayer1,map[rumIndex],rumIndex );


                gui.setShowRoom4("\n "+map[3]);
                gui.setShowPlayer(newPlayer1,map[rumIndex],rumIndex );

                gui.setMessage("Game over");

        }

 
    }



}