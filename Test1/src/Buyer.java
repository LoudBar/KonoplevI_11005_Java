import java.util.ArrayList;
import java.util.List;

public class Buyer {

    String name;
    ArrayList<City> cities = new ArrayList<>();

    public Buyer(String name, City city) {
        this.name = name;
        this.cities.add(city);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<City> getCities() {
        return ;
    }

    public void setCities(List<City> cities) {
        Cities = cities;
    }
}
