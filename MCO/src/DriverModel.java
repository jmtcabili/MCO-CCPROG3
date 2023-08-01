import java.util.*;

public class DriverModel {
    ArrayList<VMReg> machineList = new ArrayList<>();

    public DriverModel(){
        this.machineList = new ArrayList<VMReg>();
    }

    public void addMachine(String name, String slotcount, String itemCount, String VMtype){

        this.machineList.add(new VMReg(name, Integer.parseInt(slotcount), Integer.parseInt(itemCount)));
        //add a condition to check if vmtype is special or regular
    }

    public boolean isFound(String name){
        boolean isFound = false; 
        int i = 0; 

        while (i < machineList.size() && isFound == false){
            if (machineList.get(i).getName().equals(name))
                isFound = true; 
            i++;
        }
        return isFound; 
    }
    public int countEmptySlot(VMReg VM){
        int countEmpty = 0; 
        for (int i = 0; i < VM.getSlots().length; i++){
            if (VM.getSlots()[i] == null)
                countEmpty++;
        }
        return countEmpty; 
    }
    public int emptySlot(VMReg VM){
        boolean hasEmptySlot = false; 
        int emptySlot = -1;
        int i = 0; 
        while (i < VM.getSlots().length && hasEmptySlot == false){
            if (VM.getSlots()[i] == null){
                hasEmptySlot = true; 
                emptySlot = i; 
            }
            i+=1;
        }
        return emptySlot; 
    }

    public String printMachines(){
        String message = ""; 

        for (int i = 0; i < machineList.size(); i++){
            message+= ((i+1) + ".) " + machineList.get(i).getName()+"\n");
            System.out.println(message);
        }
        return message; 
    }
    
    public VMReg getLatestMachine(){
        return machineList.get(machineList.size()-1); 
    }
    

}
