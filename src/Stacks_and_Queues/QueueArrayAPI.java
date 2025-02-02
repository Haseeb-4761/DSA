package Stacks_and_Queues;/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class QueueArrayAPI<T> implements Iterable<T> {
    private T[] queue;
    private int first;
    private int last;
    private int qSize;

    public QueueArrayAPI() {
        queue = (T[]) new Object[1];
        first = 0;
        last = 0;
        qSize = 0;
    }

    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T> {
        private int i = first;
        private int j = qSize;

        public boolean hasNext() {
            return j > 0;
        }

        public T next() {
            if (i == queue.length) i = 0;
            j--;
            return queue[i++];
        }
    }

    private void resize(int length) {
        T[] copy = (T[]) new Object[length];
        int i = 0;
        while (first != last) {
            copy[i++] = queue[first++];
            if (last != queue.length && first == queue.length) first = 0;
        }
        first = 0;
        last = i;
        queue = copy;
    }

    public void enqueue(T value) {
        if (qSize == queue.length) resize(2 * queue.length);
        else if (last == queue.length) last = 0;
        queue[last++] = value;
        qSize++;
    }

    public T dequeue() {
        if (isEmpty()) return null;
        if (first == queue.length) first = 0;
        T item = queue[first];
        queue[first++] = null;
        qSize--;
        if (qSize == queue.length / 4) resize(queue.length / 2);
        return item;
    }

    public boolean isEmpty() {
        return qSize == 0;
    }

    public int length() {
        return qSize;
    }

    public static void main(String[] args) {
        QueueArrayAPI<Integer> queue = new QueueArrayAPI<Integer>();
        queue.enqueue(2);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);
        queue.enqueue(9);
        queue.enqueue(10);
        queue.enqueue(11);
        for (int num : queue) StdOut.println(num);
    }
}
