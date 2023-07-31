
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JTextArea;




import java.awt.FlowLayout;
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
    private JButton testFeaturesBtn, maintenanceBtn, exit_Btn2; 

    public DriverView(){
        MainView(); 
        OptionsVMView();
    }

    public void MainView(){
        this.mainFrame = new JFrame("Vending Machine Factory");

        this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.mainFrame.setSize(600, 800);
        
        this.factoryLabel = new JLabel("Venching Machine Factory");
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


        this.factoryLabel.setBounds(204, 150, 193, 50);
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

    public void OptionsVMView(){
        this.optionsFrame = new JFrame("Vending Machine Factory");

        this.optionsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.optionsFrame.setSize(600, 800); 

        this.vmLbl = new JLabel("");
        this.testFeaturesBtn = new JButton("Test Vending Features");
        this.maintenanceBtn = new JButton("Perform Maintenance");
        this.exit_Btn2 = new JButton("Exit");

        this.vmLbl.setBounds(184, 127, 223, 54);
        this.testFeaturesBtn.setBounds(184, 251, 223, 54);
        this.maintenanceBtn.setBounds(184, 338, 223, 54);
        this.exit_Btn2.setBounds(184, 426, 223, 54);

        this.optionsFrame.add(vmLbl);
        this.optionsFrame.add(testFeaturesBtn);
        this.optionsFrame.add(maintenanceBtn);
        this.optionsFrame.add(exit_Btn2); 

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
    public void setExit_Btn2Listener(ActionListener actionListener){
        this.exit_Btn2.addActionListener(actionListener);
    }
    public void closeOptionsFrame(){
        optionsFrame.dispose();
    }


}
