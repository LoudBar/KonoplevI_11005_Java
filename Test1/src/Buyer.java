import java.util.ArrayList;

public class Buyer {

    String name;
    ArrayList<City> cities = new ArrayList<>();

    public Buyer(String name) {
        this.name = name;
    }

    public void addOrder(String city, String name, int quantity) {
        for (int i = 0; i < cities.size(); i++)
            if (cities.get(i).getName().equals(city)) {
                cities.get(i).addOrder(name, quantity);
                return;
            }
        cities.add(new City(city));
        addOrder(city, name, quantity);
    }

    public String getName() {
        return name;
    }

    public int getOrdersQuantity() {
        int k = 0;
        for (City city : cities)
            k += city.getOrdersQuantity();
        return k;
    }

    public int getCitiesQuantity() {
        int ans = cities.size();
        return ans;
    }

    @Override
    public String toString() {
        return "\nBuyer " + "name: " + name + ", cities: " + cities;
    }
}
