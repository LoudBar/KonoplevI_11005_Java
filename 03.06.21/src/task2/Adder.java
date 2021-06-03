package task2;

import java.util.Random;
import java.util.concurrent.Callable;

public class Adder implements Callable<String> {

    @Override
    public String call() throws Exception {

        StringBuilder s = new StringBuilder();
        String eng = "abcdefghijklmnopqrstuvwxyz";
        String rus = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        Random rand = new Random();
        int a = (int)(Math.random()*3);

        if (a == 1)
            for (int i = 0; i < rand.nextInt(6) + 1; i++) s.append(getRandomSymbol(eng));
            else
            for (int i = 0; i < rand.nextInt(6) + 1; i++) s.append(getRandomSymbol(rus));

        return s.toString();
    }

    public char getRandomSymbol(String str) {
        int l = (int)(Math.random()*str.length());
        return str.charAt(l);
    }
}
