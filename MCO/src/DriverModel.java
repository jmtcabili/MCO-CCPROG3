
import java.util.*;

/**
 * This class is responsible for handling the methods that are used to modify the view attributes
 * @author Johan Marlo T. Cabili
 * @author Joemar T. Lapasaran
 * @version 1.0
 */
public class DriverModel {
    private ArrayList<VMReg> machineList = new ArrayList<>();
    private VMSpecial[] vmSpecial = new VMSpecial[1];

    private Money payment = new Money();
    /** Blueprint of the DriverModel class
     * 
     */

    public DriverModel(){
        this.machineList = new ArrayList<VMReg>();
    }

    /** Adds a machine to the machine list
     * @param name the name of the vending machine
     * @param slotcount the number of slots in a machine
     * @param itemCount the lowest limit for item stock
     * @param VMtype a string represengin the type of vending machine
     */
    public void addMachine(String name, String slotcount, String itemCount, String VMtype){
        
        if (VMtype.equals("Special")){
            this.machineList.add(new VMSpecial(name, Integer.parseInt(slotcount), Integer.parseInt(itemCount)));
            vmSpecial[0] = new VMSpecial(name, Integer.parseInt(slotcount), Integer.parseInt(itemCount));
        }
        else
            this.machineList.add(new VMReg(name, Integer.parseInt(slotcount), Integer.parseInt(itemCount)));
            
        //add a condition to check if vmtype is special or regular
    }
    /** Finds a machine name in the list
     * @param name the name of the vending machine
     */
    public boolean isFound(String name){//for the machine
        boolean isFound = false; 
        int i = 0; 

        while (i < machineList.size() && isFound == false){
            if (machineList.get(i).getName().equals(name))
                isFound = true; 
            i++;
        }
        return isFound; 
    }
    /** Counts number of empty slots
     * 
     */
    public int countEmptySlot(){
        int countEmpty = 0; 
        for (int i = 0; i < getLatestMachine().getSlots().length; i++){
            if (getLatestMachine().getSlots()[i] == null)
                countEmpty++;
        }
        return countEmpty; 
    }
    /** Returns the index of an emptySlot
     * 
     */
    public int emptySlot(){
        boolean hasEmptySlot = false; 
        int emptySlot = -1;
        int i = 0; 
        while (i < getLatestMachine().getSlots().length && hasEmptySlot == false){
            if (getLatestMachine().getSlots()[i] == null){
                hasEmptySlot = true; 
                emptySlot = i; 
            }
            i+=1;
        }
        return emptySlot; 
    }

    /** Prints the machine list
     * 
     */
    public String printMachines(){
        String message = ""; 

        for (int i = 0; i < machineList.size(); i++){
            message+= ((i+1) + ".) " + machineList.get(i).getName()+ " - " + machineList.get(i).getClass().getName() + "\n");
            System.out.println(message);
        }
        return message; 
    }
    
    /** Returns the last machine that was created
     * @return latest machine
     */
    public VMReg getLatestMachine(){
        return machineList.get(machineList.size()-1); 
    }

    /** Finds item with same name as parameter
     * @param itemName name of an item
     * @return the item with the same name
     */
    public Item itemFound(String itemName){
        boolean itemFound = false; 
        Item item = null; 
        int i = 0; 

        while (i < getLatestMachine().getSlots().length && getLatestMachine().getSlots()[i]!= null &&
                itemFound == false){
            if (getLatestMachine().getSlots()[i].getItem().getName().equals(itemName)){
                itemFound = true;
                item = getLatestMachine().getSlots()[i].getItem(); 
            }
            i++;
        }
        return item; 
    }
    /** Finds the slot index in the machine that contains a certain item
     * @param item an item
     * @return slot index (int)
     */
    public int findSlotIdx(Item item){
        int slotIdx = -1; 

        boolean slotFound = false; 
        int i = 0; 

        while (i < getLatestMachine().getSlots().length && getLatestMachine().getSlots()[i]!= null &&
                slotFound == false){
            if (getLatestMachine().getSlots()[i].getItem().getName().equals(item.getName())){
                slotFound = true; 
                slotIdx = i; 
            }
            i++;
        }
        return slotIdx; 
    }
    /** Returns the denominations inside a machine
     * @return string message of the denominations
     */
    public String returnDenominations(){
        String message = "Denominations: \n";
        message += ("1-Peso Coin : " + getLatestMachine().getMoneyCompartment().getCoin1()+"\n");
        message += ("5-Peso Coin : " + getLatestMachine().getMoneyCompartment().getCoin5()+"\n");
        message += ("10-Peso Coin : " + getLatestMachine().getMoneyCompartment().getCoin10()+"\n");
        message += ("20-Peso Coin : " + getLatestMachine().getMoneyCompartment().getCoin20()+"\n");
        message += ("20-Peso Bill : " + getLatestMachine().getMoneyCompartment().getBill20()+"\n");
        message += ("50-Peso Bill : " + getLatestMachine().getMoneyCompartment().getBill50()+"\n");
        message += ("100-Peso Bill : " + getLatestMachine().getMoneyCompartment().getBill100()+"\n");        

        return message; 
    }
    /**Empties out the moneycompartment in the latest machine
     */
    public void clearMoneyCompartment(){
        getLatestMachine().getMoneyCompartment().setCoin1(-getLatestMachine().getMoneyCompartment().getCoin1());
        getLatestMachine().getMoneyCompartment().setCoin5(-getLatestMachine().getMoneyCompartment().getCoin5());
        getLatestMachine().getMoneyCompartment().setCoin10(-getLatestMachine().getMoneyCompartment().getCoin10());
        getLatestMachine().getMoneyCompartment().setCoin20(-getLatestMachine().getMoneyCompartment().getCoin20());
        getLatestMachine().getMoneyCompartment().setBill20(-getLatestMachine().getMoneyCompartment().getBill20());
        getLatestMachine().getMoneyCompartment().setBill50(-getLatestMachine().getMoneyCompartment().getBill50());
        getLatestMachine().getMoneyCompartment().setBill100(-getLatestMachine().getMoneyCompartment().getBill100());
    }
    /**Adds the denominations in @param payment to money compartment
    * @param payment a money object reflecting the paymetn 
    */
    public void addToMoney(Money payment){
        getLatestMachine().getMoneyCompartment().setCoin1(payment.getCoin1());
        getLatestMachine().getMoneyCompartment().setCoin5(payment.getCoin5());
        getLatestMachine().getMoneyCompartment().setCoin10(payment.getCoin10());
        getLatestMachine().getMoneyCompartment().setCoin20(payment.getCoin20());
        getLatestMachine().getMoneyCompartment().setBill20(payment.getBill20());
        getLatestMachine().getMoneyCompartment().setBill50(payment.getBill20());
        getLatestMachine().getMoneyCompartment().setBill100(payment.getBill100());
    }
    /**Returns the payment Money 
    * @return payment  
    */
    public Money getPayment () {
        return this.payment;
    }

    /**Clears the denominations in payment
    *   
    */
    public void clearPayment(){
        this.payment.setCoin1(-payment.getCoin1());
        this.payment.setCoin5(-payment.getCoin5());
        this.payment.setCoin10(-payment.getCoin10());
        this.payment.setCoin20(-payment.getCoin20());
        this.payment.setBill20(-payment.getBill20());
        this.payment.setBill50(-payment.getBill50());
        this.payment.setBill100(-payment.getBill100());
    }
    /**Clears the denominations in payment
    *  @return a string message on the transaction details
    */
    public String returnTransactions(){
        String message = "";

        for (int j = 0; j < getLatestMachine().getTransactions().size(); j++){
            //starting inventory
            message += "STARTING INVENTORY - " + (j+1) + "\n";
            Slot[] tempStart = getLatestMachine().getTransactions().get(j).getStartingInventory();
            int k = 0; 
            while (k < getLatestMachine().getTransactions().get(j).getStartingInventory().length &&  getLatestMachine().getTransactions().get(j).getStartingInventory()[k] != null){
                message += ((k+1) + ".) " + tempStart[k].getItem().getName() + " - " + tempStart[k].getItem().getPrice() + "Php - " + tempStart[k].getItem().getCalories() + " cal - " + tempStart[k].getNumItem()+" pcs \n");
                k++;
            }
            //current inventory
            message += getLatestMachine().returnInventory();

            //items sold
            message += "Total items sold: " + getLatestMachine().getTransactions().get(j).getItemsSold().size() + "\n";
            for (int i = 0; i < getLatestMachine().getTransactions().get(j).getItemsSold().size(); i++){
                message += ((i+1) + ".) " + getLatestMachine().getTransactions().get(j).getItemsSold().get(i).getName());
            
            message += "\n";
        }
        }
        return message; 
    }
    /**Returns latest instance of a special vending machine
    *   @return VMSpecial instance
    */
    public VMSpecial getVmSpecial(){
        return this.vmSpecial[0];
    }
    /**Returns a string message of the order bag of the user 
    *   @return Order bag contents (string)
    */
    public String displayOrderBag(){
        String message = "Order Bag: \n";

        for (int i = 0; i < vmSpecial[0].getOrderBag().size(); i++){
            System.out.println(i + "). " + vmSpecial[0].getOrderBag().get(i).getName());
            message += ((i+1)+ ".) " + vmSpecial[0].getOrderBag().get(i).getName()+"\n");
        }
        message += "\n";
        return message; 
    }

    public void bagToSlot(){
        boolean foundItem; 
        //loop through bag 
        //find item in bag in designated slot, stock item
        int size = getVmSpecial().getOrderBag().size();
        for (int i = 0; i < size; i++){
            foundItem = false; 
            int j = 0;
            while (j < getLatestMachine().slots.length && foundItem == false){
                if (getVmSpecial().getOrderBag().get(i).getName().equals(getLatestMachine().getSlots()[j].getItem().getName())){
                    foundItem = true; 
                    getLatestMachine().getSlots()[j].stockItem(getVmSpecial().getOrderBag().get(i), 1);
                }
                j++;
            }
        }

    }
}

