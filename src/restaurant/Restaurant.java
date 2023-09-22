package restaurant;

import restaurant.clients.Client;
import restaurant.clients.IThugFoods;
import restaurant.clients.IVeganFoods;
import restaurant.consumables.IConsumables;
import restaurant.consumables.MenuListConsumables;
import restaurant.util.Helper;

import java.util.*;


public class Restaurant {

    private String name;
    private String address;
    private double capital;
    public Menu menu;
    public TreeSet<Waiter> waiters;
    public ArrayList<Client> clients;

    public Restaurant(String name, String address, int capital, int waitersNumber) {
        this.name = name;
        this.address = address;
        this.capital = capital;
        this.waiters = new TreeSet<>();
        for (int i = 0; i < waitersNumber; i++) {
            waiters.add(new Waiter());
        }
        this.menu = new Menu();
        this.clients = new ArrayList<>();


    }


    public Waiter getRandomWaiter() {
        return waiters.stream().findAny().get();
    }

    public void removeItem(IConsumables item) {
        MenuListConsumables.MenuKind kind = item.getMenuKind();
        MenuListConsumables.MenuItemType type = item.getItemType();
        if (menu.menu.containsKey(kind)) {
            if (menu.menu.get(kind).containsKey(type)) {
                menu.menu.get(kind).get(type).remove(item);
                if (item instanceof IVeganFoods) {
                    menu.forVegans.remove((IVeganFoods) item);
                }
                if (item instanceof IThugFoods) {
                    menu.forThugs.remove((IThugFoods) item);
                }
            }
        }
    }

    public void addMoney(double bill) {
        this.capital += bill;
    }

    public void startWorking() {
        clientsOrders();
        clientsAskForBill();
        clientsPayBill();
    }

    private void clientsPayBill() {
        for (int i = 0; i < clients.size(); i++) {
            clients.get(i).payBill();
        }
    }

    private void clientsAskForBill() {
        for (int i = 0; i < clients.size(); i++) {
            clients.get(i).askForBill();
        }
    }

    private void clientsOrders() {
        for (int i = 0; i < clients.size(); i++) {
            System.out.println(clients.get(i).getName() + " is making an order...: ");
            clients.get(i).makeOrder();
            System.out.println(clients.get(i).getName() + " order was accepted");

        }
    }

    public void clientsLeave() {
        for (int i = 0; i < clients.size(); i++) {
            clients.remove(i);
        }
    }

    public void capitalInfo() {
        System.out.println();
        System.out.println("The capital of this resturant is - " + this.capital + " euro");
    }

    public void showWaiterWithBiggestTip() {
        System.out.println("Waiter " + waiters.first().getName() + " has the most tips from the waiters : " + waiters.first().getCashFromTip());
    }


    public void showAllWaitersSortedByTip() {
        for (Waiter w : waiters) {
            System.out.println(w.getName() + " with tips of: " + w.getCashFromTip() + "$");
        }
    }


}
