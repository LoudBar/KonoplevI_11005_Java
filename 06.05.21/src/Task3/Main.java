package Task3;

public class Main {

    public static void main(String[] args) {

        OrdersFileSaver fileSaver = new OrdersFileSaver("Orders.txt");
        Warehouse warehouse = new Warehouse(fileSaver);

        warehouse.addListener(warehouse::printAll);
        warehouse.addListener(() -> {
                                    int ans = 0;
                                    for (Order o : warehouse.orders) ans += o.getQuantity();
                                    System.out.println("Occupied space: " + ans);
                                    });
        warehouse.addListener(() -> {
                                    int max = 0;
                                    String ans = "";
                                    for (int i = 0; i < warehouse.orders.size(); i++) {
                                        if (warehouse.orders.get(i).getQuantity() > max) {
                                            max = warehouse.orders.get(i).getQuantity();
                                            ans = warehouse.orders.get(i).name;
                                        }
                                    }
                                    System.out.println("The biggest-sized order: " + ans);
                                    });

        warehouse.addOrder("chair", 10);
        warehouse.addOrder("table", 5);
        warehouse.changeQuantity("table", 2);
        warehouse.removeOrder("chair");

        warehouse.printAll();
    }
}
