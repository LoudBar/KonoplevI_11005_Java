package Stack;

public class Stack<T> {

    static class Node<T> {

        private T value;
        private Node<T> next;

    }

    private Node<T> head;

    public void push(T value) {

        Node<T> t = new Node<>();
        t.value = value;
        t.next = head;
        head = t;
    }

    public T pop() {
        if (head == null)
            throw new NullPointerException("Create an object please");

        T value = head.value;
        head = head.next;

        return value;
    }

    public T peek() {

        if (head == null)
            throw new NullPointerException("Create an object please");

        return head.value;
    }
}
