import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static String[] str(String path) throws IOException {

        String[] s = new String[10000];

        FileReader fr = new FileReader(path);
        Scanner scanner = new Scanner(fr);

        int i = 0;

        while (scanner.hasNextLine()) {
            s[i] = scanner.nextLine();
            i++;
        }
        fr.close();

        return s;
    }

    public static void task1(String path) throws IOException {

        String[] s = str(path);

        var r = Arrays.stream(s).collect(Collectors.toMap(
                str1 -> str1.substring(0, str1.indexOf('|')),
                str1 -> str1.substring(str1.indexOf('|') + 1
        )));
    }

    public static void task2(String path) throws IOException {

        String[] s = str(path);

        var r = Arrays.stream(s).collect(Collectors.toMap(
                str1 -> str1.substring(0, str1.indexOf('|')),
                str1 -> Integer.parseInt(str1.substring(str1.indexOf('|') + 1)),
                (x, y) -> x = x + y)).entrySet().stream().sorted(Comparator.comparingInt(
                x -> x.
            ));

        System.out.println(r);
    }

    public static void task3(String path) throws IOException {

        String[] s = str(path);
    }

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            try {
                task1("task1.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                task2("task2.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        Thread t3 = new Thread(() -> {
            try {
                task3("task1.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        Scanner in = new Scanner(System.in);

        while (true) {

            int a = in.nextInt();

            if (a == 0) return;
            if (a == 1) { t1.start(); t1.join(); }
            if (a == 2) { t2.start(); t2.join(); }
            if (a == 3) { t3.start(); t3.join(); }
        }
    }
}
