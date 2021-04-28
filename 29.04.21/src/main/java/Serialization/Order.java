package Serialization;

import java.io.Serializable;

public class Order implements Serializable {

    public String name;
    public int quantity;

    public Order(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
