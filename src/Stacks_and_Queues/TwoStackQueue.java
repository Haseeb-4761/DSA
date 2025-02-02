package Stacks_and_Queues;/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;

public class TwoStackQueue<T> {
    private StackArrayAPI<T> inbox;
    private StackArrayAPI<T> outbox;

    public TwoStackQueue() {
        this.inbox = new StackArrayAPI<T>();
        this.outbox = new StackArrayAPI<T>();
    }

    public void enqueue(T value) {
        inbox.push(value);
    }

    public T dequeue() {
        if (outbox.isEmpty()) {
            while (!inbox.isEmpty()) {
                outbox.push(inbox.pop());
            }
        }
        if (!outbox.isEmpty()) return outbox.pop();
        else return null;
    }

    public boolean isEmpty() {
        return inbox.isEmpty() && outbox.isEmpty();
    }

    public int size() {
        if (!inbox.isEmpty()) return inbox.size();
        else if (!outbox.isEmpty()) return outbox.size();
        else return 0;
    }

    public static void main(String[] args) {
        TwoStackQueue<Integer> queue = new TwoStackQueue<Integer>();
        StdOut.println(queue.isEmpty());
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        StdOut.println(queue.dequeue());
        StdOut.println(queue.dequeue());
        StdOut.println(queue.isEmpty());
    }
}
