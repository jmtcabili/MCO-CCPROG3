package MCO1;
import java.util.ArrayList;

public class Transaction {
    private ArrayList<Item> itemsSold = new ArrayList<Item>(); 
    private int collectedMoney;
    private Slot[] startingInventory;
    private Slot[] endingInventory; 

    public Transaction(Slot[] startingInventory){
        //to start of a transaction from the moment of restocking/stocking
        this.startingInventory = startingInventory;
    }

    public void addItemSold(Item itemSold){
        this.itemsSold.add(itemSold);
    }


    public ArrayList<Item> getItemsSold() {
        return itemsSold;
    }

    public int getCollectedMoney() {
        return collectedMoney;
    }

    public Slot[] getStartingInventory() {
        return startingInventory;
    }

    public Slot[] getEndingInventory() {
        return endingInventory;
    }

    //to change
    public void setCollectedMoney(int collectedMoney) {
        this.collectedMoney = collectedMoney;
    }

    public void setEndingInventory(Slot[] endingInventory) {
        this.endingInventory = endingInventory;
    }
    
    
}
