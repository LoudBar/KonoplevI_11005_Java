package Serialization;

import java.util.Iterator;
import java.util.List;

public class Warehouse {

    public OrdersSaver saver;
    public List<Order> orders;

    public Warehouse(OrdersSaver saver) {
        this.saver = saver;
        this.orders = saver.getOrders();
    }

    public void addOrder(String name, int count) {
        Order order = new Order(name, count);
        this.orders.add(order);
        this.saver.saveOrders(this.orders);
    }

    public Order getOrder(String name) {

        Iterator var = this.orders.iterator();

        Order p;

        do {
            if (!var.hasNext())
                return null;

            p = (Order) var.next();
        } while(!p.name.equals(name));

        return p;
    }

    public void removeOrder(String name) {

        Order p = this.getOrder(name);

        if (p != null)
            this.orders.remove(p);

        this.saver.saveOrders(this.orders);
    }

    public void changeQuantity(String name, int quantity) {

        Order p = this.getOrder(name);

        if (p != null)
            p.setQuantity(quantity);

        this.saver.saveOrders(this.orders);
    }

    public void printAll() {

        for (Order p : this.orders) {
            System.out.println(p.name + ": " + p.quantity);
        }

    }

}
