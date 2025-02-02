package Stacks_and_Queues;/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

// Worst Case Time Complexity O(N^2)

public class RandomizedQueueLL<T> implements Iterable<T> {
    private Node head;
    private Node randNode;
    private int size;

    private class Node {
        private T value;
        private Node next;

        private Node(T value) {
            this.value = value;
        }
    }

    RandomizedQueueLL() {
        size = 0;
    }

    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T> {
        private Node temp;

        ListIterator() {
            this.temp = head;
        }


        public boolean hasNext() {
            return temp != null;
        }

        public T next() {
            T value = temp.value;
            temp = temp.next;
            return value;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void enqueue(T value) {
        Node newNode = new Node(value);

        if (isEmpty()) head = newNode;

        else {
            int random = StdRandom.uniformInt(size);
            Node current = head;
            for (int i = 0; i < random; i++) current = current.next;
            if (current == head) {
                newNode.next = head;
                head = newNode;
            }
            else {
                newNode.next = current.next;
                current.next = newNode;
            }
            randNode = head;
        }
        size++;
    }

    public T dequeue() {
        if (isEmpty()) throw new NoSuchElementException("No element present");
        T value = head.value;
        head = head.next;
        return value;
    }

    public T sample() {
        if (isEmpty()) throw new NoSuchElementException("No element present");
        if (randNode == null) randNode = head;
        T value = randNode.value;
        randNode = randNode.next;
        return value;
    }

    public static void main(String[] args) {
        RandomizedQueueLL<String> queue = new RandomizedQueueLL<String>();
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        queue.enqueue("D");
        queue.enqueue("E");
        queue.enqueue("F");
        queue.enqueue("G");
        queue.enqueue("H");
        queue.enqueue("I");
        for (String str : queue) StdOut.print(str + " ");
        StdOut.println();
        for (int i = 0; i < queue.size(); i++) StdOut.print(queue.sample() + " ");
    }
}
