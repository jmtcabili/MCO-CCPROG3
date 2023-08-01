
import java.util.*; //THIS IS THE MOST UPDATED VMREG
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
    protected Money moneyCompartment;
    protected int numTransactions;
    protected ArrayList<Transaction> transactions = new ArrayList<Transaction>();
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
        this.numTransactions = 0; 
        this.justStocked = false; 
        this.hasTransacted = false; 
    }

    /** Allows the user to test the vending machine
     * @param sc scanner that scans an input from the user
     */
    public void Test(Scanner sc){
        boolean isTesting = true; 
        int slotChosen; 
        Money payment = null; 

        //check if vending machine has contents in driver
        if (slots[0] != null){
            while(isTesting == true){
                if (payment == null)
                    displayItems();
                else
                    displayItems(payment.getTotalMoney());

                System.out.println("Insert payment : ");
                payment = receivePayment(sc);
                
                displayItems(payment.getTotalMoney());
                System.out.println("\b[0] Exit");
                Slot tempSlot = new Slot(null); 

                //TO DO : Fix input validation here
                do{
                    System.out.print("Enter slot number of item to buy : ");
                    slotChosen = sc.nextInt(); 
                    if(slotChosen > 0)
                        tempSlot = slots[slotChosen-1];
                    if (slotChosen < 0){
                        System.out.println("Please enter a valid option");
                    }
                } while (slotChosen < 0 || tempSlot == null) ;

                if (slotChosen == 0){
                    isTesting = false; //goes out of Test()
                } 
                else{
                    if (checkChange(payment, slotChosen-1) == false){
                        System.out.println("There is not enough change in the machine.");
                        System.out.println("Returned " + payment.getTotalMoney());
                        payment = null;
                    }
                    else if (slots[slotChosen-1].getNumItem() == 0){
                        System.out.println("The item you picked is out of stock");
                        System.out.println("Returned " + payment.getTotalMoney());
                        payment = null;
                    }
                    else if (payment.getTotalMoney() < slots[slotChosen-1].getItem().getPrice()){
                        System.out.println("Insufficient balance");
                        System.out.println("Returned " + payment.getTotalMoney());
                        payment = null; 
                    }
                    else{
                        //payment goes through, increment transaction money
                        //adding to moneybox
                        System.out.println("Dispensed " + slots[slotChosen-1].getItem().getName());
                        System.out.println("Your change is : " + (payment.getTotalMoney() - slots[slotChosen-1].getItem().getPrice()));
                        if (this.justStocked == true){
                            
                            Transaction startTransaction = new Transaction();
                            transactions.add(startTransaction);
                            int k = 0; 
                            while (k < slots.length && slots[k] != null){
                                transactions.get(numTransactions).addStartingSlot(slots[k]);     
                                k++;                      
                            }  
                            justStocked = false; 
                        }

                        this.transactions.get(numTransactions).setCollectedMoney(slots[slotChosen-1].getItem().getPrice());
                        this.transactions.get(numTransactions).addItemSold(slots[slotChosen-1].getItem());
                        produceChange(payment.getTotalMoney(), slots[slotChosen-1].getItem());
                        this.moneyCompartment.setCoin1(payment.getCoin1());
                        this.moneyCompartment.setCoin5(payment.getCoin5());
                        this.moneyCompartment.setCoin10(payment.getCoin10());
                        this.moneyCompartment.setCoin20(payment.getCoin20());
                        this.moneyCompartment.setBill20(payment.getBill20());
                        this.moneyCompartment.setBill50(payment.getBill50());
                        this.moneyCompartment.setBill100(payment.getBill100());
                        this.moneyCompartment.setBill500(payment.getBill500());
                        payment = null; 
                        dispenseItem(slotChosen-1);
                        this.hasTransacted = true; 

                        
                    }
                        
                }
            }
        } else
            System.out.println("Machine has no designated slots");
    }


    /** Receives payment from the user
     * @param sc scanner that scans an input from the user
     * @return returns the payment received from the user
     */
    private Money receivePayment(Scanner sc){
        boolean isPaying = true; 
        int choice;
        int numDenomination; 
        Money payment = new Money(); 
        while (isPaying){
            
            System.out.println("[1] 1-Peso Coin");
            System.out.println("[2] 5-Peso Coin");
            System.out.println("[3] 10-Peso Coin");
            System.out.println("[4] 20-Peso Coin");
            System.out.println("[5] 20-Bill Bill");
            System.out.println("[6] 50-Bill Coin");
            System.out.println("[7] 100-Bill Coin");
            System.out.println("[8] 500-Bill Coin");
            System.out.println("[0] Exit");
            System.out.print("Select denomination:");

            
            do{
                choice = sc.nextInt();
                if (choice < 0 || choice > 8)
                    System.out.println("Enter a valid input.");
            }while (choice < 0 || choice > 8);
            //validate choice

            if (choice != 0){
                System.out.println("How many denominations? ");
                numDenomination = sc.nextInt();

                switch(choice){
                    case 1: 
                        payment.setCoin1(numDenomination);
                        break;
                    case 2: 
                        payment.setCoin5(numDenomination);
                        break;
                    case 3: 
                        payment.setCoin10(numDenomination);
                        break;
                    case 4: 
                        payment.setCoin20(numDenomination);
                        break;
                    case 5: 
                        payment.setBill20(numDenomination);
                        break;
                    case 6: 
                        payment.setBill50(numDenomination);
                        break;
                    case 7: 
                        payment.setBill100(numDenomination);
                        break;
                    case 8: 
                        payment.setBill500(numDenomination);
                        break;
                }
            }
            else{
                System.out.println("Exiting payment...");
                isPaying = false; 
            }
            System.out.println("Total : " + payment.getTotalMoney());
        }
        
        return payment; 
    }  


    /** Dispenses a chosen item from the vending machine
     * @param slotIndex is an index to determine a specific vending machine
     */
    private void dispenseItem(int slotIndex){
        this.slots[slotIndex].setNumItem(-1);
    }

    /** Checks the change to be given to the user
     * @param payment the money that the user inserted in the vending machine
     * @param slotIndex index to check a specific slot
     * @return the change that will be given to the user
     */
    private boolean checkChange(Money payment, int slotIndex){
        int tempChange; 
        tempChange = payment.getTotalMoney() - slots[slotIndex].getItem().getPrice();
        return (this.moneyCompartment.getTotalMoney() - tempChange >= 0);
    }
    /** Produces change to be given to the user
     * @param payment is the payment inserted in the vending machine
     * @param itemToBuy indicator to determine the price of the item 
     */
    private void produceChange(int payment, Item itemToBuy){
        //should be no errors here since nag check change ka na 
        int change = payment-itemToBuy.getPrice();
        while (change > 0){
            while (change >= 500 && this.moneyCompartment.getBill500() > 0){
                change -= 500;
                this.moneyCompartment.setBill500(-1);
            }
            while (change >= 100 && this.moneyCompartment.getBill100() > 0){
                change -=100;
                this.moneyCompartment.setBill100(-1);
            }
            while (change >= 50 && this.moneyCompartment.getBill50() > 0){
                change -= 50; 
                this.moneyCompartment.setBill50(-1);
            }
            while (change >= 20 && this.moneyCompartment.getBill20() > 0){
                change -=20;
                this.moneyCompartment.setBill20(-1);
            }
            while (change >= 20 && this.moneyCompartment.getCoin20() > 0){
                change -= 20; 
                this.moneyCompartment.setCoin20(-1);
            }
            while (change >= 10 && this.moneyCompartment.getCoin10() > 0){
                change -= 10; 
                this.moneyCompartment.setCoin10(-1);
            }
            while (change >= 5 && this.moneyCompartment.getCoin5() > 0){
                change -= 5; 
                this.moneyCompartment.setCoin5(-1);
            }
            while (change >= 1 && this.moneyCompartment.getCoin1() > 0){
                change -=1; 
                this.moneyCompartment.setCoin1(-1);
            }
        }
    }

    
    /** Displays the items in the vending machine
     * @param payment money inserted into the vending machine by the user
     */
    private void displayItems(int payment){
        int i = 0;

  
        System.out.println("\n\t|| " + this.name + "'s Vending Machine! ||\n");
        System.out.println("Money inserted: " + payment);
        System.out.println("Change available : " + moneyCompartment.getTotalMoney() +"\n");
        
        while (i < slots.length && slots[i] != null){
            System.out.print("[" + (i+1) +"]"+slots[i].getItem().getName());
            System.out.print(" (" + slots[i].getItem().getCalories() + " cal) - ");
            System.out.print(slots[i].getItem().getPrice() + " pesos ");
            System.out.println("- " + slots[i].getNumItem() + "pc");
            i++;
        }
        System.out.println("");
    }

    /** Displays the items in the vending machine
     * 
     */
    private void displayItems(){
        int i = 0;

        
        System.out.println("\n\t|| " + this.name + "'s Vending Machine! ||\n");
        System.out.println("Change available : " + moneyCompartment.getTotalMoney() + "\n");
        
        while (i < slots.length && slots[i] != null){
            System.out.print("[" + (i+1) +"]"+slots[i].getItem().getName());
            System.out.print(" (" + slots[i].getItem().getCalories() + " cal) - ");
            System.out.print(slots[i].getItem().getPrice() + " pesos ");
            System.out.println("- " + slots[i].getNumItem() + "pc");
            i++;
        }
        System.out.println("");
    }

    /** An option that allows the user/admin to perform maintenance on the vending machine
     * @param sc scanner that receives input from the user
     */
    public void maintenance (Scanner sc) {
        int choice = 0;
        int slotNum;
        String buffer; 
        while (choice != 8){
            do{ 
                displayItems();
                System.out.println("[1] Stock Items");
                System.out.println("[2] Restock Items");
                System.out.println("[3] Set New Price");
                System.out.println("[4] Collect Payment");
                System.out.println("[5] Add Change");
                System.out.println("[6] Available Denominations");
                System.out.println("[7] Transaction History");
                System.out.println("[8] Exit");
                System.out.print("Enter choice: ");
                choice = sc.nextInt();
                buffer = sc.nextLine();
                if (choice < 1 || choice > 8)
                    System.out.println("Enter a valid choice.");
            } while (choice < 1 || choice > 8);
        
            switch (choice) {
                case 1:
                    stockVending(sc);
                    break;
                case 2: 
                    displayItems();
                    do{
                        System.out.print("Choose a slot: ");
                        slotNum = sc.nextInt();
                        if (slots[slotNum-1] == null)
                            System.out.println("Invalid slot number. Pick again");
                    }while (slots[slotNum-1] == null);
                    restockVending(slotNum-1, sc);
                    break;
                case 3: 
                    do{
                        System.out.print("Choose a slot: ");
                        slotNum = sc.nextInt();
                        if (slots[slotNum-1] == null)
                            System.out.println("Invalid slot number. Pick again");
                    }while (slots[slotNum-1] == null);
                    setNewPrice(slotNum-1, sc);
                    break;
                case 4:
                    collectPayment();
                    break;
                case 5: 
                    addChange(sc);
                    break;
                case 6: 
                    System.out.println("1-peso coins : " + this.moneyCompartment.getCoin1());
                    System.out.println("5-peso coins : " + this.moneyCompartment.getCoin5());
                    System.out.println("10-peso coins : " + this.moneyCompartment.getCoin10());
                    System.out.println("20-peso coins : " + this.moneyCompartment.getCoin20());
                    System.out.println("20-peso bills : " + this.moneyCompartment.getBill20());
                    System.out.println("50-peso bills : " + this.moneyCompartment.getBill50());
                    System.out.println("100-peso bills : " + this.moneyCompartment.getBill100());
                    System.out.println("500-peso bills : " + this.moneyCompartment.getBill500());
                    System.out.println("Total : " + this.moneyCompartment.getTotalMoney());
                    break;
                case 7: 
                    int j = 0;
                    if (numTransactions != 0){
                        while (j < transactions.size()){
                            transactions.get(j).printDetails(transactions.size());
                            j++;
                        }
                    } else
                        System.out.println("Please restock/stock again to conclude transaction history");
                    

                default: 
                    break;
            }
        }
       
        
    }
    
        
    /** Allows the user to stock items into the vending machine
     * @param sc scanner that receives input from the user
     */
    private void stockVending (Scanner sc) {
        boolean emptyFound = false;
        int i = 0, j = 0;
        int calories, price, amount;
        String buffer; 
        boolean isFound = false; 

        if (this.justStocked == false && this.hasTransacted == true){
            System.out.println(numTransactions);
            int k = 0; 
            while (k < slots.length && slots[k] != null){
                transactions.get(numTransactions).addEndingslot(slots[k]);
                k++;
            }
            //this.tempEnding = Arrays.copyOf(slots, slots.length);
            /*
            System.out.println(tempStarting[0].getItem().getName());
            System.out.println(tempStarting[0].getNumItem());
            System.out.println(tempStarting[1].getItem().getName());
            System.out.println(tempStarting[1].getNumItem());
            System.out.println(tempEnding[0].getItem().getName());
            System.out.println(tempEnding[0].getNumItem());
            System.out.println(tempEnding[1].getItem().getName());
            System.out.println(tempEnding[1].getNumItem());
            */
            System.out.println("added ending");
            
            //maybe test
            this.numTransactions++;
            this.hasTransacted = false; 
            
        }

    
        if (slots != null){
            while (i<slots.length && emptyFound == false) {
                if (slots[i] == null) {
                    emptyFound = true;
                }
                i++;
            }
        }

        if (emptyFound == true || slots == null) {
            System.out.print("Enter the name of the product: ");
            String name = sc.nextLine();
            
            for (j = 0; j < slots.length; j++) {
                if (slots[j] != null){
                    if (name.equals(slots[j].getItem().getName())) {
                        System.out.println("Product is already inside the machine!");
                        isFound = true;
                    }
                }
            }

            if (isFound == false) {
                do {
                    System.out.print("Enter the calories of the product: ");
                    calories = sc.nextInt();
                    
                    if (calories < 0) { 
                        System.out.println("Please enter a nonnegative input!");
                    }
                } while (calories < 0);
                do {
                    System.out.print("Enter the price of the product: ");
                    price = sc.nextInt();
                    buffer = sc.nextLine();
                    if (price < 1 || price > 1000) { 
                        System.out.println("Please enter a price between 1 and 1000 pesos!");
                    }
                } while (price < 1 || price > 1000);
                do {
                    System.out.print("Enter the amount to add: ");
                    amount = sc.nextInt();
                    buffer = sc.nextLine();
                    if (amount < 0 || amount > slotItemLimit) { 
                        System.out.println("Please enter an input from 0 to " + slotItemLimit);
                    }
                } while (amount < 0 || amount > slotItemLimit);
                Item item = new Item (name, calories, price);
                Slot slot = new Slot(item);
                //TO DO : Change constructor for slot
                this.slots[i-1] = slot;
                this.slots[i-1].setNumItem(amount);
                this.justStocked = true; 
            }
            
        }
        
    }
    
    /** Allows the user to restock items into the vending machine
     * @param slotIndex index to determine a specific slot in the vending machine
     * @param sc scanner that asks input from the user
     */
    private void restockVending (int slotIndex, Scanner sc) {
        int quantity; 
        int k = 0; 
        if (justStocked == false && hasTransacted == true){
            while (k < slots.length && slots[k] != null){
                transactions.get(numTransactions).addEndingslot(slots[k]);
                k++;
            }
            numTransactions++;
            hasTransacted = false; 
        }

        if (slots[slotIndex].getNumItem() == this.slotItemLimit) {
            System.out.println("Cannot restock slots! Stock is full.");
        }
        else {
            System.out.println("There are currently " + slots[slotIndex].getNumItem() + " " + slots[slotIndex].getItem().getName() + " in the slots.");

            do{
                System.out.println("Enter a value: ");
                quantity = sc.nextInt();
                if (slots[slotIndex].getNumItem() + quantity > this.slotItemLimit) {
                    System.out.println("Cannot add stocks since stocks are only limited to 10!");
                }
                else {
                    slots[slotIndex].setNumItem(quantity);
                }

            } while (slots[slotIndex].getNumItem() + quantity > this.slotItemLimit);
            this.justStocked = true; 
        }
        
    }

    /** Allows the user to set an item's new price
     * @param slotIndex index to determine a specific slot in the vending machine
     * @param sc scanner that asks input from the user
     */
    private void setNewPrice (int slotIndex, Scanner sc) {
        System.out.println("Old price of " + slots[slotIndex].getItem().getName() + " = " + slots[slotIndex].getItem().getPrice());
        System.out.println("Calories of " + slots[slotIndex].getItem().getName() + " = " + slots[slotIndex].getItem().getCalories());
        System.out.print("Input new price: ");
        int newPrice = sc.nextInt();
        slots[slotIndex].getItem().setPrice(newPrice); //Sets the price of the item/slots to its new price
        System.out.println("New price of " + slots[slotIndex].getItem().getName() + " = " + slots[slotIndex].getItem().getPrice()); //Prints the new price of the item/slots
        System.out.println("Calories of " + slots[slotIndex].getItem().getName() + " = " + slots[slotIndex].getItem().getCalories());
    }

    /** Empties the money box inside the vending machine
     * 
     */
    private void collectPayment() {
        System.out.println("Collected P" + moneyCompartment.getTotalMoney() + "!");
        moneyCompartment.setCoin1(-moneyCompartment.getCoin1());
        moneyCompartment.setCoin5(-moneyCompartment.getCoin5());
        moneyCompartment.setCoin10(-moneyCompartment.getCoin10());
        moneyCompartment.setCoin20(-moneyCompartment.getCoin20());
        moneyCompartment.setBill20(-moneyCompartment.getBill20());
        moneyCompartment.setBill50(-moneyCompartment.getBill50());
        moneyCompartment.setBill100(-moneyCompartment.getBill100());
        moneyCompartment.setBill500(-moneyCompartment.getBill500());

    }

    /** Adds denomination of changes inside the vending machine
     * @param sc scanner that asks input from the user
     */
    private void addChange (Scanner sc) { //Might change to input each added change one by one
        boolean isAdding = true; 
        int choice;
        int numDenomination; 
        while (isAdding){
            
            System.out.println("[1] 1-Peso Coin");
            System.out.println("[2] 5-Peso Coin");
            System.out.println("[3] 10-Peso Coin");
            System.out.println("[4] 20-Peso Coin");
            System.out.println("[5] 20-Bill Bill");
            System.out.println("[6] 50-Bill Coin");
            System.out.println("[7] 100-Bill Coin");
            System.out.println("[8] 500-Bill Coin");
            System.out.println("[0] Exit");
            System.out.print("Select denomination:");


            do{
                choice = sc.nextInt();
                if (choice < 0 || choice > 8)
                    System.out.println("Enter a valid input.");
            }while (choice < 0 || choice > 8);
            //validate choice

            if (choice != 0){
                do {
                    System.out.println("How many denominations? ");
                    numDenomination = sc.nextInt();
                    if (numDenomination <= 0)
                        System.out.println("Input a positive number.");
                } while (numDenomination <= 0);

                switch(choice){
                    case 1: 
                        moneyCompartment.setCoin1(numDenomination);
                        break;
                    case 2: 
                        moneyCompartment.setCoin5(numDenomination);
                        break;
                    case 3: 
                        moneyCompartment.setCoin10(numDenomination);
                        break;
                    case 4: 
                        moneyCompartment.setCoin20(numDenomination);
                        break;
                    case 5: 
                        moneyCompartment.setBill20(numDenomination);
                        break;
                    case 6: 
                        moneyCompartment.setBill50(numDenomination);
                        break;
                    case 7: 
                        moneyCompartment.setBill100(numDenomination);
                        break;
                    case 8: 
                        moneyCompartment.setBill500(numDenomination);
                        break;
                }
            }
            else{
                System.out.println("Exiting...");
                isAdding = false; 
            }
            System.out.println("Total change inside : " + moneyCompartment.getTotalMoney());
        }
    
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

    /** Sets the array list of transactions
     * @param transactions is the array list of transactions
     */
    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
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

}