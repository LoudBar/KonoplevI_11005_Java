import Serialization.Order;
import Serialization.OrdersFileSaver;
import Serialization.Warehouse;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class WarehouseToFileTests {

    private Warehouse warehouse;
    private ArrayList<Order> orders;

    @Before
    public void prepareProducts() {
        orders = new ArrayList<>();
        orders.add(new Order("chair", 10));
        orders.add(new Order("table", 5));

        OrdersFileSaver saver = new OrdersFileSaver("orders.txt");
        saver.saveOrders(orders);

        warehouse = new Warehouse(saver);
    }

    @Test
    public void readToWarehouseTest() {
        assertEquals(orders.size(), warehouse.orders.size());

        for (int i = 0; i < orders.size(); i++) {
            assertEquals(orders.get(i).name, warehouse.orders.get(i).name);
            assertEquals(orders.get(i).quantity, warehouse.orders.get(i).quantity);
        }
    }

    @Test
    public void addOrderTest() {
        orders.add(new Order("phone", 15));
        warehouse.addOrder("phone", 15);

        List<Order> temp = warehouse.saver.getOrders();

        assertEquals(orders.size(), temp.size());

        for (int i = 0; i < orders.size(); i++) {
            assertEquals(orders.get(i).name, temp.get(i).name);
            assertEquals(orders.get(i).quantity, temp.get(i).quantity);
        }
    }
}
