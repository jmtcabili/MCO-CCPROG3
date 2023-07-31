
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JTextArea;




import java.awt.FlowLayout;
import java.awt.Font;
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

    //Maintencen Frame components
    private JFrame regularMaintenanceFrame; 

    private JLabel machineName;

    private JButton addStockBtn, setPriceBtn, itemTypeBtn, coin1, coin5, coin10, coin20,
                    bill20, bill50, bill100;

    private JTextField itemNameTf, numItemTf, numRestockTf, 
                       slotNumberTf, newPriceTf; 

    private JTextArea inventory, totalDenomination, collectedMoney;

    public Object setTestFeaturesBtnListener; 

  
    

    public DriverView(){
        MainView(); 
        OptionsVMView();
        regularMaintenceFrame();
    }

    public void MainView(){
        this.mainFrame = new JFrame("Vending Machine Factory");

        this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.mainFrame.setSize(600, 800);
        
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


        this.createVM_Btn = new JButton("Create Regular VM");
        this.createVM_Btn.setPreferredSize(new Dimension(223, 54));
        this.testVM_Btn = new JButton("Test a vending machine");
        this.testVM_Btn.setPreferredSize(new Dimension(223, 54));
        this.exit_Btn1 = new JButton("Exit");
        this.exit_Btn1.setPreferredSize(new Dimension(223, 54));
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

    public void OptionsVMView(){
        this.optionsFrame = new JFrame("Vending Machine Factory");

        this.optionsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.optionsFrame.setSize(600, 800); 

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

    public void regularMaintenceFrame(){
        this.regularMaintenanceFrame = new JFrame("Vending Machine Factory - Maintenance"); 
        this.regularMaintenanceFrame.setSize(600, 800);

        JPanel mPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); 
        this.machineName = new JLabel("");
        this.machineName.setFont(new Font("Calibri", Font.PLAIN, 30));

        this.addStockBtn = new JButton("Add Stock");
        this.setPriceBtn = new JButton("Set Price");
        this.itemTypeBtn = new JButton("Rice");
        this.coin1 = new JButton("1");
        this.coin5 = new JButton("5");
        this.coin10 = new JButton("10");
        this.coin20 = new JButton("20");
        this.bill20 = new JButton("20");
        this.bill50 = new JButton("50");
        this.bill100 = new JButton("100");

        this.itemNameTf = new JTextField();
        this.itemNameTf.setColumns(20);
        this.numItemTf = new JTextField();
        this.numItemTf.setColumns(20);
        this.numRestockTf = new JTextField();
        this.numRestockTf.setColumns(20);
        this.slotNumberTf = new JTextField();
        this.slotNumberTf.setColumns(20);
        this.newPriceTf = new JTextField();
        this.newPriceTf.setColumns(20);
        
        this.inventory = new JTextArea("Inventory: ");
        this.totalDenomination = new JTextArea("Total Denominations: "); 
        this.collectedMoney = new JTextArea("Collected: ");

        this.inventory.setEditable(false);
        this.totalDenomination.setEditable(false);
        this.collectedMoney.setEditable(false);

        mPanel.setBounds(20, 30, 223, 54);
        addStockBtn.setBounds(27, 110, 111, 49);
        setPriceBtn.setBounds(154, 110, 121, 49);

        itemNameTf.setBounds(33, 175, 104, 29);
        numItemTf.setBounds(33, 211, 104, 29);
        itemTypeBtn.setBounds(33, 250, 104, 29);

        slotNumberTf.setBounds(165, 175, 104, 29);
        newPriceTf.setBounds(165, 211, 104, 29);

        coin1.setBounds(306, 110, 61, 54);
        coin5.setBounds(377, 110, 61, 54);
        coin10.setBounds(449, 110, 61, 54);
        coin20.setBounds(518, 110, 61, 54);
        bill20.setBounds(328, 175, 116, 45);
        bill50.setBounds(465, 175, 116, 45);
        bill100.setBounds(396, 225, 116, 45);

        inventory.setBounds(33, 340, 252, 390);
        totalDenomination.setBounds(336, 340, 235, 160);
        collectedMoney.setBounds(336, 400, 235, 160);

        this.regularMaintenanceFrame.add(mPanel);
        this.regularMaintenanceFrame.add(addStockBtn);
        this.regularMaintenanceFrame.add(setPriceBtn);
        this.regularMaintenanceFrame.add(itemNameTf);
        this.regularMaintenanceFrame.add(numItemTf);
        this.regularMaintenanceFrame.add(slotNumberTf);
        this.regularMaintenanceFrame.add(newPriceTf);
        this.regularMaintenanceFrame.add(itemTypeBtn);
        this.regularMaintenanceFrame.add(coin1);
        this.regularMaintenanceFrame.add(coin5);
        this.regularMaintenanceFrame.add(coin10);
        this.regularMaintenanceFrame.add(coin20);
        this.regularMaintenanceFrame.add(bill20);
        this.regularMaintenanceFrame.add(bill50);
        this.regularMaintenanceFrame.add(bill100);
        this.regularMaintenanceFrame.add(inventory);
        this.regularMaintenanceFrame.add(inventory);
        this.regularMaintenanceFrame.add(totalDenomination);
        this.regularMaintenanceFrame.add(collectedMoney);

        regularMaintenanceFrame.setVisible(false);
    }

    public void openMaintenanceFrame(){
        this.regularMaintenanceFrame.setVisible(true);
    }
    
}
