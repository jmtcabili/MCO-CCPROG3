import java.util.*;
import java.util.ArrayList;

/**
 * This class contains methods that updates each history of transaction
 * and also its getters and setters. 
 * @author Johan Marlo T. Cabili
 * @author Joemar T. Lapasaran
 * @version 1.0
 */

public class Transaction {
    private ArrayList<Item> itemsSold; 
    private int collectedMoney;

    private ArrayList<Slot> endingInventory; 

     /** Initializes values to certain variables in the class Transaction
     * 
     */
    public Transaction(){
        //to start of a transaction from the moment of restocking/stocking
        endingInventory = new ArrayList<Slot>();
        collectedMoney = 0; 
        itemsSold = new ArrayList<Item>();        
        
    }
    /** Adds an item to item list
     * @param itemSold
     */
    public void addItemSold(Item itemSold){
        this.itemsSold.add(itemSold);
    }

    /** Adds the ending slot inventory
     * @param slot is a slot inside the vending machine
     */
    public void addEndingslot(Slot slot){
        this.endingInventory.add(slot);
    }

    /** Prints the transaction details
     * @param numTransactions number of transactions
     */
    public void printDetails(int numTransactions){
        int i = 0, j = 0; 

        System.out.println("\nTransaction History #" + numTransactions);
        //printing items sold
        System.out.println("ITEMS SOLD");
        for (int k = 0; k < itemsSold.size(); k++){
            System.out.println((k+1) + ".) " + itemsSold.get(k).getName());
        }
        System.out.println("MONEY COLLECTED");
        System.out.println("Obtained " + this.collectedMoney + " pesos!");
        System.out.println("");
        System.out.println("ENDING INVENTORY");
        while (j < endingInventory.size() && endingInventory.get(j) != null){
            System.out.print((j+1) + ".) " + endingInventory.get(j).getItem().getName());
            System.out.println(" : " + endingInventory.get(j).getNumItem() + " pcs.");
            j++;
        }
        System.out.println("");

    }

    /** Gets the items sold
     * @return the items sold
     */
    public ArrayList<Item> getItemsSold() {
        return itemsSold;
    }

    /** Gets the collected money
     * @return the collected money
     */
    public int getCollectedMoney() {
        return collectedMoney;
    }

    /** Gets the starting inventory
     * @return the starting inventory
     */
    public ArrayList<Slot> getEndingInventory() {
        return endingInventory;
    }

    /** Gets the ending inventory
     * @return the ending inventory
     */
    public void setCollectedMoney(int collectedMoney) {
        this.collectedMoney += collectedMoney;
    }
    public void addStartingSlot(Slot slot) {
    }

}
    
    

