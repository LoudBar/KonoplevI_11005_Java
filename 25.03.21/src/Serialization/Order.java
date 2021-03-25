package Serialization;

import java.io.*;

public class Order implements Serializable {

    private String name;
    private int quantity;

    public Order(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String toString() {
        return name + " : " + quantity;
    }
}
