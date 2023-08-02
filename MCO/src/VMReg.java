
import java.util.*; 
/**
 * This class is responsible for most of the main functions of the vending machine.
 * @author Johan Marlo T. Cabili
 * @author Joemar T. Lapasaran
 * @version 1.0
 */

public class VMReg {
    protected String name; 
    protected Slot[] slots;
    private int slotItemLimit; 
    private boolean isInitialized = false; 
    protected Money moneyCompartment;
    protected int numTransactions;
    protected ArrayList<Transaction> transactions;
    protected boolean justStocked; 
    protected boolean hasTransacted; 

    /** Blueprint of the VMReg class
     * @param name is the name of the vending machine
     * @param slotCount is the index to access a specific slot
     * @param slotItemLimit is how much items can there be in the slot
     */
    public VMReg(String name, int slotCount, int slotItemLimit){
        this.name = name; 
        this.slots = new Slot[slotCount];
        this.slotItemLimit = slotItemLimit;
        this.moneyCompartment = new Money(); 
        this.transactions = new ArrayList<Transaction>();
        this.numTransactions = 0; 
        this.justStocked = false; 
        this.hasTransacted = false; 
    }

    //new functions
    public void setSlot(int slotIdx, Slot slot){
        this.slots[slotIdx] = slot; 
    }

    public String returnInventory(){
        int i = 0; 
        String message = "INVENTORY: \n";
        while (i < this.slots.length && slots[i] != null){
            message += (i+1 + ".) " + slots[i].getItem().getName() + " - " + slots[i].getItem().getPrice() + "Php - " + slots[i].getItem().getCalories() + " cal - " + slots[i].getNumItem()+ " pcs - " + slots[i].getItem().getClass().getName() + "\n");
            i++;
        }
        return message; 
    }

    public void setInitialized(boolean bool){
        this.isInitialized = bool; 
    }

    /** Produces change to be given to the user
     * @param change change needed
     * @param price price of the product to be bought 
     */
    public boolean produceChange(int change, int price){
        //total ob1 - price = change 
        boolean sufficientChange = false; 
        
        
        if (change >= 100 && this.moneyCompartment.getBill100() >= change/100){
            moneyCompartment.setBill100(-(change/100));
            change = change % 100;
        }
        if (change >= 50 && this.moneyCompartment.getBill50() >= change/50){
            this.moneyCompartment.setBill50(-(change/50));
            change = change % 50;
        }
        if (change >= 20 && this.moneyCompartment.getBill20() >= change/20){
            this.moneyCompartment.setBill20(-(change/20));
            change = change % 20;
        }
        if (change >= 20 && this.moneyCompartment.getCoin20() >= change/20){
            this.moneyCompartment.setCoin20(-(change/20));
            change = change % 20;
        }
        if (change >= 10 && this.moneyCompartment.getCoin10() >= change/10){
            this.moneyCompartment.setCoin10(-(change/10));
            change = change % 10;
        }
        if (change >= 5 && this.moneyCompartment.getCoin5() >= change/5){
            this.moneyCompartment.setCoin5(-(change/5));
            change = change % 5;
        }
        if (change >= 1 && this.moneyCompartment.getCoin1() >= change/1){
            this.moneyCompartment.setCoin1(-(change/1));
            change = change % 1;
        }
        if (change == 0)
            sufficientChange = true; 

        return sufficientChange; 
    }



    /** Gathers the name of the vending machine
     * @return the name of the vending machine
     */
    public String getName() {
        return name;
    }

    /** Sets the name of the vending machine
     * @param name is the name inputted by the user
     */
    public void setName(String name) {
        this.name = name;
    }

    /** Gathers the slot inside the vending machine
     * @return the slots inside the vending machine
     */
    public Slot[] getSlots() {
        return slots;
    }

    /** Sets the slots of the vending machine
     * @param slots are slots inside the vending machine
     */
    public void setSlots(Slot[] slots) {
        this.slots = slots;
    }

    /** Gathers the limit of items inside the slot
     * @return the limit of items inside the slot
     */
    public int getSlotItemLimit() {
        return slotItemLimit;
    }

    /** Sets the limit of items inside a slot
     * @param slotItemLimit is an integer that mirrors the limit of items inside a slot
     */
    public void setSlotItemLimit(int slotItemLimit) {
        this.slotItemLimit = slotItemLimit;
    }

    /** Gets the money from the money class
     * @return the money from the money class
     */
    public Money getMoneyCompartment() {
        return moneyCompartment;
    }

    /** Sets the money from the money class
     * @param moneyCompartment money from the money class
     */
    public void setMoneyCompartment(Money moneyCompartment) {
        this.moneyCompartment = moneyCompartment;
    }

    /** Gathers the number of transactions
     * @return the number of transactions
     */
    public int getNumTransactions() {
        return numTransactions;
    }

    /** Sets the number of transactions
     * @param numTransactions is the number of transactions
     */
    public void setNumTransactions(int numTransactions) {
        this.numTransactions = numTransactions;
    }

    /** Gathers the array list of transactions
     * @return the array list of transactions
     */
    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    /** Determines if an item is just stocked
     * @return true or false depending if item has just been stocked
     */
    public boolean isJustStocked() {
        return justStocked;
    }

    /** Sets item if it is just stocked or not
     * @param justStocked status if item has been stocked or not
     */
    public void setJustStocked(boolean justStocked) {
        this.justStocked = justStocked;
    }
    public boolean getIsInitialized(){
        return this.isInitialized; 
    }

}