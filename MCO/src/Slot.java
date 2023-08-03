
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
    /** Blueprint of the class slot
     * @param item is the item to be inserted in the slot
     * @param quantity the number of items
     */
    public Slot (Item item, int quantity) {
        this.item = item;
        this.itemList = new ArrayList<Item>(); 
        for (int i = 1; i <= quantity; i++){
            itemList.add(item);
        }
    }


    /** Gathers the number of items inside the slot. Returns the number of items inside the slot
     */
    public void stockItem(Item item, int quantity){
        for (int i = 1; i <= quantity; i++){
            itemList.add(item);
        }
        System.out.println(itemList.size());
    }
    /** Gathers the number of items inside the itemlist
     * @return the number of items inside the itemList
     */
    public int getNumItem () {
        return itemList.size();
    }

    /** Disposes of an item and removes it from the list
     * 
     */
    public void sellItem(){
        int lastIndex = this.itemList.size()-1;
        this.itemList.remove(lastIndex);
    }

    /** Gathers the item to be placed inside the slot
     * @return the item to be placed inside the slot
     */
    public Item getItem () {
        return item;
    }
}

    
