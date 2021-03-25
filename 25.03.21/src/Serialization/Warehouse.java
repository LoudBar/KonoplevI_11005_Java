package Serialization;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Warehouse {

    public void writeOrderToFile(List<Order> orders) {
        try {
            FileOutputStream fos = new FileOutputStream("orders.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(orders);

            fos.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readOrder() {
        try {
            FileInputStream fis = new FileInputStream("orders.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            List<Order> orders = (List<Order>) ois.readObject();

            System.out.println(Arrays.toString(new List[]{orders}));

            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<Order> orderList() {
        List<Order> ans = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream("orders.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            List<Order> orders = (List<Order>) ois.readObject();
            ans = orders;

            ois.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return ans;
    }

    public void addOrder(String name, int quantity) {

        List<Order> list = orderList();
        list.add(new Order(name, quantity));
        writeOrderToFile(list);
    }

    public void removeOrder(int id) {

        List<Order> list = orderList();
        list.remove(id);
        writeOrderToFile(list);
    }

    public void changeQuantity(int id, int quantity) {

        List<Order> list = orderList();
        Order tmp = list.get(id);
        tmp.setQuantity(quantity);
        writeOrderToFile(list);
    }

}
