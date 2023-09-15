package consumables;

public abstract class Food implements Consumables{
    private String name;
    protected double price;
    private int weight;

    public Food(String name) {
        this.name = name;
        this.weight = getWeight();
    }

    protected abstract int getWeight();
}
