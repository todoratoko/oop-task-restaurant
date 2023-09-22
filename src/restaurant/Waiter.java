package restaurant;

import restaurant.clients.Client;
import restaurant.consumables.IConsumables;
import restaurant.consumables.MenuListConsumables;
import restaurant.util.Helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Waiter implements Comparable<Waiter> {

    private String[] listOfNames = {"Gosho", "Tosho", "Nikola", "Misho", "Pepi", "Stefi", "Bobi"};

    private String name;
    private double cashFromTip;
    private HashMap<Client, List<IConsumables>> orders;

    public Waiter() {
        this.name = getRandomName();
        this.orders = new HashMap<>();
    }

    public double getCashFromTip() {
        return cashFromTip;
    }

    public void addCashFromToTips(double cashFromTip) {
        this.cashFromTip += cashFromTip;
    }

    private String getRandomName() {
        return listOfNames[Helper.getRandom(listOfNames.length)];
    }


    @Override
    public int compareTo(Waiter other) {
        if (this.getCashFromTip() == other.getCashFromTip()) {
            return 1;
        }
        return Double.compare(other.getCashFromTip(), this.getCashFromTip());
    }

    public void acceptOrder(Client client, List<IConsumables> order) {
        if (!orders.containsKey(client)) {
            orders.put(client, new ArrayList<>());
        }
        orders.put(client, order);
    }

    public String getName() {
        return name;
    }

    public double getCheck(Client client) {
        if (orders.containsKey(client)) {
            double totalPrice = 0;
            for (IConsumables item : orders.get(client)) {
                totalPrice += item.getPrice();
            }
            return totalPrice;
        }
        return 0;
    }
}
