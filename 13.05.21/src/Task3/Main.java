package Task3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.FileReader;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws Exception {

        String[] s = new String[100];

        FileReader fr = new FileReader("task3.txt");
        Scanner scanner = new Scanner(fr);

        int i = 0;

        while (scanner.hasNextLine()) {
            s[i] = scanner.nextLine();
            i++;
        }
        fr.close();

        Map<String, Integer> map = Arrays.stream(s).collect(Collectors.toMap(
                str1 -> str1.substring(0, str1.indexOf('|')),
                str1 -> Integer.parseInt(str1.substring(str1.indexOf('|') + 1)),
                (x, y) -> x = x + y));
        System.out.println(map);
    }
}
