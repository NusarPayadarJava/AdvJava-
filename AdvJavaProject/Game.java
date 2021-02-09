
public class Game {
    private Gui gui;
    private Room room1, room2, room3, room4;
    private Room map[] ;
    Npc n;

    public Game() {
        

        //Skapa rum!
        room1 = new Room("Vardagsrum(r1)","Stor och fult med en soffa");
        room2 = new Room("Hall(r2)", "liten, trång med ful tapet");
        room3 = new Room("sovrum1(r3)", "liten, trång med rosa tapet");
        room4 = new Room("sovrum2(r4)", "stor, trång med blå tapet ");
        
        map = new Room[4];
        map[0] = room1;  map[1] = room2; map[2] = room3; map[3] = room4;

        //Gameobjects
        GameObject lampa = new GameObject("Taklampa", false);
        GameObject kanin = new GameObject("Liten vit kanin",true);
        GameObject stol = new GameObject("vit stol",false);
        GameObject kudde = new GameObject("blå kudde",false);
       
        Container box = new Container("En blå låda", false, true);
        
        room1.addObject(kanin); room1.addObject(box);
        room2.addObject(lampa); room2.addObject(box);
        room3.addObject(stol); room3.addObject(box);
        room4.addObject(kudde); room4.addObject(box);


        Person newPlayer1 = new Person("Spelare1");        
        //add person till splelet -player-
        room1.addNpc(newPlayer1);
        //npc.playerPosition=rumIndex;
        int rumIndex=0;
        //int spelarePos=rumIndex;
        

        //add grejer
        newPlayer1.getInventory().addObject(lampa);

        Inventory inventory = new Inventory(8);
        inventory.addObject(kanin);
        inventory.addObject(lampa);
        inventory.addObject(lampa);
        inventory.addObject(lampa);
        inventory.addObject(kudde);
        inventory.addObject(stol);

        //Starta guit!
        this.gui = new Gui();
                
        while (true) {

            String command = gui.getCommand();
            if (!command.equals("-1")) {

                if (command.equals("1")) {
                    rumIndex  = 0;
                }

                if (command.equals("2")) {

                    rumIndex = 1;
                }

                if (command.equals("3")) {
                    rumIndex = 2;

                }

                if (command.equals("4")) {
                    rumIndex = 3;
                }
                //visar rum info
                
                gui.setShowRoom1(map[0].toString());
                gui.setShowRoom2(map[1].toString());
                gui.setShowRoom3(map[2].toString());
                gui.setShowRoom4(map[3].toString());
              
            }
                gui.setShowPlayer(newPlayer1,map[rumIndex],rumIndex );

                gui.setShowInventory(inventory);


               
        }

        
    }



}
