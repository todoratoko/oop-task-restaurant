package restaurant.consumables;

import restaurant.clients.IThugFoods;

public class Alcoholic extends Drinks implements IThugFoods {


    public Alcoholic(String name) {
        super(name);
        this.price = 4;
    }


    @Override
    public MenuItemType getItemType() {
        return MenuItemType.ALCOHOLIC;
    }
}
