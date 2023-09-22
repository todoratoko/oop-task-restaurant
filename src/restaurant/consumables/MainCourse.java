package restaurant.consumables;

import restaurant.clients.IThugFoods;
import restaurant.util.Helper;

public class MainCourse extends Food implements IThugFoods {
    public MainCourse(String name) {
        super(name);
        this.price = 9;
    }

    protected int getWeight() {
        return Helper.getRandom(400,800);
    }

    @Override
    public MenuItemType getItemType() {
        return MenuItemType.MAIN_COURSE;
    }
}
