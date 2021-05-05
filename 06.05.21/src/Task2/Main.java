package Task2;

import java.util.ArrayList;
import java.util.function.Predicate;

public class Main {

    static ArrayList<Integer> siftArray(ArrayList<Integer> arr, Predicate<Integer> pred) {

        ArrayList<Integer> ans = new ArrayList<>();
        for (int x : arr) {
            if (pred.test(x)) ans.add(x);
        }
        return ans;
    }

    public static void main(String[] args) {

        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < 10; i++) arr.add(i);

        ArrayList<Integer> oddNumbers = siftArray(arr, x -> x % 2 != 0);

        for (int x : oddNumbers) System.out.println(x);
    }
}
