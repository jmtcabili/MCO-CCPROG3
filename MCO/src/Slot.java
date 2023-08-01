import java.util.*;
/**
 * This class contains the getters and setters of slot
 * @author Johan Marlo T. Cabili
 * @author Joemar T. Lapasaran
 * @version 1.0
 */
public class Slot {
    private ArrayList<Item> itemList;
    private Item item;


     /** Blueprint of the class slot
     * @param item is the item to be inserted in the slot
     */
    public Slot (Item item) {
        this.item = item;
        this.itemList = new ArrayList<Item>(); 
    }

    /** Gathers the number of items inside the slot
     * @return the number of items inside the slot
     */
    public void stockItem(Item item, int quantity){
        for (int i = 1; i <= quantity; i++){
            itemList.add(item);
        }
        System.out.println(itemList.size());
    }
    public int getNumItem () {
        return itemList.size();
    }

    /** Gathers the item to be placed inside the slot
     * @return the item to be placed inside the slot
     */
    public Item getItem () {
        return item;
    }
}

    
