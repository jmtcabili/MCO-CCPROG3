import java.util.*;
/**
 * This class is the main method of the machine project
 * @author Johan Marlo T. Cabili
 * @author Joemar T. Lapasaran
 * @version 1.0
 */

public class Driver{
    public static void main (String[] args) {
        ArrayList<VMReg> machineList = new ArrayList<>(); 
        boolean isRunning = true; 
        int choice; 

        String tempName = new String(); 
        String buffer; //to avoid noSuchElement
        int tempSlotLimit; 
        int tempSlotCount; 

        Scanner sc = new Scanner(System.in);
        while(isRunning){
            System.out.println("Welcome to the Vending Machine Factory!\n");
            do{
                System.out.print("\033[H\033[2J"); 
                System.out.println("Would you like to: (choose a number)");
                System.out.print("[1] Create a vending machine\n[2] Test a machine\n");
                System.out.println("[3] Exit");
                choice = sc.nextInt();
                buffer = sc.nextLine();
                if (choice < 1 || choice > 3)
                    System.out.println("Invalid input. Please try again.");
            }while (choice < 1 || choice > 3);
            
            
            switch (choice){
                case 1: 
                    System.out.print("Enter vending machine name: ");
                    tempName = sc.nextLine();
                    do{
                        System.out.print("Enter slot count (at least 8): ");
                        tempSlotCount = sc.nextInt();
                        buffer = sc.nextLine();
                        if (tempSlotCount <= 7){
                            System.out.println("Enter a valid slot count");
                        }
                    } while (tempSlotCount <= 7);

                    do{
                        System.out.print("Enter item capacity per slot (at least 10): ");
                        tempSlotLimit = sc.nextInt();
                        buffer = sc.nextLine();
                        if (tempSlotLimit < 10){
                            System.out.println("Enter a valid capacity");
                        }
                    } while (tempSlotLimit < 10);
                    
                    VMReg machine = new VMReg(tempName, tempSlotCount, tempSlotLimit);
                    machineList.add(machine);
                    System.out.println("\nVending machine created!");
                    machine.getName();
                    break;
                case 2: 
                    int mode = 0;
                    if (machineList.size() != 0){
                        while(mode != 3){
                            System.out.println("Testing " + machineList.get(machineList.size()-1).getName());
                            do {
                                System.out.println("[1] Test vending machine");
                                System.out.println("[2] Perform maintenance on vending machine");
                                System.out.println("[3] Exit");
                                mode = sc.nextInt();
                            } while (mode < 1 || mode > 3);
                            switch (mode){
                                case 1: 
                                    if (machineList.get(machineList.size()-1).getSlots() == null)
                                        System.out.println("No items in vending machine!");
                                    else{
                                        machineList.get(machineList.size()-1).Test(sc);
                                    }
                                    break;
                                case 2: 
                                    machineList.get(machineList.size()-1).maintenance(sc);
                                    break;
                            }
                        }
                    } else
                        System.out.println("No machines available");
                    break;
                case 3: 
                    isRunning = false; 
                    break;
            }


        }
        
        sc.close();
    }
    
}
