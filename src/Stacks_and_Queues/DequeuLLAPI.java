package Stacks_and_Queues;/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DequeuLLAPI<T> implements Iterable<T> {
    private Node first;
    private Node last;
    private int N;

    private class Node {
        T value;
        Node next;
        Node prev;

        Node(T value) {
            this.value = value;
        }
    }

    public DequeuLLAPI() {
        N = 0;
    }

    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T> {
        private Node current = first;

        public boolean hasNext() {
            if (current != null) return true;
            return false;
        }

        public void remove() {
            throw new UnsupportedOperationException("Not supported");
        }

        public T next() {
            if (!hasNext()) throw new NoSuchElementException("No element");
            T value = current.value;
            current = current.next;
            return value;
        }
    }

    public void addFirst(T value) {
        if (value == null) throw new IllegalArgumentException("Invalid Arguement");
        Node newNode = new Node(value);
        if (isEmpty()) {
            first = last = newNode;
        }
        else {
            newNode.next = first;
            first.prev = newNode;
            first = newNode;
        }
        N++;
    }

    public void addLast(T value) {
        if (value == null) throw new IllegalArgumentException("Invalid Arguement");
        Node newNode = new Node(value);
        if (isEmpty()) {
            first = last = newNode;
        }
        else {
            last.next = newNode;
            newNode.prev = last;
            last = newNode;
        }
        N++;
    }

    public T removeFirst() {
        if (isEmpty()) throw new NoSuchElementException("No element exists");
        T value = first.value;
        first = first.next;
        if (first != null) first.prev = null;
        else last = null;
        N--;
        return value;
    }

    public T removeLast() {
        if (last == null) throw new NoSuchElementException("No element exists");
        T value = last.value;
        last = last.prev;
        if (last != null) last.next = null;
        else first = null;
        N--;
        return value;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public static void main(String[] args) {
        DequeuLLAPI<Integer> deck = new DequeuLLAPI<Integer>();
        deck.addFirst(1);
        deck.addFirst(2);
        deck.addLast(7);
        deck.addLast(8);
        deck.addLast(6);
        StdOut.println(deck.size());
        StdOut.println(deck.removeFirst());
        StdOut.println(deck.removeFirst());
        StdOut.println(deck.removeFirst());
        StdOut.println(deck.removeFirst());
        StdOut.println(deck.removeFirst());
        StdOut.println(deck.removeFirst());
    }
}
