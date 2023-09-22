package restaurant.consumables;

public interface IConsumables {

    double getPrice();
    enum MenuItemType{
        SALAD, MAIN_COURSE, DESSERT, ALCOHOLIC, NON_ALCOHOLIC
    }
    enum MenuKind{
        DRINK,MEAL
    }
    IConsumables.MenuItemType getItemType();
    IConsumables.MenuKind getMenuKind();
    String getName();



}
