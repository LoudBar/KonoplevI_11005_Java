import java.util.Comparator;

public class BuyerByCityCountComparator implements Comparator<Buyer> {
    @Override
    public int compare(Buyer o1, Buyer o2) {
        Integer a1 = o1.getCitiesQuantity();
        Integer a2 = o2.getCitiesQuantity();
        return a1.compareTo(a2);
    }
}
