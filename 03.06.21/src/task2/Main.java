package task2;

import java.security.InvalidParameterException;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws Exception {

        StringBuilder s = new StringBuilder();
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();

        if (x < 0) throw new InvalidParameterException("Вы ввели отрицательное число!");

        ScheduledExecutorService executor = new ScheduledThreadPoolExecutor(4);

        for (int i = 0; i < x; i++) {
            try {
                Future<String> schedule = executor.schedule(new Adder(), 3000, TimeUnit.MILLISECONDS);
                String str = schedule.get(10000, TimeUnit.MILLISECONDS);
                s.append(str);
                System.out.println("Some symbols have been added, current string: " + s);
            }
            catch (InterruptedException | ExecutionException | TimeoutException e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();
    }
}
