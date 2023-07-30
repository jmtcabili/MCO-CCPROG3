
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JPanel;



import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Flow;

public class DriverView {
    private JFrame mainFrame; 

    private JLabel nameLbl, slotCountLbl, itemCountLbl, factoryLabel; 

    private JTextField nameTf, slotCountTf, itemCountTf; 

    private JButton createVM_Btn, VMType_Btn;  
    private JButton testVM_Btn; 
    private JButton exit_Btn; 

    private JTextArea vendingMachineList; 


    public DriverView(){
        this.mainFrame = new JFrame("Vending Machine Factory");

        this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.mainFrame.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.mainFrame.setSize(600, 800);

        this.factoryLabel = new JLabel("Venching Machine Factory");
        this.nameLbl = new JLabel("Enter vending machine name: ");
        this.slotCountLbl = new JLabel("Enter number of slots (8-12): ");
        this.itemCountLbl = new JLabel("Enter max item count per slot: ");

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
        this.exit_Btn = new JButton("Exit");
        this.exit_Btn.setPreferredSize(new Dimension(223, 54));
        this.VMType_Btn = new JButton("Regular");


        this.factoryLabel.setBounds(204, 152, 193, 50);
        this.createVM_Btn.setBounds(128, 261, 223, 54);
        this.nameLbl.setBounds(160, 336, 91, 19);
        this.nameTf.setBounds(321, 336, 145, 19);
        this.slotCountLbl.setBounds(100, 365, 124, 19);
        this.slotCountTf.setBounds(321, 365, 145, 19);
        this.itemCountLbl.setBounds(160, 394, 129, 19);
        this.itemCountTf.setBounds(321, 394, 145, 19);
        this.testVM_Btn.setBounds(62,456,223,54);
        this.exit_Btn.setBounds(312, 456, 223, 54);
        this.VMType_Btn.setBounds(371, 276, 101, 24) ;


        mainFrame.add(factoryLabel);
        mainFrame.add(createVM_Btn);
        mainFrame.add(nameLbl);
        mainFrame.add(nameTf);
        mainFrame.add(slotCountLbl);
        mainFrame.add(slotCountTf);
        mainFrame.add(itemCountLbl);
        mainFrame.add(itemCountTf);
        mainFrame.add(testVM_Btn);
        mainFrame.add(exit_Btn);
        mainFrame.add(VMType_Btn);

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

    public void setTestVM_BtnListener(ActionListener actionListener){
        this.testVM_Btn.addActionListener(actionListener);
    }
    public void setExit_BtnListener(ActionListener actionListener){
        this.exit_Btn.addActionListener(actionListener);
    }
    public void setVendingMachineList (String text){ //maybe accept the list then append machines to string
        this.vendingMachineList.setText(text);
    }
    public void clearTextFields(){
        this.vendingMachineList.setText("");
    }
    

}
