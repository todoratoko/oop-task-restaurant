import restaurant.Restaurant;
import restaurant.clients.Client;
import restaurant.clients.Student;
import restaurant.clients.Thug;
import restaurant.clients.Vegan;
import restaurant.util.Helper;

public class Demo {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant("RestoMesto", "Sofia, street. Angel Karaliichev 2", 1000, 5);
        Client client;
        for (int i = 0; i < 15; i++) {
            int chance = Helper.getRandom(100);
            if(chance < 20){
                client = new Vegan(restaurant);
            }
            if(chance >= 20 && chance < 50){
                client = new Student(restaurant);
            }else{
                client = new Thug(restaurant);
            }
            restaurant.clients.add(client);
        }
        restaurant.startWorking();
        restaurant.clientsLeave();
        restaurant.capitalInfo();
        System.out.println("----------");
        restaurant.showWaiterWithBiggestTip();
        System.out.println("-------------");
        restaurant.showAllWaitersSortedByTip();
        System.out.println("-------------");
        restaurant.menu.printLeftProductsFromTheMenu();



    }

}
