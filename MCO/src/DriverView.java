
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
import java.awt.Window;
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

    private JFrame testFrame;

    //Test VM Menu Components
    private JFrame optionsFrame; 

    private JLabel vmLbl; 
    private JButton testFeaturesBtn, maintenanceBtn, backBtn; 

    //Maintencen Frame components
    private JFrame regularMaintenanceFrame; 

    private JLabel machineName;

    private JButton addStockBtn, setPriceBtn, collectMoney,
                    coin1, coin5, coin10, coin20,
                    bill20, bill50, bill100;

    private JTextField itemNameTf, numItemTf, stockPriceTf, 
                       slotNumberTf, newPriceTf; 

    private JTextArea inventory, totalDenomination, collectedMoney;

    public Object setTestFeaturesBtnListener;


    private JButton item_Btn;

    private JButton item1_Btn;

    private JButton item2_Btn;

    private JButton item3_Btn;

    private JButton item4_Btn;

    private JButton item5_Btn;

    private JButton item6_Btn;

    private JButton item7_Btn;

    private JButton item8_Btn;

    private JButton item9_Btn;

    private JButton item10_Btn;

    private JButton item11_Btn;

    private JButton denom20_Btn;

    private JButton denom50_Btn;

    private JButton denom100_Btn;

    private JButton denom1_Btn;

    private JButton denom5_Btn;

    private JButton denom10_Btn;

    private JButton denom20Coin_Btn;

    private JTextArea display1;

    private JTextArea display2;

    private JTextArea display3; 

  
    

    public DriverView(){
        MainView(); 
        
        
    }

    

    public void MainView(){
        this.mainFrame = new JFrame("Vending Machine Factory");

        this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.mainFrame.setSize(600, 800);
        
        this.factoryLabel = new JLabel("<Venching Machine Factory>");
        this.factoryLabel.setFont(new Font("Calibri", Font.PLAIN, 15));
        

        this.vendingMachineList = new JTextArea(" ");
        this.vendingMachineList.setPreferredSize(new Dimension(429, 102));
        this.vendingMachineList.setEditable(false);

        this.createVM_Btn = new JButton("<Vending Machine Name>");
        this.item_Btn = new JButton("Item");
        this.item1_Btn = new JButton("Item");
        this.item2_Btn = new JButton("Item");
        this.item3_Btn = new JButton("Item");
        this.item4_Btn = new JButton("Item");
        this.item5_Btn = new JButton("Item");
        this.item6_Btn = new JButton("Item");
        this.item7_Btn = new JButton("Item");
        this.item8_Btn = new JButton("Item");
        this.item9_Btn = new JButton("Item");
        this.item10_Btn = new JButton("Item");
        this.item11_Btn = new JButton("Item");
        this.denom20_Btn = new JButton("20");
        this.denom50_Btn = new JButton("50");
        this.denom100_Btn = new JButton("100");
        this.denom1_Btn = new JButton("1");
        this.denom5_Btn = new JButton("5");
        this.denom10_Btn = new JButton("10");
        this.denom20Coin_Btn = new JButton("20");

        this.display1 = new JTextArea();
        this.display2 = new JTextArea();
        this.display3 = new JTextArea();

        this.createVM_Btn.setBounds(19, 47, 200, 19);
        this.item_Btn.setBounds(19, 139, 93, 62);
        this.item1_Btn.setBounds(131, 139, 93, 62);
        this.item2_Btn.setBounds(241, 139, 93, 62);
        this.item3_Btn.setBounds(19, 225, 93, 62);
        this.item4_Btn.setBounds(131, 225, 93, 62);
        this.item5_Btn.setBounds(241, 225, 93, 62);
        this.item6_Btn.setBounds(20, 311, 93, 62);
        this.item7_Btn.setBounds(132, 311, 93, 62);
        this.item8_Btn.setBounds(242, 311, 93, 62);
        this.item9_Btn.setBounds(19, 397, 93, 62);
        this.item10_Btn.setBounds(131, 397, 93, 62);
        this.item11_Btn.setBounds(241, 397, 93, 62);
        this.denom20_Btn.setBounds(30, 663, 150, 50);
        this.denom50_Btn.setBounds(209, 665, 150, 50);
        this.denom100_Btn.setBounds(399, 665, 150, 50);
        this.denom1_Btn.setBounds(33, 504, 48, 38);
        this.denom5_Btn.setBounds(130, 504, 48, 38);
        this.denom10_Btn.setBounds(33, 580, 48, 38);
        this.denom20Coin_Btn.setBounds(131, 580, 48, 38);
        this.display1.setBounds(356, 18, 216, 74);
        this.display2.setBounds(359, 117, 216, 342);
        this.display3.setBounds(198, 504, 374, 121);


        mainFrame.add(factoryLabel);
        mainFrame.add(createVM_Btn);
        mainFrame.add(item_Btn);
        mainFrame.add(item1_Btn);
        mainFrame.add(item2_Btn);
        mainFrame.add(item3_Btn);
        mainFrame.add(item4_Btn);
        mainFrame.add(item5_Btn);
        mainFrame.add(item6_Btn);
        mainFrame.add(item7_Btn);
        mainFrame.add(item8_Btn);
        mainFrame.add(item9_Btn);
        mainFrame.add(item10_Btn);
        mainFrame.add(item11_Btn);
        mainFrame.add(denom20_Btn);
        mainFrame.add(denom50_Btn);
        mainFrame.add(denom100_Btn);
        mainFrame.add(vendingMachineList);
        mainFrame.add(denom1_Btn);
        mainFrame.add(denom5_Btn);
        mainFrame.add(denom10_Btn);
        mainFrame.add(denom20Coin_Btn);
        mainFrame.add(display1);
        mainFrame.add(display2);
        mainFrame.add(display3);

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

    
    
}
