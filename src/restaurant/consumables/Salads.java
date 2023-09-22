package restaurant.consumables;

import restaurant.clients.IVeganFoods;
import restaurant.util.Helper;

public class Salads extends Food implements IVeganFoods {
    public Salads(String name) {
        super(name);
        this.price = 5;
    }

    @Override
    protected int getWeight() {
        return Helper.getRandom(300,600);
    }

    @Override
    public MenuItemType getItemType() {
        return MenuItemType.SALAD;
    }
}
