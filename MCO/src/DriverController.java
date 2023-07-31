
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DriverController {
    private DriverView driverView; 
    private DriverModel driverModel; 

    public DriverController(DriverView driverView, DriverModel driverModel){
        this.driverView = driverView; 
        this.driverModel = driverModel; 

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
                //TO-DO: Add proper feedback text for conditions above
                driverView.clearTextFields();
            }
        });
        this.driverView.setTestVM_BtnListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
            }
        });
        this.driverView.setExit_BtnListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                driverView.closeFrame(); 
            }
        });
    }
}

