package restaurant.clients;

import restaurant.Restaurant;
import restaurant.consumables.MenuListConsumables;

public class Thug extends Client {

    public Thug(Restaurant restaurant) {
        super(restaurant);
        this.cashInPocket = 50;
    }

    @Override
    protected IThugFoods pickItem() {
        return restaurant.menu.getRandomThugItem();
    }
}
