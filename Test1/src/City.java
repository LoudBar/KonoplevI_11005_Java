import java.util.ArrayList;
import java.util.List;

public class City {

    String name;
    ArrayList<Order> orders = new ArrayList<>();

    public City(String name, Order order) {
        this.name = name;
        this.orders.add(order);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Order> getOrder() {
        return 0;
    }

    public void setOrder(List<Order> order) {
        Order = order;
    }
}
