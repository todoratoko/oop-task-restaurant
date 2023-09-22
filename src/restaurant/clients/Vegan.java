package restaurant.clients;

import restaurant.Restaurant;
import restaurant.consumables.MenuListConsumables;

public class Vegan extends Client{
    public Vegan(Restaurant restaurant) {
        super(restaurant);
        this.cashInPocket = 30;
    }

    @Override
    protected IVeganFoods pickItem() {
        return restaurant.menu.getRandomVeganItem();
    }
}
