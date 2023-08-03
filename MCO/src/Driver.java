
/**
 * This class contains the main method of the program 
 * @author Johan Marlo T. Cabili
 * @author Joemar T. Lapasaran
 * @version 1.0
 */
public class Driver {

    public static void main(String[] args){
        DriverView driverView = new DriverView();
        DriverModel driverModel = new DriverModel();

        DriverController driverController = new DriverController(driverView, driverModel);

    }
}
