


/**
 * This class contains the getters and setters of the item
 * @author Johan Marlo T. Cabili
 * @author Joemar T. Lapasaran
 * @version 1.0
 */


public class Item {
    private String name;
    private int calories;
    private int price;

    /** Blueprint of the class item
     * @param name name of the item
     * @param calories calories of the item
     * @param price price of the item
     */
    public Item (String name, int calories, int price) {
        this.name = name;
        this.calories = calories; 
        this.price = price; 
    }

     /** Gathers the name of the item
     * @return the name of the item
     */
    public String getName () {
        return name;
    }

    /** Gathers the calories of the item
     * @return the calories of the item
     */
    public int getCalories () {
        return calories;
    }

     /** Gathers the price of the item
     * @return the price of the item
     */
    public int getPrice () {
        return price;
    }

    /** Sets the price of the item
     * @param newPrice is the integer to be assigned to the price of the item
     */
    public void setPrice (int newPrice) {
        this.price = newPrice;
    }
}
