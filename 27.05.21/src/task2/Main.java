package task2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        List<String> evenList = new ArrayList<>();
        List<String> oddList = new ArrayList<>();
        List<String> list = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String s;
            while ((s = reader.readLine()) != null) {
                String[] str = s.split(" ");
                for (String value : str) list.add(value.toLowerCase());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        Thread evenT = new Thread(() -> list.forEach((x) -> {
            long k = x.chars().asLongStream()
                    .distinct().count();
            if (k % 2 == 0) {
                evenList.add(x);
                System.out.println(Thread.currentThread().getName() + " added word " + x + " to even list");
            }
        }));

        Thread oddT = new Thread(() -> list.forEach((x) -> {
            long k = x.chars().asLongStream()
                    .distinct().count();
            if (k % 2 != 0) {
                oddList.add(x);
                System.out.println(Thread.currentThread().getName() + " added word " + x + " to odd list");
            }
        }));

        evenT.start();
        oddT.start();

        evenT.join();
        oddT.join();


        System.out.println("\n" + evenList + "\n");
        System.out.println(oddList);
    }
}
