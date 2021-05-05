package Task3;

import java.util.ArrayList;
import java.util.List;

public class OrdersRuntimeSaver implements OrdersSaver {

    public List<Order> orders = new ArrayList<>();

    @Override
    public List<Order> getOrders() {
        return orders;
    }

    @Override
    public void saveOrders(List<Order> orders) {
        this.orders = orders;
    }
}
