package Store;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Map<String, Map<String, Integer>> map = new HashMap<>();

        String[] str = {"Dina pen 2", "Ilya pencil 6", "Ilya pen 3", "Dina pen 1", "Dina pencil 2"};

        for (String item : str) {
            String[] s = item.split(" ");
            Map<String, Integer> tmp = new HashMap<>();
            if (map.containsKey(s[0])) {
                if (map.get(s[0]).containsKey(s[1])) {
                    int value = map.get(s[0]).get(s[1]);
                    tmp = map.get(s[0]);
                    tmp.put(s[1], Integer.parseInt(s[2]) + value);
                } else {
                    tmp = map.get(s[0]);
                    tmp.put(s[1], Integer.parseInt(s[2]));
                }
            } else {

                tmp.put(s[1], Integer.parseInt(s[2]));
            }
            map.put(s[0], tmp);
        }
        for (Map.Entry<String, Map<String, Integer>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
