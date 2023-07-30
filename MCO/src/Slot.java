package MCO.src;
/**
 * This class contains the getters and setters of slot
 * @author Johan Marlo T. Cabili
 * @author Joemar T. Lapasaran
 * @version 1.0
 */
public class Slot {
    private int numItem;
    private Item item;

     /** Blueprint of the class slot
     * @param item is the item to be inserted in the slot
     */
    public Slot (Item item) {
        this.item = item;
        this.numItem = 0; 
    }

    /** Gathers the number of items inside the slot
     * @return the number of items inside the slot
     */
    public int getNumItem () {
        return numItem;
    }

    /** Gathers the item to be placed inside the slot
     * @return the item to be placed inside the slot
     */
    public Item getItem () {
        return item;
    }

    /** Sets the number of items to be placed inside the slot 
     * @param numModified adds the number of items to be placed inside the slot
     */
    public void setNumItem (int numModified) {
        this.numItem += numModified;
    }
}
