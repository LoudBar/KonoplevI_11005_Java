package task1;

import java.io.*;

public class Executor implements Runnable {

    int action;

    public Executor(String a) {
        if (a.equals("writer")) action = 1;
        if (a.equals("reader")) action = 2;
    }

    public void serialize(PersonRand p) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Persons.txt")))
        {
            oos.writeObject(p.random());
            System.out.println("Serialization complete");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deserialize() {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Persons.txt")))
        {
            Person p = (Person)ois.readObject();
            System.out.println("Name: " + p.getName() + ", age: " + p.getAge() + ", country: " + p.getCountry());
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void run() {
        if (action == 1) serialize(new PersonRand());
        if (action == 2) deserialize();
    }
}
