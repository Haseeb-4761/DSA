package Stacks_and_Queues;/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueueAPI<T> implements Iterable<T> {
    private Object[] queue;
    private int nthItem;
    private int size;

    RandomizedQueueAPI() {
        queue = (T[]) new Object[1];
        nthItem = 0;
        size = 0;
    }

    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T> {
        private Object[] copy;
        private int i;

        ListIterator() {
            copy = (T[]) new Object[nthItem];
            for (int j = 0; j < nthItem; j++) {
                copy[j] = queue[j];
            }
            i = 0;
            StdRandom.shuffle(copy);
        }

        public boolean hasNext() {
            return i < nthItem;
        }

        public T next() {
            return (T) copy[i++];
        }
    }

    private void resize(int n) {
        Object[] copy = (T[]) new Object[n];
        int j = 0;
        for (int i = 0; i < nthItem; i++) {
            if (queue[i] != null) copy[j++] = queue[i];
        }
        queue = copy;
        nthItem = j;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void enqueue(T value) {
        if (value == null) throw new IllegalArgumentException("Invalid Arguement");
        if (nthItem == queue.length) resize(2 * queue.length);
        queue[nthItem++] = value;
        size++;
    }

    public T dequeue() {
        if (size == 0) throw new NoSuchElementException("No element exist");
        int randIndex;
        do {
            randIndex = StdRandom.uniformInt(nthItem);
        } while (queue[randIndex] == null);
        T value = (T) queue[randIndex];
        queue[randIndex] = null;
        size--;
        if (size == queue.length / 4) resize(queue.length / 2);
        return value;
    }

    public T sample() {
        int randIndex;
        do {
            randIndex = StdRandom.uniformInt(nthItem);
        } while (queue[randIndex] == null);
        return (T) queue[randIndex];
    }


    public static void main(String[] args) {
        RandomizedQueueAPI<Integer> queue = new RandomizedQueueAPI<Integer>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);
        queue.enqueue(8);
        queue.enqueue(9);
        for (int num : queue) StdOut.print(num + " ");
    }
}
