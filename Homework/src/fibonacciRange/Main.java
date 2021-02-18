package fibonacciRange;


public class Main {

    public static void main(String[] args) {

        FibonacciRange range = new FibonacciRange(30);
        while (range.iterator().hasNext()) {
            System.out.println(range.iterator().next());
        }


    }
}