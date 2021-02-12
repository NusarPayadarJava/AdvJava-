

   public class Room  {
    private String name;
    private String description;
    private Inventory inventory;
    private Person[] person;

    public Room(String roomName, String roomDescription){
        this.person = new Person[4];
        this.name = roomName;
        this.description= roomDescription;
        this.inventory = new Inventory(4);
    }
    public void addNpc(Person person) {

        this.person[0] = person; 
    }

    public Person getPersons(){
        return this.person[0];
    }
    public void addObject(GameObject go){
        this.inventory.addObject(go);
        getInventory();
    }
        //remove 
        public void removeObject(GameObject go) {
            getInventory();

             this.inventory.removeObject(go);
             getInventory();


        }
        public String toString(){
            return name+" : "+description +"\n" +inventory;
        }
        public Inventory getInventory(){
            return this.inventory;
        }


}
