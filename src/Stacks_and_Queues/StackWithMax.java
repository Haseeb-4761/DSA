package Stacks_and_Queues;/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;

public class StackWithMax {
    private StackLLAPI<Double> stack;
    private double Max;

    public StackWithMax() {
        this.stack = new StackLLAPI<Double>();
    }

    public void push(double value) {
        if (Max == 0.0 || Max < value) Max = value;
        stack.push(value);
    }

    public double pop() {
        return stack.pop();
    }

    public double max() {
        return Max;
    }

    public static void main(String[] args) {
        StackWithMax stack = new StackWithMax();
        stack.push(3.4);
        stack.push(1.0);
        stack.push(4.5);
        stack.push(5);
        StdOut.println(stack.max());
    }
}
