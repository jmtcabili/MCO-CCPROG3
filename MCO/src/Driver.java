package MCO1;
import java.util.*;


public class Driver{
    public static void main (String[] args) {
        ArrayList<VMReg> machineList = new ArrayList<>(); 
        boolean isRunning = true; 
        int choice; 
        Scanner sc = new Scanner(System.in);

        String tempName = new String(); 
        int tempSlotLimit; 
        int tempSlotCount; 


        
        while(isRunning){
            System.out.println("Welcome to the Vending Machine Factory!\n");
            do{
                System.out.println("Would you like to: (choose a number)");
                System.out.print("[1] Create a vending machine\n[2] Test a machine\n");
                System.out.println("[3]. Exit");
                choice = sc.nextInt();
                if (choice < 1 || choice > 3)
                    System.out.println("Invalid input. Please try again.");
            }while (choice < 1 || choice > 3);

            switch (choice){
                case 1: 
                    System.out.println("Enter vending machine name:");
                    tempName = sc.nextLine(); 
                    do{
                        System.out.println("Enter slot count (at least 1)");
                        tempSlotCount = sc.nextInt();
                        if (tempSlotCount <= 0){
                            System.out.println("Enter a valid slot count");
                        }
                    } while (tempSlotCount <= 0);

                    do{
                        System.out.println("Enter item capacity per slot (at least 10): ");
                        tempSlotLimit = sc.nextInt();
                        if (tempSlotLimit < 10){
                            System.out.println("Enter a valid capacity");
                        }
                    } while (tempSlotLimit < 10);
                    
                    VMReg machine = new VMReg(tempName, tempSlotCount, tempSlotLimit);
                    machineList.add(machine);
                    System.out.println("Vending machine created!");
                    machine.getName();

                case 2: 
                case 3: 
                    isRunning = false; 
            }


        }
        sc.close();
        
    }
}
