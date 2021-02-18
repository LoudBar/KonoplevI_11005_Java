package rangeInterval;

public class RangeInterval extends Range {

    protected int start;
    protected int end;

    public RangeInterval(int start, int end) {

        super(end);
        this.end = end;
        this.start = start;
    }


    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public Integer next() {
                return start++;
            }

            @Override
            public boolean hasNext() {
                return start < end;
            }

        };
    }
}

