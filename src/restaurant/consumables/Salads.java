package consumables;

import clients.VeganFoods;
import util.Helper;

public class Salads extends Food implements VeganFoods {
    public Salads(String name) {
        super(name);
        this.price = 5;
    }

    @Override
    protected int getWeight() {
        return Helper.getRandom(300,600);
    }
}
