package IterableStack;

import java.util.Iterator;

public class Stack<T> implements Iterable<T> {

    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }


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

    class StackIterator implements Iterator<T> {

        Node<T> tempHead = head;

        @Override
        public boolean hasNext() {
            return tempHead != null;
        }

        @Override
        public T next() {
            T temp = tempHead.value;
            tempHead = tempHead.next;
            return temp;
        }
    }
}