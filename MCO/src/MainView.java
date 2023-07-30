package MCO.src;

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

public class MainView {
    private JFrame mainFrame; 

    private JLabel factoryLabel; 

    private JButton createRVM_Btn; 
    private JButton createSVM_Btn; 
    private JButton testVM_Btn; 
    private JButton exit_Btn; 

    private JTextArea vendingMachineList; 


    public MainView(){
        this.mainFrame = new JFrame("Vending Machine Factory");

        this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.mainFrame.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.mainFrame.setSize(600, 800);

        this.factoryLabel = new JLabel("Venching Machine Factory");

        this.vendingMachineList = new JTextArea(" ");
        this.vendingMachineList.setPreferredSize(new Dimension(429, 102));
        this.vendingMachineList.setEditable(false);

        this.createRVM_Btn = new JButton("Create Regular VM");
        this.createRVM_Btn.setPreferredSize(new Dimension(223, 54));
        this.createRVM_Btn = new JButton("Create Special VM");
        this.createRVM_Btn.setPreferredSize(new Dimension(223, 54));
        this.createRVM_Btn = new JButton("Test a vending machine");
        this.createRVM_Btn.setPreferredSize(new Dimension(223, 54));
        this.createRVM_Btn = new JButton("Exit");
        this.createRVM_Btn.setPreferredSize(new Dimension(223, 54));

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.add(this.factoryLabel);
        panel.setPreferredSize(new Dimension(501, 121));
        this.mainFrame.add(panel);

        this.mainFrame.add(createRVM_Btn);
        this.mainFrame.add(createSVM_Btn);
        this.mainFrame.add(testVM_Btn);
        this.mainFrame.add(exit_Btn);
        


    }
}
