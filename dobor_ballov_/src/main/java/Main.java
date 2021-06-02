import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Main {

    public static void printArr(ArrayList<Person> a) {
        for (Person person : a)
            System.out.println("Name: " + person.getName()
                    + ", Age: " + person.getAge());
    }

    public static class CRUDHolder<T extends Comparable<T> & Printable> {

        private ArrayList<T> items;

        public CRUDHolder(ArrayList<T> items) {
            this.items = items;
        }

        public void create(T item) throws IllegalArgumentException {
            for (T t : items)
                if (item.compareTo(t) == 0) throw new IllegalArgumentException("Такой элемент уже существует");
            items.add(item);
        }

        public T read(int id) throws NoSuchElementException {
            if (id > items.size() - 1 || id < 0) throw new NoSuchElementException("Элемент отсутствует");
            return items.get(id);
        }

        public void update(T item) throws NoSuchElementException {
            boolean u = false;
            for (int i = 0; i < items.size(); i++)
                if (item.compareTo(items.get(i)) == 0) { u = true; items.set(i, item); }
            if (!u) throw new NoSuchElementException("Такого элемента не существует");
        }

        public void delete(T item) throws NoSuchElementException {
            if (!items.contains(item)) throw new NoSuchElementException("Такого элемента не существует");
            items.remove(item);
        }

    }

    public static void main(String[] args) {

        ArrayList<Person> a = new ArrayList<>();
        CRUDHolder<Person> b = new CRUDHolder<>(a);

        b.create(new Person("ABOBA", 10));
        Person c = b.read(0);
        Person d = new Person("ABOBA", 12);
        b.update(d);
        b.delete(d);

        printArr(a);
    }
}
