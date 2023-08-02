package MCO;

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
    private ArrayList<Item> transactionList; 
    private int collectedMoney;
    private Slot[] startingInventory; 

     /** Initializes values to certain variables in the class Transaction
     * 
     */
    public Transaction(Slot[] startingInventory){
        //to start of a transaction from the moment of restocking/stocking
        transactionList = new ArrayList<Item>(); 
        this.startingInventory = new Slot[startingInventory.length];
        for (int i = 0; i < startingInventory.length; i++){
            this.startingInventory[i] = new Slot(startingInventory[i].getItem(), startingInventory[i].getNumItem());
        }
        collectedMoney = 0; 
              
        
    }
    /** Adds an item to item list
     * @param itemSold
     */
    public void addItemSold(Item itemSold){
        this.transactionList.add(itemSold);
    }

    /** Prints the transaction details
     * @param numTransactions number of transactions
     */
    public void printDetails(int numTransactions){
        int i = 0, j = 0; 

        System.out.println("\nTransaction History #" + transactionList.size());
        //printing items sold
        System.out.println("ITEMS SOLD");
        for (int k = 0; k < transactionList.size(); k++){
            System.out.println((k+1) + ".) " + transactionList.get(k).getName());
        }
        System.out.println("MONEY COLLECTED");
        System.out.println("Obtained " + this.collectedMoney + " pesos!");
        System.out.println("");
        System.out.println("ENDING INVENTORY");
        /*while (j < endingInventory.size() && endingInventory.get(j) != null){
            System.out.print((j+1) + ".) " + endingInventory.get(j).getItem().getName());
            System.out.println(" : " + endingInventory.get(j).getNumItem() + " pcs.");
            j++;
        }*/
        System.out.println("");

    }

    /** Gets the items sold
     * @return the items sold
     */
    public ArrayList<Item> getItemsSold() {
        return transactionList;
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
    public Slot[] getStartingInventory() {
        return this.startingInventory;
    }


    /** Gets the ending inventory
     * @return the ending inventory
     */
    public void setCollectedMoney(int collectedMoney) {
        this.collectedMoney += collectedMoney;
    }

}
    
    

