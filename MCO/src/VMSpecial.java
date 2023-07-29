import java.util.*;

public class VMSpecial extends VMReg {

    private ArrayList<Item> items = new ArrayList();
    Scanner sc = new Scanner(System.in);
    String buffer;
    int choice, choice1;
    public VMSpecial(String name, int slotCount, int slotItemLimit) {
        super(name, slotCount, slotItemLimit);
    }

    public void orderDish () {
        int num = 0;
        while (num == 0) {
            System.out.println("Inventory:");
            for (int i = 0; i < slots.length; i++){
                System.out.print("[" + i+1 +"]"+slots[i].getItem().getName());
                System.out.print(" (" + slots[i].getItem().getName() + ") - "); //TODO: CALL DISPLAY ITEMS INSTEAD
                System.out.println(slots[i].getItem().getPrice() + " pesos");
            }

            System.out.println("-------------------------------");

            System.out.println("Order Bag:");
            for (int j = 0; j<items.size(); j++) {
                System.out.print("[" + j+1 +"]"+items.get(j).getName());
                System.out.print(" (" + items.get(j).getName() + ") - ");
                System.out.println(items.get(j).getPrice() + " pesos");
            }

            System.out.println("-------------------------------");

            do{
                System.out.println("[1] Add ingredients to the bag");
                System.out.println("[2] Order a Dish");
                System.out.print("Enter choice: ");
                choice = sc.nextInt();
                buffer = sc.nextLine();

                if (choice < 1 || choice > 3) {
                    System.out.println("Please enter a valid input.");
                }
            }while (choice < 1 || choice > 3);
            
            if (choice == 1) {
                do{
                    System.out.println("Choose an ingredient:");
                    for (int k = 0; k<super.slots.length; k++) {
                        System.out.print("[" + k+1 +"]"+super.slots[k].getItem().getName());
                        System.out.print(" (" + super.slots[k].getItem().getName() + ") - ");
                        System.out.println(super.slots[k].getItem().getPrice() + " pesos");
                }
                choice1 = sc.nextInt();
                buffer = sc.nextLine();
                Item cart = new Item(super.slots[choice1-1].getItem().getName(), 
                                        super.slots[choice1-1].getItem().getCalories(),
                                        super.slots[choice1-1].getItem().getPrice());
                items.add(cart);
                }while(choice1 < 0 || choice1 > super.slots.length);
            }
            else if (choice == 2) {

            }
            }
        }
    }
    

