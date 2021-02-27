package LinkedList;

public class Main {

    public static void main(String[] args) throws Exception {


        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(4);
        list.add(5);
        list.add(7);
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println();
        list.remove(1);
        System.out.println(list.count());
        System.out.println();
        System.out.println(list.get(1));

    }
}
