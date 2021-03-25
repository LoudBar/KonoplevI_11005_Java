import java.util.ArrayList;

public class City {

    String name;
    ArrayList<Order> orders = new ArrayList<>();

    public City(String name) {
        this.name = name;
    }

    public void addOrder(String name, int quantity) {
        for (Order order : orders ){
            if (order.getName().equals(name)) {
                int i = order.getQuantity() + quantity;
                order.setQuantity(i);
                return;
            }
        }
        orders.add(new Order(name, quantity));
    }

    public String getName() {
        return name;
    }

    public int getOrdersQuantity() {
        return orders.size();
    }

    public boolean nameContains(String name) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getName().equals(name)) return true;
        }
        return false;
    }
    @Override
    public String toString() {
        return "\n    City: " + "name: " + name + ", orders: " + orders;
    }
}
