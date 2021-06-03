package Task3;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Main {

    final static Scanner in = new Scanner(System.in);
    static int n;
    static String answer = "";

    static volatile int l = 2;
    static AtomicInteger left = new AtomicInteger(0);
    static AtomicInteger right = new AtomicInteger(10);

    public static String primeNumbers(AtomicInteger start, AtomicInteger end) {

        ArrayList<Integer> arr = new ArrayList<>();


        for (int j = start.intValue(); j < end.intValue(); j++) {
            int finalJ = j;
            boolean ans = IntStream.rangeClosed(2, j / 2).anyMatch(x -> finalJ % x == 0);
            if (!ans) arr.add(j);
        }

        return arr.toString();
    }

    public static void main(String[] args) throws InterruptedException {

        n = in.nextInt();
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        while (left.get() <= n) {
            executorService.submit(()-> {
                answer = primeNumbers(left,right);
                left.set(right.get() + 1);
                right.set(right.get() + 10);
                System.out.println(Thread.currentThread().getName() + " is " + answer);
                return answer;
            });
            Thread.sleep(1500);
        }
        executorService.shutdown();
    }
}
