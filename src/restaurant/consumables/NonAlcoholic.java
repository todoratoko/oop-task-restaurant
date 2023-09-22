package restaurant.consumables;

import restaurant.clients.IVeganFoods;

public class NonAlcoholic extends Drinks implements IVeganFoods {


    public NonAlcoholic(String name) {
        super(name);
        this.price = 4;
    }

    @Override
    public MenuItemType getItemType() {
        return MenuItemType.NON_ALCOHOLIC;
    }
}
