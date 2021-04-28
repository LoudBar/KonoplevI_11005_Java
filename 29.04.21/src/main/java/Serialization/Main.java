package Serialization;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        OrdersFileSaver fileSaver = new OrdersFileSaver("Orders.txt");
        Warehouse warehouse = new Warehouse(fileSaver);

        warehouse.addOrder("chair", 10);
        warehouse.addOrder("table", 5);
        warehouse.changeQuantity("table", 2);
        warehouse.removeOrder("chair");

        warehouse.printAll();
    }
}
