package Stacks_and_Queues;/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class StackLLAPI<T> implements Iterable<T> {
    private Node first;

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

    public void push(T value) {
        Node node = new Node();
        node.item = value;
        node.next = first;
        first = node;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public T pop() {
        if (first != null) {
            T value = first.item;
            first = first.next;
            return value;
        }
        return null;
    }

    public static void main(String[] args) {
        StackLLAPI<Integer> stack = new StackLLAPI<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        for (int num : stack) StdOut.println(num);
    }
}
