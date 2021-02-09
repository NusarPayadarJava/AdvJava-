
import java.util.Arrays;

public class Inventory {
    private GameObject[] list;
    //private int prsize;

    public Inventory(int size){
        //this.prsize = size;
        list = new GameObject[size];
    }
    public void addObject(GameObject go){
        int index = getFirstEmptyIndex();

        if (index ==-1){
            System.out.println("Inventory är fullt");
            return;
        }
        this.list[index] = go;
    }
    public void moveObject(Inventory i2, GameObject go2) {
        //if (!isObjectHere(go)){ //Felmeddelande}
        i2.addObject(go2);
        //this.removeObject(go);
    }
    public String toString(){
        return Arrays.toString(this.list);
    }

    private int getFirstEmptyIndex(){

        for (int i = 0; i<this.list.length; i++){
            if (this.list[i] == null){
                return i;
            }
        }
        return -1;


    }
}
