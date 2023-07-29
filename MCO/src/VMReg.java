package MCO1;
import java.util.*;

public class VMReg {
    private String name; 
    private Slot[] slots;
    private int slotItemLimit; 
    private Money moneyCompartment;
    private int numTransactions = 0;
    private ArrayList<Transaction> transactions = new ArrayList<Transaction>();
    private boolean justStocked; 

    public VMReg(String name, int slotCount, int slotItemLimit){
        this.name = name; 
        this.slots = new Slot[slotCount];
        this.slotItemLimit = slotItemLimit;
    }

    public void Test(){
        boolean isTesting = true; 
        int slotChosen; 
        Scanner sc = new Scanner(System.in);
        Money payment; 

        while(isTesting){
            displayItems();
            if (justStocked){
                Transaction startTransaction = new Transaction(slots);
                //will be stored in transaction array list once all details are given
                transactions.add(startTransaction);
                justStocked = false; 
                //should not open another transaction if you exit test then just go back
                //justStocked should only be made true by restock/stocked methods
                //transaction details should end right before stocking again
                //restock should access transactions.get(numtransac) and set
                //    the ending inventory to current stock
            }
            System.out.println("Insert payment : ");
            payment = receivePayment();
            displayItems();
            do{
                System.out.print("Enter slot number of item to buy : ");
                slotChosen = sc.nextInt(); 
                if (slotChosen < 0 || slotChosen > slots.length)
                    System.out.println("Please enter a valid option");
            } while (slotChosen < 0 || slotChosen > slots.length);

            if (slotChosen == 0){
                isTesting = false;
            }
            else{
                if (checkChange(payment, slotChosen) == false)
                    System.out.println("There is not enough change in the machine.");
                else if (slots[slotChosen-1].getNumItem() != 0)
                    System.out.println("The item you picked is out of stock");
                else{
                    //adding to moneybox
                    produceChange(payment.getTotalMoney(), slots[slotChosen].getItem());
                    moneyCompartment.setCoin1(payment.getCoin1());
                    moneyCompartment.setCoin5(payment.getCoin5());
                    moneyCompartment.setCoin10(payment.getCoin10());
                    moneyCompartment.setCoin20(payment.getCoin20());
                    moneyCompartment.setBill20(payment.getBill20());
                    moneyCompartment.setBill20(payment.getBill50());
                    moneyCompartment.setBill20(payment.getBill100());
                    moneyCompartment.setBill20(payment.getBill500());
                    dispenseItem(slotChosen-1);
                }
                    
            }

            

            /*
                1. displayItems (done)
                2. store current inventory (check if kaka restock/stock)
                    if true access an index in transaction history (done)
                3. receive payment (done)
                4. ask if they wanna buy anything (change isTesting if exit)
                5. ask which item (ask for item slot)
                6. checkChange return a boolean (done)
                if checkChange passes through, dispense item, else give back money (done)
                7. produce change and ta da you're fucking done
            */


        }
        sc.close();
    }

    private Money receivePayment(){
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

            Scanner sc = new Scanner(System.in);
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
            sc.close();
        }
        
        return payment; 
    }  


    private void dispenseItem(int slotIndex){
        this.slots[slotIndex].setNumItem(-1);
    }

    private boolean checkChange(Money payment, int slotIndex){
        int tempChange; 
        tempChange = payment.getTotalMoney() - slots[slotIndex].getItem().getPrice();
        return (this.moneyCompartment.getTotalMoney() - tempChange > 0);
    }
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
    
    
    private void displayItems(){
        
        for (int i = 0; i < slots.length; i++){
            System.out.print("[" + i+1 +"]"+slots[i].getItem().getName());
            System.out.print(" (" + slots[i].getItem().getName() + ") - ");
            System.out.println(slots[i].getItem().getPrice() + " pesos");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Slot[] getSlots() {
        return slots;
    }

    public void setSlots(Slot[] slots) {
        this.slots = slots;
    }

    public int getSlotItemLimit() {
        return slotItemLimit;
    }

    public void setSlotItemLimit(int slotItemLimit) {
        this.slotItemLimit = slotItemLimit;
    }

    public Money getMoneyCompartment() {
        return moneyCompartment;
    }

    public void setMoneyCompartment(Money moneyCompartment) {
        this.moneyCompartment = moneyCompartment;
    }

    public int getNumTransactions() {
        return numTransactions;
    }

    public void setNumTransactions(int numTransactions) {
        this.numTransactions = numTransactions;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    public boolean isJustStocked() {
        return justStocked;
    }

    public void setJustStocked(boolean justStocked) {
        this.justStocked = justStocked;
    }
}




















 