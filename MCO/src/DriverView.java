
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JTextArea;




import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Panel;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Flow;

public class DriverView {

    //Main frame components
    private JFrame mainFrame; 

    private JLabel nameLbl, slotCountLbl, itemCountLbl, factoryLabel, feedbackLbl; 

    private JTextField nameTf, slotCountTf, itemCountTf; 

    private JButton createVM_Btn, VMType_Btn;  
    private JButton testVM_Btn; 
    private JButton exit_Btn1; 

    private JTextArea vendingMachineList; 

    //Test VM Menu Components
    private JFrame optionsFrame; 

    private JLabel vmLbl; 
    private JButton testFeaturesBtn, maintenanceBtn, backBtn; 
    
    //Item initialization components
    private JFrame itemInitializationFrame; 
    private JLabel initializeItems, item, price, calories, quantity,
                   slotsLeft, feedback; 
    private JButton addItemBtn;
    private JTextField itemTf, priceTf, caloriesTf, quantityTf; 
    private JTextArea inventoryI; 

    //Maintencen Frame components
    private JFrame regularMaintenanceFrame; 
    private JLabel machineName;
    private JButton addStockBtn, setPriceBtn, collectMoney, 
                    transactionBtn, backBtn2,
                    coin1, coin5, coin10, coin20,
                    bill20, bill50, bill100;
    private JTextField itemNameTf, numItemTf, stockPriceTf, 
                       slotNumberTf, newPriceTf; 
    private JTextArea totalDenomination, collectedMoney, inventoryM;
    public Object setTestFeaturesBtnListener; 

    //Transaction Frame components
    private JFrame transactionFrame; 
    private JLabel transactionhistory; 
    private JButton backTransactionBtn; 
    private JTextArea history; 
    
    //Test Vending Feature Components
    private JFrame regularTestFrame; 

    private JLabel machineNameT;

    private JButton item_Btn, item1_Btn, item2_Btn, item3_Btn, item4_Btn, 
                    item5_Btn, item6_Btn, item7_Btn, item8_Btn, item9_Btn,
                    item10_Btn, item11_Btn, denom20B_Btn, denom50B_Btn,
                    denom100B_Btn, denom1C_Btn, denom5C_Btn, denom10C_Btn,
                    denom20C_Btn;
    private JTextArea display1, display2, display3; 

    public DriverView(){
        MainView(); 
        OptionsVMView();
        regularMaintenceFrame();
        itemsInitializationView();
        transactionFrame();
    }

    //Main View
    public void MainView(){
        this.mainFrame = new JFrame("Vending Machine Factory");

        this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.mainFrame.setSize(600, 800);
        this.mainFrame.setLocationRelativeTo(null);
        
        this.factoryLabel = new JLabel("Venching Machine Factory");
        this.factoryLabel.setFont(new Font("Calibri", Font.PLAIN, 30));
        this.nameLbl = new JLabel("Enter vending machine name: ");
        this.slotCountLbl = new JLabel("Enter number of slots (8-12): ");
        this.itemCountLbl = new JLabel("Enter max item count per slot: ");
        this.feedbackLbl = new JLabel("");

        this.vendingMachineList = new JTextArea(" ");
        this.vendingMachineList.setPreferredSize(new Dimension(429, 102));
        this.vendingMachineList.setEditable(false);
        
        this.nameTf = new JTextField();
        this.nameTf.setColumns(15);
        this.slotCountTf = new JTextField();
        this.slotCountTf.setColumns(15);
        this.itemCountTf = new JTextField();
        this.itemCountTf.setColumns(15);


        this.nameTf = new JTextField();
        this.slotCountTf = new JTextField();
        this.itemCountTf = new JTextField(); 


        this.createVM_Btn = new JButton("Create Vending Machine");
        this.testVM_Btn = new JButton("Test a vending machine");
        this.exit_Btn1 = new JButton("Exit");
        this.VMType_Btn = new JButton("Regular");


        this.factoryLabel.setBounds(125, 125, 500, 50);
        this.createVM_Btn.setBounds(100, 211, 200, 54);
        this.nameLbl.setBounds(100, 286, 300, 30);
        this.nameTf.setBounds(321, 286, 145, 30);
        this.slotCountLbl.setBounds(100, 316, 300, 30);
        this.slotCountTf.setBounds(321, 316, 145, 30);
        this.itemCountLbl.setBounds(100, 346, 300, 30);
        this.itemCountTf.setBounds(321, 346, 145, 30);
        this.feedbackLbl.setBounds(232, 370, 145, 30);
        this.testVM_Btn.setBounds(62,406,223,54);
        this.exit_Btn1.setBounds(312, 406, 223, 54);
        this.VMType_Btn.setBounds(350, 226, 101, 24);
        this.vendingMachineList.setBounds(50, 507, 485, 198);


        mainFrame.add(factoryLabel);
        mainFrame.add(createVM_Btn);
        mainFrame.add(nameLbl);
        mainFrame.add(nameTf);
        mainFrame.add(slotCountLbl);
        mainFrame.add(slotCountTf);
        mainFrame.add(itemCountLbl);
        mainFrame.add(itemCountTf);
        mainFrame.add(feedbackLbl);
        mainFrame.add(testVM_Btn);
        mainFrame.add(exit_Btn1);
        mainFrame.add(VMType_Btn);
        mainFrame.add(vendingMachineList);

        mainFrame.setResizable(false);
        mainFrame.setLayout(null);

        /*JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel.add(this.factoryLabel);
       
        panel.setPreferredSize(new Dimension(501, 121));
        this.mainFrame.add(panel);

        panel = new JPanel(new FlowLayout(FlowLayout.CENTER)); 
        panel.add(this.createVM_Btn);
        panel.add(this.nameLbl);
        panel.add(this.nameTf);
        this.mainFrame.add(panel);

        this.mainFrame.add(createVM_Btn);
        this.mainFrame.add(testVM_Btn);
        this.mainFrame.add(exit_Btn);
        */
        this.mainFrame.setVisible(true);
    }

    public void setCreateVM_BtnListener(ActionListener actionListener){
        this.createVM_Btn.addActionListener(actionListener);
    }
    public void setTypeVM_BtnListener(ActionListener actionListener){
        this.VMType_Btn.addActionListener(actionListener);
    }
    public void setTestVM_BtnListener(ActionListener actionListener){
        this.testVM_Btn.addActionListener(actionListener);
    }
    public void setExit_BtnListener(ActionListener actionListener){
        this.exit_Btn1.addActionListener(actionListener);
    }
    public void setVendingMachineList (String text){ //maybe accept the list then append machines to string
        this.vendingMachineList.setText(text);
    }
    public String getName(){
        return this.nameTf.getText();
    }
    public String getNumSlot(){
        return this.slotCountTf.getText();
    }
    public String getItemCount(){
        return this.itemCountTf.getText();
    }
    public String getTypeVM(){
        return this.VMType_Btn.getText();
    }
    public void setMachineList(String text){
        this.vendingMachineList.setText(text); 
    }
    public void setFeedbackText(String text){
        this.feedbackLbl.setText(text);
    }
    public void clearTextFields(){
        this.nameTf.setText("");
        this.slotCountTf.setText("");
        this.itemCountTf.setText("");
    }
    public void closeMainFrame(){
        mainFrame.dispose();
    }
    public void openMainFrame(){
        this.mainFrame.setVisible(true); 
    }

    //options view
    public void OptionsVMView(){
        this.optionsFrame = new JFrame("Vending Machine Factory");

        this.optionsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.optionsFrame.setSize(600, 800); 
        this.optionsFrame.setLocationRelativeTo(null);

        JPanel opanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); 
        this.vmLbl = new JLabel("");
        this.vmLbl.setFont(new Font("Calibri", Font.PLAIN, 30));
        opanel.add(vmLbl); 
        opanel.setBounds(184, 180, 223, 54);

        this.testFeaturesBtn = new JButton("Test Vending Features");
        this.maintenanceBtn = new JButton("Perform Maintenance");
        this.backBtn = new JButton("Back");
        
        this.testFeaturesBtn.setBounds(184, 251, 223, 54);
        this.maintenanceBtn.setBounds(184, 338, 223, 54);
        this.backBtn.setBounds(184, 426, 223, 54);

        this.optionsFrame.add(opanel);
        this.optionsFrame.add(testFeaturesBtn);
        this.optionsFrame.add(maintenanceBtn);
        this.optionsFrame.add(backBtn); 

        this.optionsFrame.setResizable(false);
        this.optionsFrame.setLayout(null);
        this.optionsFrame.setVisible(false);
    }

    public void setVMLblText(String text){
        this.vmLbl.setText(text); 
    }
    public void openOptionsFrame(){
        this.optionsFrame.setVisible(true); 
    }
    public void setBackBtnListener(ActionListener actionListener){
        this.backBtn.addActionListener(actionListener);
    }
    public void setTestFeaturesBtnListener (ActionListener actionListener){
        this.testFeaturesBtn.addActionListener(actionListener);
    }
    public void setMaintenanceBtnListener(ActionListener actionListener){
        this.maintenanceBtn.addActionListener(actionListener);
    }
    public void closeOptionsFrame(){
        optionsFrame.dispose();
    }

    //Items Initialiation view
    public void itemsInitializationView(){
        this.itemInitializationFrame = new JFrame("Vending Machine Factory - Item Initialization");
        this.itemInitializationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.itemInitializationFrame.setSize(600, 800);
        this.itemInitializationFrame.setLocationRelativeTo(null);

        this.initializeItems = new JLabel("Initialize Items: ");
        this.slotsLeft = new JLabel("Slots Left: ");
        this.item = new JLabel("Item name: ");
        this.price = new JLabel("Price: ");
        this.calories = new JLabel("Calories: ");
        this.quantity = new JLabel("Quantity: ");

        this.itemTf = new JTextField();
        this.priceTf = new JTextField();
        this.caloriesTf = new JTextField();
        this.quantityTf = new JTextField();

        this.addItemBtn = new JButton("Add Item");
        this.feedback = new JLabel("");

        this.inventoryI = new JTextArea("Inventory: "); 
        this.inventoryI.setEditable(false);
        inventoryI.setBounds(75, 400, 449, 310);
        JPanel inventoryPanel = new JPanel(); 
        inventoryPanel.setLayout(null);
        inventoryPanel.add(inventoryI);

        initializeItems.setBounds(246, 41, 108, 19);
        slotsLeft.setBounds(199, 97, 101, 11);
        item.setBounds(199, 145, 87, 19);
        itemTf.setBounds(308, 141, 160, 27);
        price.setBounds(199, 189, 87, 19);
        priceTf.setBounds(308, 189, 160, 27);
        calories.setBounds(199, 233, 87, 19);
        caloriesTf.setBounds(308, 233, 160, 27);
        quantity.setBounds(199, 277, 87, 19);
        quantityTf.setBounds(308, 277, 160, 27);
        
        addItemBtn.setBounds(97, 349, 189, 48);
        feedback.setBounds(308, 357, 160, 33);
        

        inventoryPanel.setBounds(75, 400, 449, 310);
        
        itemInitializationFrame.add(initializeItems);
        itemInitializationFrame.add(slotsLeft);
        itemInitializationFrame.add(item);
        itemInitializationFrame.add(itemTf);
        itemInitializationFrame.add(price);
        itemInitializationFrame.add(priceTf);
        itemInitializationFrame.add(calories);
        itemInitializationFrame.add(caloriesTf);
        itemInitializationFrame.add(quantity);
        itemInitializationFrame.add(quantityTf);
        itemInitializationFrame.add(addItemBtn);
        itemInitializationFrame.add(feedback);
        itemInitializationFrame.add(inventoryPanel);

        itemInitializationFrame.setVisible(false);  
    }

    public void openInitializeItems(){
        this.itemInitializationFrame.setVisible(true);
    }
    public void closeInitializeItems(){
        this.itemInitializationFrame.dispose();
    }
    public void setAddItmBtlnListener(ActionListener actionListener){
        this.addItemBtn.addActionListener(actionListener);
    }
    public boolean hasEmptyField(){
        boolean isEmpty = true; 
        if (!(itemTf.getText().equals("")|| priceTf.getText().equals("")||
            quantityTf.getText().equals("")|| quantityTf.getText().equals("")))
            isEmpty = false; 
        return isEmpty; 
    }
    public String getItemNameTf(){
        return this.itemTf.getText();
    }
    public String getPriceTf(){
        return this.priceTf.getText();
    }
    public String getCaloriesTf(){
        return this.caloriesTf.getText();
    }
    public String getQuantity(){
        return this.quantityTf.getText();
    }
    public void setInventoryText(String text){
        this.inventoryI.setText(text);
    }
    public void setSlotsLeft(String text){
        this.slotsLeft.setText(text);
    }
    
    public void clearItemInitializeFields(){
        this.itemTf.setText("");
        this.priceTf.setText("");
        this.caloriesTf.setText("");
        this.quantityTf.setText("");
    }

    //regular maintenance view
    public void regularMaintenceFrame(){
        this.regularMaintenanceFrame = new JFrame("Vending Machine Factory - Maintenance"); 
        this.regularMaintenanceFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.regularMaintenanceFrame.setSize(600, 800);
        this.regularMaintenanceFrame.setLocationRelativeTo(null);
        

        this.machineName = new JLabel("");
        this.machineName.setFont(new Font("Calibri", Font.PLAIN, 30));
        
        
        this.addStockBtn = new JButton("Add Stock");
        this.setPriceBtn = new JButton("Set Price");
        this.collectMoney = new JButton("Collect Money");
        this.transactionBtn = new JButton("Transactions"); 

        this.backBtn2 = new JButton("Back");

        /*
        //TO-DO : Remove itemtype btn
        this.itemTypeBtn = new JButton("Rice");
         itemTypeBtn.setBounds(33, 250, 104, 29);
         this.regularMaintenanceFrame.add(itemTypeBtn);
        */

        this.coin1 = new JButton("1");
        this.coin5 = new JButton("5");
        this.coin10 = new JButton("10");
        this.coin20 = new JButton("20");
        this.bill20 = new JButton("20");
        this.bill50 = new JButton("50");
        this.bill100 = new JButton("100");

        //TO-DO: Remove default text in text field
        this.itemNameTf = new JTextField("Item name");
        this.itemNameTf.setColumns(20);
        this.numItemTf = new JTextField("# of items: ");
        this.numItemTf.setColumns(20);
        this.stockPriceTf = new JTextField("Item price");
        this.stockPriceTf.setColumns(20);
        this.slotNumberTf = new JTextField("Slot #");
        this.slotNumberTf.setColumns(20);
        this.newPriceTf = new JTextField("New price");
        this.newPriceTf.setColumns(20);
        
        this.inventoryM = new JTextArea("Inventory: ");
        this.totalDenomination = new JTextArea("Total Denominations: "); 
        this.collectedMoney = new JTextArea("Collected: ");

        this.inventoryM.setEditable(false);
        this.totalDenomination.setEditable(false);
        this.collectedMoney.setEditable(false);

        transactionBtn.setBounds(27, 30, 150, 54);
        addStockBtn.setBounds(27, 110, 111, 49);
        setPriceBtn.setBounds(154, 110, 121, 49);
        backBtn2.setBounds(420, 30, 150, 54);

        itemNameTf.setBounds(33, 175, 104, 29);
        numItemTf.setBounds(33, 211, 104, 29);
        stockPriceTf.setBounds(33,247, 104, 29);
       
        slotNumberTf.setBounds(165, 175, 104, 29);
        newPriceTf.setBounds(165, 211, 104, 29);

        coin1.setBounds(306, 110, 61, 54);
        coin5.setBounds(377, 110, 61, 54);
        coin10.setBounds(449, 110, 61, 54);
        coin20.setBounds(518, 110, 61, 54);
        bill20.setBounds(328, 175, 116, 45);
        bill50.setBounds(465, 175, 116, 45);
        bill100.setBounds(396, 225, 116, 45);

        collectMoney.setBounds(373, 547, 154, 54);
        totalDenomination.setBounds(336, 310, 270, 221);
        inventoryM.setBounds(33, 280, 230, 390);
        collectedMoney.setBounds(336, 610, 235, 90);
        
        JPanel panel6 = new JPanel();
        panel6.add(totalDenomination);
        panel6.add(collectMoney);
        panel6.add(collectedMoney);
        panel6.setBounds(301,310 ,283, 390);
        panel6.setLayout(null);

        this.regularMaintenanceFrame.add(machineName);
        this.regularMaintenanceFrame.add(backBtn2);
        this.regularMaintenanceFrame.add(transactionBtn);
        this.regularMaintenanceFrame.add(addStockBtn);
        this.regularMaintenanceFrame.add(setPriceBtn);
        this.regularMaintenanceFrame.add(itemNameTf);
        this.regularMaintenanceFrame.add(numItemTf);
        this.regularMaintenanceFrame.add(slotNumberTf);
        this.regularMaintenanceFrame.add(newPriceTf);
        this.regularMaintenanceFrame.add(coin1);
        this.regularMaintenanceFrame.add(coin5);
        this.regularMaintenanceFrame.add(coin10);
        this.regularMaintenanceFrame.add(coin20);
        this.regularMaintenanceFrame.add(bill20);
        this.regularMaintenanceFrame.add(bill50);
        this.regularMaintenanceFrame.add(bill100);
        this.regularMaintenanceFrame.add(inventoryM);
        this.regularMaintenanceFrame.add(panel6);
        

        regularMaintenanceFrame.setVisible(false);
    }

    //maintenance listeners
    public void openMaintenanceFrame(){
        this.regularMaintenanceFrame.setVisible(true);
    }
    public void closeMaintenanceFrame(){
        this.regularMaintenanceFrame.setVisible(false);
    }
        //restock features
        public void setAddStockBtnListener(ActionListener actionListener){
            this.addStockBtn.addActionListener(actionListener);
        }
        public String getItemName(){
            return this.itemNameTf.getText();
        }
        public String getNumRestock(){
            return this.numItemTf.getText();
        }
        public void clearAddStockFields(){
            this.itemNameTf.setText("");
            this.numItemTf.setText("");
        }
    
        //setprice features
        public void setPriceBtnListener(ActionListener actionListener){
            this.setPriceBtn.addActionListener(actionListener);
        }
        public String getSlotNumber(){
            return this.slotNumberTf.getText();
        }
        public String getNewPrice(){
            return this.newPriceTf.getText();
        }
        public void clearNewPriceFields(){
            this.slotNumberTf.setText("");
            this.newPriceTf.setText("");
        }
    
    public void setBackBtn2Listener(ActionListener actionListener){
        this.backBtn2.addActionListener(actionListener);
    }
    public void setInventoryM(String text){
        this.inventoryM.setText(text);
    }

    public void setCoin1Listener(ActionListener actionListener) {
        this.coin1.addActionListener(actionListener);
    }
    public void setCoin5Listener(ActionListener actionListener) {
        this.coin5.addActionListener(actionListener);
    }
    public void setCoin10Listener(ActionListener actionListener) {
        this.coin10.addActionListener(actionListener);
    }
    public void setCoin20Listener(ActionListener actionListener) {
        this.coin20.addActionListener(actionListener);
    }
    public void setBill20Listener(ActionListener actionListener) {
        this.bill20.addActionListener(actionListener);
    }
    public void setBill50Listener(ActionListener actionListener) {
        this.bill50.addActionListener(actionListener);
    }
    public void setBill100Listener(ActionListener actionListener) {
        this.bill100.addActionListener(actionListener);
    }
    public void setTotalDenomination(String text){
        this.totalDenomination.setText(text);
    }
    public void setCollectedMoney(String text){
        this.collectedMoney.setText(text);
    }
    public void setCollectMoneyBtnListener(ActionListener actionListener){
        this.collectMoney.addActionListener(actionListener);
    }
    public void setTransactionBtnListener(ActionListener actionListener){
        this.transactionBtn.addActionListener(actionListener);
    }
    
    public void transactionFrame(){
        this.transactionFrame = new JFrame("Vending Machine Factory - Transaction History");
        this.transactionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.transactionFrame.setSize(600, 800);
        this.transactionFrame.setLocationRelativeTo(null);

        this.transactionhistory = new JLabel("Transaction History");
        
        this.backTransactionBtn = new JButton("Back");

        this.history = new JTextArea("");

        transactionhistory.setBounds(79, 83, 161, 15);
        backTransactionBtn.setBounds(389, 64, 154, 54);
        history.setBounds(48, 161, 495, 562);

        transactionFrame.add(transactionhistory);
        transactionFrame.add(backTransactionBtn);
        transactionFrame.add(history);

        transactionFrame.setVisible(false);
    } 
    public void openTransactionFrame(){
        transactionFrame.setVisible(true);
    }
    public void closeTransactionFrame(){
        transactionFrame.dispose();
    }
    public void setBackTransactionBtnListener(ActionListener actionListener){
        this.backTransactionBtn.addActionListener(actionListener);
    }
    

}
