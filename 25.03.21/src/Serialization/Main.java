package Serialization;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Warehouse warehouse = new Warehouse();

        List<Order> orders = new ArrayList<>();

        orders.add(new Order("Apple", 1));
        orders.add(new Order("Pineapple", 5));
        orders.add(new Order("Plum", 3));

        warehouse.writeOrderToFile(orders);
        warehouse.addOrder("Pear", 2);
        warehouse.removeOrder(0);
        warehouse.changeQuantity(2, 10);
        warehouse.readOrder();
    }
}
