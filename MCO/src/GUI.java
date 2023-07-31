public class GUI {

    public static void main(String[] args){
        DriverView driverView = new DriverView();
        DriverModel driverModel = new DriverModel();

        DriverController driverController = new DriverController(driverView, driverModel);

    }
}
