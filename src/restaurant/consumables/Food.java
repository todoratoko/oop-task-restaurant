package restaurant.consumables;

public abstract class Food extends MenuListConsumables{
    private int weight;

    public Food(String name) {
        this.name = name;
        this.weight = getWeight();
    }

    protected abstract int getWeight();

    @Override
    public MenuKind getMenuKind() {
        return MenuKind.MEAL;
    }
}
