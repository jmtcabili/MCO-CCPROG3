
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
                    if (driverModel.emptySlot() != -1 && 
                        (driverView.isRice())||driverView.isMeat()||
                         driverView.isExtra()||driverView.isVeggie()){
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
                                driverView.setInventoryTest(driverModel.getLatestMachine().returnInventory());
                            }

                        }
                    } else
                        driverView.setFeedbackItem("Unsuccessful add!");
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
                driverView.clearDisplay();
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

        //controls for test machine
        
        this.driverView.setBackbtn3Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                driverView.openOptionsFrame();
                driverView.closeRegularTestFrame();
            }
        });
        //coin buttons
        this.driverView.setClearBtn(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                driverView.clearDisplay();
                driverModel.getPayment().setCoin1(-driverModel.getPayment().getCoin1());
                driverModel.getPayment().setCoin5(-driverModel.getPayment().getCoin5());
                driverModel.getPayment().setCoin10(-driverModel.getPayment().getCoin10());
                driverModel.getPayment().setCoin20(-driverModel.getPayment().getCoin20());
                driverModel.getPayment().setBill20(-driverModel.getPayment().getBill20());
                driverModel.getPayment().setBill50(-driverModel.getPayment().getBill50());
                driverModel.getPayment().setBill100(-driverModel.getPayment().getBill100());
            }
        });

        this.driverView.setDenom1CBtn(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                driverModel.getPayment().setCoin1(1);
                driverView.setTextDisplay1(driverModel.getPayment().getTotalMoney());
            }
        });

        this.driverView.setDenom5CBtn(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                driverModel.getPayment().setCoin5(1);
                driverView.setTextDisplay1(driverModel.getPayment().getTotalMoney());
            }
        });

        this.driverView.setDenom10CBtn(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                driverModel.getPayment().setCoin10(1);
                driverView.setTextDisplay1(driverModel.getPayment().getTotalMoney());
            }
        });

        this.driverView.setDenom20CBtn(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                driverModel.getPayment().setCoin20(1);
                driverView.setTextDisplay1(driverModel.getPayment().getTotalMoney());
            }
        });

        this.driverView.setDenom20BBtn(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                driverModel.getPayment().setBill20(1);
                driverView.setTextDisplay1(driverModel.getPayment().getTotalMoney());
            }
        });

        this.driverView.setDenom50BBtn(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                driverModel.getPayment().setBill50(1);
                driverView.setTextDisplay1(driverModel.getPayment().getTotalMoney());
            }
        });

        this.driverView.setDenom100BBtn(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                driverModel.getPayment().setBill100(1);
                driverView.setTextDisplay1(driverModel.getPayment().getTotalMoney());
            }
        });

        this.driverView.setSlotNum(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                //TODO: ERROR HANDLING IF SLOT NUM INPUTTED IS OUT OF BOUNDS
                int slotInput = Integer.parseInt(driverView.getSlotNum1());
                driverView.addToTextDisplay3("Picked: " + driverModel.getLatestMachine().getSlots()[slotInput-1].getItem().getName());
                driverView.setTextDisplay2(driverModel.getLatestMachine().getSlots()[slotInput-1].getItem().getPrice());
            }
        });

        this.driverView.setBuyBtn(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                //TODO: ERROR HANDLING IF CHANGE < 0
                int slotInput = Integer.parseInt(driverView.getSlotNum1());
                Money tempPayment = driverModel.getPayment(); 
                
                if (slotInput-1 >= 0 && slotInput-1 < driverModel.getLatestMachine().getSlots().length){
                    int price = driverModel.getLatestMachine().getSlots()[slotInput-1].getItem().getPrice();
                    System.out.println(price);
                    System.out.println(driverModel.getPayment().getTotalMoney());
                    if (driverModel.getPayment().getTotalMoney() >= price){

                        driverModel.addToMoney(tempPayment);
                        int change = (driverModel.getPayment().getTotalMoney()) - (driverModel.getLatestMachine().getSlots()[slotInput-1].getItem().getPrice());
                        if (driverModel.getLatestMachine().produceChange(change, price)){
                            driverView.addToTextDisplay3("Change is: " + change);
                            driverModel.clearPayment();

                        }else
                            driverView.addToTextDisplay3("Not enough change");

                    } else
                        driverView.addToTextDisplay3("Insufficient payment");
                    
                }else

                //int change = (driverModel.getPayment().getTotalMoney()) - (driverModel.getLatestMachine().getSlots()[slotInput-1].getItem().getPrice());
                //driverView.setTextDisplayBuy3(change);
                driverView.setTextDisplay1(0);
            }
        });



        

    }
}

