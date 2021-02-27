package IterableLinkedList;

public class Main {

    public static void main(String[] args) {

        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(3);
        list.add(9);
        list.add(2);
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println();
        list.remove(1);
        System.out.println(list.count());
        System.out.println();
        System.out.println(list.get(1));
        System.out.println();

        for (Integer elem : list) {

            System.out.println(elem);
        }

    }
}
