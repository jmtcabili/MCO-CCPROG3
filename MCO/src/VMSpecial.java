
import java.util.*;

public class VMSpecial extends VMReg {

    private ArrayList<Item> orderBag = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    String buffer;
    public VMSpecial(String name, int slotCount, int slotItemLimit) {
        super(name, slotCount, slotItemLimit);
    }   
    
    private void orderDish () {
        /*
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

                }
                else {
                    Item items = new Item(super.slots[choice1-1].getItem().getName(),
                                          super.slots[choice1-1].getItem().getCalories(),
                                          super.slots[choice1-1].getItem().getPrice());

                    Slot cart = new Slot(items);
                    orderBag.add(cart);
                   // orderBag.get(orderBag.size()-1).setNumItem(amountAdded);
                   // slots[choice1-1].setNumItem(-amountAdded);
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

                        if (orderBag.get(k).getItem() instanceof Veggie) {
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
                               // slots[l].setNumItem(orderBag.get(m).getNumItem());
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
        */
        
    }
    public ArrayList<Item> getOrderBag(){
        return this.orderBag; 
    }
}