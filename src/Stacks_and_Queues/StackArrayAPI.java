package Stacks_and_Queues;/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class StackArrayAPI<T> implements Iterable<T> {
    private T[] stack;
    private int N;   // Pointer to track the next empty index

    public StackArrayAPI() {
        stack = (T[]) new Object[1];
        N = 0;
    }

    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T> {
        private int i = N;

        public boolean hasNext() {
            return i > 0;
        }

        public T next() {
            return stack[--i];
        }
    }

    private void resize(int size) {
        T[] copy = (T[]) new Object[size];
        for (int i = 0; i < N; i++) {
            copy[i] = stack[i];
        }
        stack = copy;
    }

    public void push(T value) {
        if (N == stack.length) resize(2 * stack.length);
        stack[N++] = value;
    }

    public T pop() {
        if (N == 0) return null;
        T item = stack[--N];
        stack[N] = null;
        if (N > 0 && N == stack.length / 4) resize(stack.length / 2);
        return item;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }


    public static void main(String[] args) {
        StackArrayAPI<String> stack = new StackArrayAPI<String>();
        stack.push("Muhammad Haseeb Nawaz");
        stack.push("Assalam u Alaikum");
        stack.push("COMSATS");
        stack.push("Student");
        StdOut.println(stack.pop());
        StdOut.println(stack.pop());
        StdOut.println(stack.pop());
        StdOut.println(stack.pop());
        for (String s : stack) StdOut.println(s);
    }
}
