package restaurant;

import restaurant.clients.IThugFoods;
import restaurant.clients.IVeganFoods;
import restaurant.consumables.*;
import restaurant.util.Helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Menu {

    //      Drinks or Food / restaurant.Menu Kind --->  restaurant.Menu Item Type ,  ArrayList holding the objects.
    public HashMap<MenuListConsumables.MenuKind, HashMap<MenuListConsumables.MenuItemType, ArrayList<IConsumables>>> menu;
    public ArrayList<IVeganFoods> forVegans;
    public ArrayList<IThugFoods> forThugs;

    public Menu() {
        this.menu = new HashMap<>();
        this.forThugs = new ArrayList<>();
        this.forVegans = new ArrayList<>();
        fillWithConsumables();
    }

    public IConsumables getRandomItem() {
        return menu.values().stream().findAny().get()
                .values().stream().findAny().get().
                stream().findAny().orElse(null);
    }


    public IThugFoods getRandomThugItem() {
        if (forThugs.size() != 0) {
            return forThugs.get(Helper.getRandom(forThugs.size()));
        }
        return null;
    }

    public IVeganFoods getRandomVeganItem() {
        if (forVegans.size() != 0) {
            return forVegans.get(Helper.getRandom(forVegans.size()));
        }
        return null;
    }

    private void addItemToMenu(IConsumables item) {
        IConsumables.MenuKind kind = item.getMenuKind();
        IConsumables.MenuItemType type = item.getItemType();
        if (!menu.containsKey(kind)) {
            menu.put(kind, new HashMap<>());
        }
        if (!menu.get(kind).containsKey(type)) {
            menu.get(kind).put(type, new ArrayList<>());
        }
        menu.get(kind).get(type).add(item);
        if (item instanceof IVeganFoods) {
            forVegans.add((IVeganFoods) item);
        }
        if (item instanceof IThugFoods) {
            forThugs.add((IThugFoods) item);
        }
    }

    private void fillWithConsumables() {
        for (int i = 0; i < 100; i++) {
            addItemToMenu(new Salads("Shopska"));
            addItemToMenu(new Desserts("Cream"));
            addItemToMenu(new MainCourse("Steak"));
        }
        for (int i = 0; i < 200; i++) {
            addItemToMenu(new Alcoholic("Whiskey"));
            addItemToMenu(new NonAlcoholic("Soda"));
        }
    }

    public void printLeftProductsFromTheMenu() {
        for (Map.Entry<IConsumables.MenuKind, HashMap<IConsumables.MenuItemType, ArrayList<IConsumables>>> e : menu.entrySet()) {
            System.out.println(e.getKey() + " :");
            for (Map.Entry<IConsumables.MenuItemType, ArrayList<IConsumables>> e1 : e.getValue().entrySet()) {
                System.out.println(e1.getKey() + " with number of : " + e1.getValue().size());
            }
        }
    }
}
