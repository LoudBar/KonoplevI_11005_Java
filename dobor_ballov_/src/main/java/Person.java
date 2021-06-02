public class Person implements Printable, Comparable<Person> {

    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public void print() {
        System.out.println("My name is " + name);
    }

    @Override
    public int compareTo(Person p) {
        return name.compareTo(p.getName());
    }
}
