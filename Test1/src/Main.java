import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class Main {

    public static void main(String[] args) {

        List<Buyer> buyers = new ArrayList<>();
        List<City> cities = new ArrayList<>();
        List<String> str = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("orders.txt"))) {
            String s;
            while ((s = reader.readLine()) != null) {
                str.add(s);
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }

        for (int i = 0; i < str.size(); i++) {
            String[] s = str.get(i).split("\\|");
            Order order = new Order(s[2], Integer.parseInt(s[3]));
            City city = new City(s[1], order);
            Buyer buyer = new Buyer(s[0], city);
            if (buyers.size() != 0) {
                for (int j = 0; j < buyers.size(); j++) {
                    if (buyers.get(i).getName().equals(buyer.getName())) {
                        int size1 = buyers
                        for (int n = 0; n < size1; n++) {
                            ArrayList<Order> orders =
                            if (cities.get(i).getName().equals(city.getName()))
                                for (int m = 0; m <)
                        }
                    }
                }
            }
            else {cities.add(city); buyers.add(buyer);}
        }
    }
}
