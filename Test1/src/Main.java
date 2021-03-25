import java.util.ArrayList;
import java.io.*;
import java.util.Comparator;
import java.util.TreeSet;

public class Main {

    static ArrayList<Buyer> buyers = new ArrayList<>();

    static void addOrder(String name, String city, String item, int count) {
        Buyer buyer = getBuyer(name);
        buyer.addOrder(city, item, count);
    }

    static Buyer getBuyer(String name) {
        for (Buyer buyer : buyers)
            if (buyer.getName().equals(name)) {
                return buyer;
            }

        buyers.add(new Buyer(name));
        return getBuyer(name);
    }

    static void nameFirst(){
        BuyerByOrdersCountComparator ordersCountComparator = new BuyerByOrdersCountComparator();
        BuyerByCityCountComparator cityCountComparator = new BuyerByCityCountComparator();
        BuyerByNameComparator nameComparator = new BuyerByNameComparator();
        Comparator<Buyer> comparator1 = nameComparator.thenComparing(cityCountComparator).thenComparing(ordersCountComparator);
        TreeSet<Buyer> nameSort = new TreeSet<>(comparator1);
        nameSort.addAll(buyers);
        try {
            FileOutputStream fos = new FileOutputStream("sortedByNames.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (Buyer buyer : nameSort)
                oos.writeObject(buyer.toString());

            fos.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void ordersFirst(){
        BuyerByOrdersCountComparator ordersCountComparator = new BuyerByOrdersCountComparator();
        BuyerByCityCountComparator cityCountComparator = new BuyerByCityCountComparator();
        BuyerByNameComparator nameComparator = new BuyerByNameComparator();
        Comparator<Buyer> comparator2 = ordersCountComparator.thenComparing(cityCountComparator).thenComparing(nameComparator);
        TreeSet<Buyer> ordersCountSort = new TreeSet<>(comparator2);
        ordersCountSort.addAll(buyers);
        try {
            FileOutputStream fos = new FileOutputStream("sortedByOrders.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (Buyer buyer : ordersCountSort)
                oos.writeObject(buyer.toString());

            fos.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new FileReader("orders.txt"))) {
            String s;
            while ((s = reader.readLine()) != null) {
                String[] str = s.split("\\|");
                addOrder(str[0], str[1], str[2], Integer.parseInt(str[3]));
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }

        for (Buyer buyer : buyers) System.out.println(buyer);
        
        ordersFirst();
        nameFirst();
    }
}
