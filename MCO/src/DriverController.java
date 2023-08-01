
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DriverController {
    private DriverView driverView; 
    private DriverModel driverModel;  



    public DriverController(DriverView driverView, DriverModel driverModel){
        this.driverView = driverView; 
        this.driverModel = driverModel; 

        //controls for main
        this.driverView.setTypeVM_BtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                JButton btn = (JButton) e.getSource();
                if (btn.getText().equals("Regular"))
                    btn.setText("Special");
                else if (btn.getText().equals("Special"))
                    btn.setText("Regular");
            }
        });

        this.driverView.setCreateVM_BtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = driverView.getName();
                String numSlots = driverView.getNumSlot();
                String itemCount = driverView.getItemCount();
                String typeVM = driverView.getTypeVM();
                
                if(!driverModel.isFound(name)&&
                    (Integer.parseInt(numSlots) >= 8 && Integer.parseInt(numSlots) <= 12) &&
                    Integer.parseInt(itemCount) >= 10){
                    driverModel.addMachine(name, numSlots, itemCount, typeVM);
                    driverView.setMachineList(driverModel.printMachines());
                    driverView.setFeedbackText("Successful add");
                } else 
                    driverView.setFeedbackText("Unsuccessful add");
                //TO-DO: Add proper feedback text for conditions above if empty also
                driverView.clearTextFields();
            }
        });

        this.driverView.setTestVM_BtnListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (driverModel.getLatestMachine().getIsInitialized() == false){
                    driverView.openInitializeItems();
                    int empty = driverModel.countEmptySlot(driverModel.getLatestMachine());
                    driverView.setSlotsLeft("Slots: " + empty);
                }else{
                    driverView.openOptionsFrame();
                }
                driverView.setVMLblText(driverModel.getLatestMachine().getName() + "'s Machine");
                driverView.closeMainFrame();
            }
        });
        this.driverView.setExit_BtnListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                driverView.closeMainFrame(); 
            }
        });
        //controls for initializeItem
        this.driverView.setAddItmBtlnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                //don't forget to clear text field
                //get latest machine
                //count empty slots
                //create slot instance and item instance, add to machine
                
                if (!driverView.hasEmptyField()){
                    String itemName = driverView.getItemNameTf();
                    int price = Integer.parseInt(driverView.getPriceTf());
                    int calories = Integer.parseInt(driverView.getCaloriesTf());
                    int quantity = Integer.parseInt(driverView.getQuantity());
                    if (driverModel.emptySlot(driverModel.getLatestMachine()) != -1){
                        int emptySlot = driverModel.emptySlot(driverModel.getLatestMachine());
                        Item item = new Item(itemName, calories, price); //creates item instance
                        Slot slot = new Slot(item); //creates slot instance, no item is store in itemList
                        slot.stockItem(item, quantity);
                        driverModel.getLatestMachine().setSlot(emptySlot, slot);
                        int empty = driverModel.countEmptySlot(driverModel.getLatestMachine());
                        driverView.setSlotsLeft("Slots: " + empty);
                        driverView.setInventoryText(driverModel.getLatestMachine().returnInventory());
                        driverModel.getLatestMachine().displayItems();

                    }
                }
                driverView.clearItemInitializeFields();
            
            }
        });



        //controls for optinons
        this.driverView.setBackBtnListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                driverView.openMainFrame();
                driverView.closeOptionsFrame();    
            }
        });

        this.driverView.setMaintenanceBtnListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                driverView.openMaintenanceFrame();
                driverView.closeOptionsFrame();
            }
        });

        //controls for maintenance
        this.driverView.setBackBtn2Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                driverView.openOptionsFrame();
                driverView.closeMaintenanceFrame();
            }
        });


        

    }
}

