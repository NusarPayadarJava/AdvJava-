public abstract class Npc {
    String name;
    Inventory inventory;
    int playerPosition;

    public int setPosition(int i) {
       
         this.playerPosition = i;
         return playerPosition;

   }
    
    public Npc(String name2){
        this.name = name2;
        this.inventory = new Inventory(1);
    }

    public Inventory getInventory(){
        return this.inventory;
    }
    

    public int getPosition(){
        return this.playerPosition;

    }

    public String toString (){
        
        return this.name + " is carrying " + this.inventory;
    }

    
    
    

}


