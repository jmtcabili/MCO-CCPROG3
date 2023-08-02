import java.util.*;

public class DriverModel {
    ArrayList<VMReg> machineList = new ArrayList<>();
    private Money payment = new Money();

    public DriverModel(){
        this.machineList = new ArrayList<VMReg>();
    }

    public void addMachine(String name, String slotcount, String itemCount, String VMtype){

        this.machineList.add(new VMReg(name, Integer.parseInt(slotcount), Integer.parseInt(itemCount)));
        //add a condition to check if vmtype is special or regular
    }

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
   

    public int countEmptySlot(){
        int countEmpty = 0; 
        for (int i = 0; i < getLatestMachine().getSlots().length; i++){
            if (getLatestMachine().getSlots()[i] == null)
                countEmpty++;
        }
        return countEmpty; 
    }
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
    public void clearMoneyCompartment(){
        getLatestMachine().getMoneyCompartment().setCoin1(-getLatestMachine().getMoneyCompartment().getCoin1());
        getLatestMachine().getMoneyCompartment().setCoin5(-getLatestMachine().getMoneyCompartment().getCoin5());
        getLatestMachine().getMoneyCompartment().setCoin10(-getLatestMachine().getMoneyCompartment().getCoin10());
        getLatestMachine().getMoneyCompartment().setCoin20(-getLatestMachine().getMoneyCompartment().getCoin20());
        getLatestMachine().getMoneyCompartment().setBill20(-getLatestMachine().getMoneyCompartment().getBill20());
        getLatestMachine().getMoneyCompartment().setBill50(-getLatestMachine().getMoneyCompartment().getBill50());
        getLatestMachine().getMoneyCompartment().setBill100(-getLatestMachine().getMoneyCompartment().getBill100());
    }

    public void addToMoney(Money payment){
        getLatestMachine().getMoneyCompartment().setCoin1(payment.getCoin1());
        getLatestMachine().getMoneyCompartment().setCoin5(payment.getCoin5());
        getLatestMachine().getMoneyCompartment().setCoin10(payment.getCoin10());
        getLatestMachine().getMoneyCompartment().setCoin20(payment.getCoin20());
        getLatestMachine().getMoneyCompartment().setBill20(payment.getBill20());
        getLatestMachine().getMoneyCompartment().setBill50(payment.getBill20());
        getLatestMachine().getMoneyCompartment().setBill100(payment.getBill100());
    }

    public Money getPayment () {
        return this.payment;
    }
    public void clearPayment(){
        this.payment.setCoin1(-payment.getCoin1());
        this.payment.setCoin5(-payment.getCoin5());
        this.payment.setCoin10(-payment.getCoin10());
        this.payment.setCoin20(-payment.getCoin20());
        this.payment.setBill20(-payment.getBill20());
        this.payment.setBill50(-payment.getBill50());
        this.payment.setBill100(-payment.getBill100());
    }
}
