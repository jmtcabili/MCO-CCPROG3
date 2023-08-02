
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
                    //numSlots should be at least 8, please change in future
                    (Integer.parseInt(numSlots) >= 2 && Integer.parseInt(numSlots) <= 12) &&
                    Integer.parseInt(itemCount) >= 10){
                    driverModel.addMachine(name, numSlots, itemCount, typeVM);
                    driverView.setMachineList(driverModel.printMachines());
                    driverView.setFeedbackText("Successful add");
                } else 
                    driverView.setFeedbackText("Unsuccessful add");
                //TO-DO: Add proper feedback text for conditions above if empty also - joe
                //ex. if num slots < 12, adjust setFeedbackText "not enough slots"
                driverView.clearTextFields();
            }
        });

        this.driverView.setTestVM_BtnListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (driverModel.getLatestMachine().getIsInitialized() == false){
                    driverView.setInventoryText("Inventory: \n");
                    driverView.openInitializeItems();
                    driverView.setSlotsLeft("Slots: " + driverModel.countEmptySlot());
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
                //different function signature for svm?
                
                if (!driverView.hasEmptyField()){
                    String itemName = driverView.getItemNameTf();
                    int price = Integer.parseInt(driverView.getPriceTf());
                    int calories = Integer.parseInt(driverView.getCaloriesTf());
                    int quantity = Integer.parseInt(driverView.getQuantity());
                    if (driverModel.emptySlot() != -1){
                        //TODO: consider duplicate item - Joe
                        //TODO: consider if quantity added is more than set quantity - Joe
                        if (driverModel.itemFound(itemName) != null){
                            Item item = new Item(itemName, calories, price); //creates item instance
                            Slot slot = new Slot(item); //creates slot instance, no item is store in itemList
                            slot.stockItem(item, quantity);
                            driverView.setFeedbackItem("Duplicate Found!");
                        } 
                        else{
                            if (driverView.isRice()){
                                Rice item = new Rice(itemName, calories, price);
                                Slot slot = new Slot(item); //creates slot instance, no item is store in itemList
                                slot.stockItem(item, quantity);
                                driverModel.getLatestMachine().setSlot(driverModel.emptySlot(), slot);
                            } 
                            else if (driverView.isMeat()){
                                Meat item = new Meat(itemName, calories, price);
                                Slot slot = new Slot(item); //creates slot instance, no item is store in itemList
                                slot.stockItem(item, quantity);
                                driverModel.getLatestMachine().setSlot(driverModel.emptySlot(), slot);
                            }
                            else if (driverView.isVeggie()){
                                Veggie item = new Veggie(itemName, calories, price);
                                Slot slot = new Slot(item); //creates slot instance, no item is store in itemList
                                slot.stockItem(item, quantity);
                                driverModel.getLatestMachine().setSlot(driverModel.emptySlot(), slot);
                            }
                            else if (driverView.isExtra()){
                                Extra item = new Extra (itemName, calories, price);
                                Slot slot = new Slot(item); //creates slot instance, no item is store in itemList
                                slot.stockItem(item, quantity);
                                driverModel.getLatestMachine().setSlot(driverModel.emptySlot(), slot);
                            }
                            driverView.setSlotsLeft("Slots: " + driverModel.countEmptySlot());
                            driverView.setInventoryText(driverModel.getLatestMachine().returnInventory());
                            driverModel.getLatestMachine().displayItems();
                            driverView.setFeedbackItem("Added");
                            if (driverModel.countEmptySlot() == 0){
                                driverModel.getLatestMachine().setInitialized(true);
                                driverView.openOptionsFrame();
                                driverView.closeInitializeItems();
                            }

                        }
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
        this.driverView.setTestFeaturesBtnListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                driverView.openRegularTestFrame();
                driverView.setMachineLabel(driverModel.getLatestMachine().getName());
                driverView.closeOptionsFrame();
            }
        });
        this.driverView.setMaintenanceBtnListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                driverView.openMaintenanceFrame();
                driverView.setInventoryM(driverModel.getLatestMachine().returnInventory());
                driverView.setTotalDenomination(driverModel.returnDenominations());
                driverView.closeOptionsFrame();
            }
        });

    //controls for maintenance
        //set restock     
        this.driverView.setAddStockBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                //TO-DO: Add feedback - joe
                //maybe itemNAme to slot number instead (modify some time when free, it working pa naman)
                String itemName = driverView.getItemName();
                int numRestock = Integer.parseInt(driverView.getNumRestock());
                if (driverModel.itemFound(itemName) != null){
                    Item temp = driverModel.itemFound(itemName);
                    if(driverModel.findSlotIdx(temp) != -1){
                        int slotIdx = driverModel.findSlotIdx(temp);
                        driverModel.getLatestMachine().getSlots()[slotIdx].stockItem(temp, numRestock);
                    }
                    driverView.setInventoryM(driverModel.getLatestMachine().returnInventory());
                }
                driverView.clearAddStockFields();
            }
        });
        //set newprice
        this.driverView.setPriceBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                int slotNum = Integer.parseInt(driverView.getSlotNumber());
                int newPrice = Integer.parseInt(driverView.getNewPrice());
                if ((slotNum >= 0 && slotNum <= driverModel.getLatestMachine().getSlots().length) &&
                    newPrice >= 0){
                    driverModel.getLatestMachine().getSlots()[slotNum-1].getItem().setPrice(newPrice);
                    driverView.setInventoryM(driverModel.getLatestMachine().returnInventory());
                    driverModel.getLatestMachine().displayItems();
                }
                driverView.clearNewPriceFields();
            }
        });
        //to transaction history
        this.driverView.setTransactionBtnListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                driverView.openTransactionFrame();
                driverView.closeMaintenanceFrame();
            }
        });
        this.driverView.setBackBtn2Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                driverView.openOptionsFrame();
                driverView.closeMaintenanceFrame();
            }
        });
        //add coin to moneh
        this.driverView.setCoin1Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){ 
                driverModel.getLatestMachine().getMoneyCompartment().setCoin1(1);
                driverView.setTotalDenomination(driverModel.returnDenominations());
            }
        });
        this.driverView.setCoin5Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){ 
                driverModel.getLatestMachine().getMoneyCompartment().setCoin5(1);
                driverView.setTotalDenomination(driverModel.returnDenominations());
            }
        });
        this.driverView.setCoin10Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){ 
                driverModel.getLatestMachine().getMoneyCompartment().setCoin10(1);
                driverView.setTotalDenomination(driverModel.returnDenominations());
            }
        });
        this.driverView.setCoin20Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){ 
                driverModel.getLatestMachine().getMoneyCompartment().setCoin20(1);
                driverView.setTotalDenomination(driverModel.returnDenominations());
            }
        });
        //add bills to moneh
        this.driverView.setBill20Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                driverModel.getLatestMachine().getMoneyCompartment().setBill20(1);
                driverView.setTotalDenomination(driverModel.returnDenominations());
            }
        });
        this.driverView.setBill50Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                driverModel.getLatestMachine().getMoneyCompartment().setBill50(1);
                driverView.setTotalDenomination(driverModel.returnDenominations());
            }
        });
        this.driverView.setBill100Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                driverModel.getLatestMachine().getMoneyCompartment().setBill100(1);
                driverView.setTotalDenomination(driverModel.returnDenominations());
            }
        });
        this.driverView.setCollectMoneyBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                int total = driverModel.getLatestMachine().getMoneyCompartment().getTotalMoney();
                driverModel.clearMoneyCompartment();
                driverView.setCollectedMoney("Collected Money : " + total);
                driverView.setTotalDenomination(driverModel.returnDenominations());

            }
        });
        this.driverView.setBackTransactionBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                driverView.openMaintenanceFrame();
                driverView.closeTransactionFrame();
            }
        });



        

    }
}

