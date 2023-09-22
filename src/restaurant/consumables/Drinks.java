package restaurant.consumables;

public abstract class Drinks extends MenuListConsumables{
    protected double price;

    public Drinks(String name) {
        this.name = name;
    }

    @Override
    public MenuKind getMenuKind() {
        return MenuKind.DRINK;
    }
}
