package Stacks_and_Queues;/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;

import java.util.NoSuchElementException;

public class Dequeue<T> {
    private StackArrayAPI<T> first;
    private StackArrayAPI<T> second;

    public Dequeue() {
        this.first = new StackArrayAPI<T>();
        this.second = new StackArrayAPI<T>();
    }

    public boolean isEmpty() {
        return first.isEmpty() && second.isEmpty();
    }

    private int size() {
        return (first.size() + second.size());
    }

    public void addFirst(T value) {
        if (value == null) throw new IllegalArgumentException("Invalid Arguement");
        first.push(value);
    }

    public void addLast(T value) {
        if (value == null) throw new IllegalArgumentException("Invalid Arguement");
        second.push(value);
    }

    public T removeFirst() {
        if (isEmpty()) throw new NoSuchElementException("Empty deck");
        if (first.isEmpty()) {
            while (!second.isEmpty()) first.push(second.pop());
        }
        if (!first.isEmpty()) return first.pop();
        else return null;
    }

    public T removeLast() {
        if (isEmpty()) throw new NoSuchElementException("Empty deck");
        if (second.isEmpty()) {
            while (!first.isEmpty()) second.push(first.pop());
        }
        if (second.isEmpty()) return second.pop();
        else return null;
    }

    public static void main(String[] args) {
        Dequeue<Integer> deck = new Dequeue<Integer>();
        deck.addFirst(1);
        deck.addFirst(2);
        deck.addLast(3);
        deck.addLast(4);
        deck.addFirst(5);
        StdOut.println(deck.removeFirst());
        StdOut.println(deck.removeFirst());
        StdOut.println(deck.removeFirst());
        StdOut.println(deck.removeFirst());
        StdOut.println(deck.removeFirst());
    }
}
