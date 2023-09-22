package restaurant.consumables;

public abstract class MenuListConsumables implements IConsumables {

    protected String name;
    protected double price;

    public double getPrice() {
        return price;
    }

    public String getName(){
        return name;
    }




}
