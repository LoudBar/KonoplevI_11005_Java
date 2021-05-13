package Task1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("aisd", "dskmfl", "ads", "gr", "a");
        Stream<String> stream = list.stream();

        stream.filter(x -> x.startsWith("a"))
                .sorted(Comparator.comparingInt(String::length))
                .forEach(System.out::println);
    }
}
