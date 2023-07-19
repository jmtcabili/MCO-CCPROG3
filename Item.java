package MCO1; 


public class Item {
    private String name;
    private int calories;
    private int price;

    public Item (String name, int calories, int price) {
        this.name = name;
        this.calories = calories; 
        this.price = price; 
    }
    
    public String getName () {
        return name;
    }

    public int getCalories () {
        return calories;
    }

    public int getPrice () {
        return price;
    }

    public void setPrice (int newPrice) {
        this.price = newPrice;
    }
}
