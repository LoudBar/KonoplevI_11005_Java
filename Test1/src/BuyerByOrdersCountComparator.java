import java.util.Comparator;

public class BuyerByOrdersCountComparator implements Comparator<Buyer> {
    @Override
    public int compare(Buyer o1, Buyer o2) {
        Integer a1 = o1.getOrdersQuantity();
        Integer a2 = o2.getOrdersQuantity();
        return a1.compareTo(a2);
    }
}
