package restaurant.clients;

import restaurant.Restaurant;
import restaurant.consumables.IConsumables;
import restaurant.consumables.MenuListConsumables;

public class Student extends Client {


    public Student(Restaurant restaurant) {
        super(restaurant);
        this.cashInPocket = 10;
    }

    @Override
    protected IConsumables pickItem() {
        return restaurant.menu.getRandomItem();
    }
}


