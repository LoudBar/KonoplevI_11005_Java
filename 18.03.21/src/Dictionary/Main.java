package Dictionary;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<String, Integer>();
        String s = "He/{llo hello aa)a H)(ello aaa bbb b";
        s = s.toLowerCase(Locale.ROOT);
        s = s.replaceAll("\\p{P}", "");
        String[] str = s.split(" ");

        for (int i = 0; i < str.length; i++) {

            if (map.containsKey(str[i])) {
                int k = map.get(str[i]) + 1;
                map.put(str[i], k);
            }
            else map.put(str[i], 1);
        }
        for (Map.Entry<String, Integer> item : map.entrySet()) {
            System.out.printf("Key: %s  Value: %s \n", item.getKey(), item.getValue());
        }
    }
}
