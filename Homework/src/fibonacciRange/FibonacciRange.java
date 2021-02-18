package fibonacciRange;


public class FibonacciRange implements Iterable<Integer> {

    private final int length;
    protected int counter;
    protected int a = 0;
    protected int b = 1;
    private int ans;

    public FibonacciRange(int length) {
        this.length = length;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {

            @Override
            public Integer next() {
                if (counter == 0) {
                    counter++;
                    return 0;
                }

                if (counter == 1) {
                    counter++;
                    return 1;
                }

                ans = a + b;
                a = b;
                b = ans;
                counter++;

                return b ;
            }

            @Override
            public boolean hasNext() {
                return counter < length;
            }


        };
    }
}
