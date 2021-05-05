package Task1;

import java.util.Comparator;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {

        TreeSet<String> treeSet = new TreeSet<>(Comparator.comparingInt(String::length));

        treeSet.add("Raxacoricofallapatorius");
        treeSet.add("K9");
        treeSet.add("Tardis");

        for (String x : treeSet) System.out.println(x);

    }
}
