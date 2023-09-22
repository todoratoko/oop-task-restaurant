package restaurant.consumables;

import restaurant.util.Helper;

public class Desserts extends Food{
    public Desserts(String name) {
        super(name);
        this.price = 4;
    }

    protected int getWeight() {
        return Helper.getRandom(200,300);
    }

    @Override
    public MenuItemType getItemType() {
        return MenuItemType.DESSERT;
    }
}
