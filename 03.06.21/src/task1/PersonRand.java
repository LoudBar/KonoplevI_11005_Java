package task1;

import java.util.Random;
public class PersonRand {

    public Person random() {

        String name = "";
        int age;
        Countries country;
        Random rand = new Random();
        Countries[] countries = Countries.values();

        for (int i = 0; i < 15; i++) name += ((char) rand.nextInt(100));
        age = rand.nextInt(100);
        country = countries[rand.nextInt(countries.length)];

        return new Person(name, age, country);
    }
}
