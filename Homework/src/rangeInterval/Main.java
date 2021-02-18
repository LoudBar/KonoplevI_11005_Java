package rangeInterval;

public class Main {

    public static void main(String[] args) {

        RangeInterval rangeInterval = new RangeInterval(2,6);
        Iterator<Integer> iterator = rangeInterval.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}