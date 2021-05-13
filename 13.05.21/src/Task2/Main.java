package Task2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        Stream<Integer> stream = Stream.of(123, 231, 312, 231);

        stream.sorted(Comparator.comparingInt(x -> x % 10))
                .map((x) -> x / 10)
                .distinct()
                .forEach(System.out::println);
    }
}
