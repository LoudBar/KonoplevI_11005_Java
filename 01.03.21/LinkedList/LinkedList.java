package LinkedList;

public class LinkedList<T> {

    private static class Node<T> {

        private T item;
        private Node<T> next;
    }

    private Node<T> root;

    void add (T item) {

        Node<T> node = new Node<T>();
        node.item = item;
        if (root == null)
            root = node;
        else
        {
            Node<T> temp = root;

            while (temp.next != null) {

                temp = temp.next;
            }
            temp.next = node;
        }
    }

    int count() {

        int i = 0;
        Node<T> temp = root;
        if (root == null)
            throw new NullPointerException("The list is empty");
        else {
            while (temp.next != null) {

                temp = temp.next;
                i++;
            }
        }
        return i + 1;
    }

    T get(int id) {

        int i = 0;
        Node<T> temp = root;
        if (root == null)
            throw new NullPointerException("The list is empty");
        else {
            while (i != id){
                if (temp.next != null) {

                    temp = temp.next;
                    i++;
                 }
                else throw new NullPointerException("incorrect id");
            }
        }
        return temp.item;
    }

    void remove(int id) {

        if (root == null)
            throw new NullPointerException("The list is empty");

        Node<T> tmp;
        Node<T> prev = root;
        int i = 0;

        while ( i != id -1){
            prev = root.next;
            i++;
        }

        if (prev.next == null)
            throw new NullPointerException("No element with that id");
        
        tmp = prev.next;
        prev.next = tmp.next;
    }
}
