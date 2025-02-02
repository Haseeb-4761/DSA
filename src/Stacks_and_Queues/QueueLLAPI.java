package Stacks_and_Queues;/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */


import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class QueueLLAPI<T> implements Iterable<T> {
    private Node first;
    private Node last;

    private class Node {
        private T item;
        private Node next;
    }

    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public T next() {
            T item = current.item;
            current = current.next;
            return item;
        }
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void enqeue(T value) {
        if (isEmpty()) {
            first = new Node();
            first.item = value;
            last = first;
        }
        else {
            Node temp = new Node();
            temp.item = value;
            last.next = temp;
            last = temp;
        }
    }

    public T dequeue() {
        if (!isEmpty()) {
            T item = first.item;
            if (isEmpty()) last = null;
            first = first.next;
            return item;
        }
        return null;
    }

    public static void main(String[] args) {
        QueueLLAPI<String> queue = new QueueLLAPI<String>();
        queue.enqeue("Assalam U Alaikum");
        queue.enqeue("Muhammad Haseeb");
        for (String s : queue) StdOut.println(s);
    }
}
