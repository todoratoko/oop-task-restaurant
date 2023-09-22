package restaurant.clients;

import restaurant.Restaurant;
import restaurant.Waiter;
import restaurant.consumables.IConsumables;
import restaurant.consumables.MenuListConsumables;
import restaurant.util.Helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Client {
    private String name;
    private String[] nameList = {"Gosho", "Tosho", "Nikola", "Misho", "Pepi", "Stefi", "Bobi"};
    protected double cashInPocket;
    protected Restaurant restaurant;
    private Waiter waiter;
    private double bill;


    public Client(Restaurant restaurant) {
        this.name = getRandomName();
        this.restaurant = restaurant;
    }

    private String getRandomName() {
        return nameList[Helper.getRandom(nameList.length)];
    }

    public void makeOrder() {
        this.waiter = restaurant.getRandomWaiter();
        List<IConsumables> order = new ArrayList<>();
        double orderPrice = 0;
        while (true) {
            IConsumables item = pickItem();
            if (item != null) {
                if (this.cashInPocket * 0.9 >= item.getPrice() + orderPrice) {
                    System.out.println("Chose " + item.getName());
                    orderPrice += item.getPrice();
                    restaurant.removeItem(item);
                    order.add(item);
                } else {
                    break;
                }
            }else{
                break;
            }
            waiter.acceptOrder(this, order);
        }
    }

    public void askForBill() {
        this.bill = waiter.getCheck(this);
    }

    public void payBill() {
        this.cashInPocket -= this.bill;
        System.out.println();
        System.out.print(this.getName() + " payed his bill which is "+ this.bill + "$ and is left with - " + this.cashInPocket + "$");
        this.restaurant.addMoney(bill);
        if (Helper.getRandom(100) < 80) {
            double tip = Helper.getRandom(5, 10) * this.bill * 0.01;
            System.out.print(" and tipped the waiter : " + tip + "$");
            this.cashInPocket -= tip;
            this.waiter.addCashFromToTips(tip);
        }
    }

    protected abstract IConsumables pickItem();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Double.compare(client.cashInPocket, cashInPocket) == 0 && Objects.equals(name, client.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cashInPocket);
    }

    public String getName() {
        return name;
    }

    public double getBill() {
        return this.bill;
    }
}


