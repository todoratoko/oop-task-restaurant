package consumables;

import clients.Thug;
import clients.ThugFoods;
import util.Helper;

public class MainCourse extends Food implements ThugFoods {
    public MainCourse(String name) {
        super(name);
        this.price = 9;
    }

    protected int getWeight() {
        return Helper.getRandom(400,800);
    }
}
