package task1;

import java.util.Scanner;

public class Main {

    public static volatile long factorial = 1;
    public static int n;

    public static long factorial(int n, int c) {

        if (c == 1) for (int i = 1; i < n / 4 + 1; i++) factorial *= i;
        if (c == 2) for (int i = n / 4 + 1; i < n / 2 + 1; i++) factorial *= i;
        if (c == 3) for (int i = n / 2 + 1; i < 3 * n / 4 + 1; i++) factorial *= i;
        if (c == 4) for (int i = 3 * n / 4 + 1; i < n + 1; i++) factorial *= i;
        return factorial;
    }

    public static void main(String[] args) throws Exception {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " is running, ");
            System.out.println(Thread.currentThread().getName() + " done work with " + factorial(n, 1));
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " is running, ");
            System.out.println(Thread.currentThread().getName() + " done work with " + factorial(n, 2));
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t3 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " is running, ");
            System.out.println(Thread.currentThread().getName() + " done work with " + factorial(n, 3));
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t4 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " is running, ");
            System.out.println(Thread.currentThread().getName() + " done work with " + factorial(n, 4));
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();

        System.out.println("\nFactorial of " + n + " is: " + factorial);
    }
}
