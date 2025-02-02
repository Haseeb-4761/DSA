/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package Stacks_and_Queues;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Permutation {
    public static void main(String[] args) {
        RandomizedQueueLL<String> queue = new RandomizedQueueLL<>();
        if (args[0].length() != 1) StdOut.println("Enter single Integer");
        int k = Integer.parseInt(args[0]);
        while (!StdIn.isEmpty()) queue.enqueue(StdIn.readString());
        for (int i = 0; i < k; i++) {
            StdOut.println(queue.dequeue());
        }
    }
}
