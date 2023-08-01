
import java.util.*;

public class VMSpecial extends VMReg {

    private ArrayList<Slot> orderBag = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    String buffer;
    public VMSpecial(String name, int slotCount, int slotItemLimit) {
        super(name, slotCount, slotItemLimit);
    }

    @Override
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
                System.out.println("[" + slots.length + "] Order Dish"); //TODO: CHANGE TO A VALID INPUT
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
                    if (slotChosen == slots.length){
                        orderDish();
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
    public void displayItems(){
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
    
    
    private void orderDish () {
        int i, j, k;
        int found = 0;
        int num = 0;
        int choice, choice1, choice2;
        int amountAdded;
        boolean isFound, foundMeat, foundRice;
        while (num == 0) {
            isFound = false;
            i = j = k = 0;
            foundMeat = foundRice =  false;
            System.out.println("-------------------------------");
            System.out.println("Inventory:");
            while (i < slots.length && slots[i] != null){
                System.out.print("[" + (i+1) +"]"+slots[i].getItem().getName());
                System.out.print(" (" + slots[i].getItem().getCalories() + " cal) - ");
                System.out.print(slots[i].getItem().getPrice() + " pesos ");
                System.out.println("- " + slots[i].getNumItem() + "pc");
                i++;
        }
            System.out.println("-------------------------------");
            System.out.println("Order Bag:");
            displayOrderBag();

            System.out.println("\n-------------------------------");

            do{
                System.out.println("[1] Add ingredients to the bag");
                System.out.println("[2] Order a Dish");
                System.out.println("[3] Clear Order Bag");
                System.out.println("[4] Exit");
                System.out.print("Enter choice: ");
                choice = sc.nextInt();
                buffer = sc.nextLine();

                if (choice < 1 || choice > 4) {
                    System.out.println("Please enter a valid input.");
                }
            }while (choice < 1 || choice > 4);
            
            if (choice == 1) { //ADD INGREDIENTS TO THE BAG
                do{
                    System.out.println("Choose an ingredient:");
                    displayItems();
                    choice1 = sc.nextInt();
                    buffer = sc.nextLine();
                }while(choice1 < 0 || choice1 > super.slots.length);
                do{
                    System.out.println("Enter amount to be added:");
                    amountAdded = sc.nextInt();
                    buffer = sc.nextLine();
                    if (amountAdded <= 0 || amountAdded > super.slots[choice1-1].getNumItem()) {
                        System.out.println("Please enter a valid input.");
                    }
                } while(amountAdded <= 0 || amountAdded > super.slots[choice1-1].getNumItem());

                for (j = 0; j<orderBag.size(); j++) {
                    if (super.slots[choice1-1].getItem().getName() == orderBag.get(j).getItem().getName()) {
                        found = j;
                        isFound = true;
                    }
                }

                if (isFound == true) {
                    orderBag.get(found).setNumItem(amountAdded);
                    slots[choice1-1].setNumItem(-amountAdded);
                }
                else {
                    Item items = new Item(super.slots[choice1-1].getItem().getName(),
                                          super.slots[choice1-1].getItem().getCalories(),
                                          super.slots[choice1-1].getItem().getPrice());

                    Slot cart = new Slot(items);
                    orderBag.add(cart);
                    orderBag.get(orderBag.size()-1).setNumItem(amountAdded);
                    slots[choice1-1].setNumItem(-amountAdded);
                }

            }
            else if (choice == 2) { // ORDERS THE DISH
                System.out.println("Order Bag:");
                displayOrderBag();
                do{
                    System.out.println("Would you like to check out?");
                    System.out.print("[1] Yes\n [2] No\n");
                    choice2 = sc.nextInt();
                } while(choice2 < 0 || choice2 > 2);

                if (choice2 == 1) {
                    for (k = 0; k<orderBag.size(); k++) {
                        if (orderBag.get(k).getItem() instanceof Meat) {
                            foundMeat = true;
                            System.out.println("Seering " +orderBag.get(k).getItem().getName() + "...");
                            try{
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }

                        if (orderBag.get(k).getItem() instanceof Rice) {
                            foundRice = true;
                            System.out.println("Boiling " +orderBag.get(k).getItem().getName() + "...");
                            try{
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }

                        if (orderBag.get(k).getItem() instanceof Addon) {
                            System.out.println("Topping " +orderBag.get(k).getItem().getName() + "...");
                            try{
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }

                        if (orderBag.get(k).getItem() instanceof Sauce) {
                            System.out.println("Marinating with " +orderBag.get(k).getItem().getName() + "...");
                            try{
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    if (foundMeat == true && 
                        foundRice == true) {
                        System.out.println("Mongolian Fried Rice done!");
                        try{
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                    }
                }
            
            }

            else if (choice == 3) { // CLEARS ORDER BAG
                for (int l = 0; l<slots.length; l++) {
                    for (int m = 0; m<orderBag.size(); m++) {
                        if (slots[l].getItem().getName() ==
                            orderBag.get(m).getItem().getName()) {
                                slots[l].setNumItem(orderBag.get(m).getNumItem());
                                orderBag.remove(m);
                            }
                    }
                }
            }
        }
        }
        
        public void displayOrderBag() {
            int i;
            for (i = 0; i<orderBag.size(); i++) {
                System.out.print("[" + (i+1) +"]"+orderBag.get(i).getItem().getName());
                System.out.print(" (" + orderBag.get(i).getItem().getCalories() + " cal) - ");
                System.out.print(orderBag.get(i).getItem().getPrice() + " pesos ");
                System.out.println("- " + orderBag.get(i).getNumItem() + "pc");
            }
        }
    }
    