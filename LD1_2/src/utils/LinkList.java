package utils;

import java.util.Iterator;

public class LinkList<T> implements List<T> {

    private class Node {
        public T data;
        public Node next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    public LinkList() { head = null; }

    @Override
    public void add(T item) {
        if (head == null) {
            head = new Node(item);
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = new Node(item);
    }

    public int size() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    @Override
    public T get(int index) {
        Node current = head;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.data;
    }

    @Override
    public boolean remove(T item) {
        if (head.data == item) {
            head = head.next;
            return true;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.data == item) {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }

        return false;
    }

    public void sort() {
        for (Node d1 = head; d1 != null; d1 = d1.next) {
            Node min = d1;
            for (Node d2 = d1.next; d2 != null; d2 = d2.next) {
                Comparable<T> c2 = (Comparable<T>) d2.data;
                if (c2.compareTo(min.data) < 0) {
                    min = d2;
                }
            }

            if (min != d1) {
                T temp = d1.data;
                d1.data = min.data;
                min.data = temp;
            }
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }
}
