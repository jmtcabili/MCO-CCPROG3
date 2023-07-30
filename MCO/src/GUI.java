public class GUI {

    public static void main(String[] args){
        DriverView driverView = new DriverView();

        DriverController driverController = new DriverController(driverView);
    }
}
