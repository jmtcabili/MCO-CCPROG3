package MCO1;
public class Slot {
    private int numItem = 0;
    private int numItemLimit;
    private Item item;

    public Slot (int numItemLimit, Item item) {
        this.numItemLimit = numItemLimit;
        this.item = item;
    }

    public int getNumItem () {
        return numItem;
    }

    public int getNumItemLimit () {
        return numItemLimit;
    }

    public Item getItem () {
        return item;
    }

    public void setNumItem (int numModified) {
        this.numItem += numModified;
    }
}
