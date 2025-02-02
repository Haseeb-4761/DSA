package Arrays.UnionFind;/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private final double[] thresholdValues;
    private final int trials;
    private final double mean;

    public PercolationStats(int n, int trials) {
        thresholdValues = new double[trials];
        this.trials = trials;
        for (int i = 0; i < trials; i++) {
            Percolation sites = new Percolation(n);
            while (!sites.percolates()) {
                sites.open(StdRandom.uniformInt(1,n+1), StdRandom.uniformInt(1,n+1));
            }
            thresholdValues[i] = (double) sites.numberOfOpenSites() / (n * n);
        }
        this.mean = StdStats.mean(thresholdValues);
//        double totalThreshold = 0;
//        for (double thresholdValue : thresholdValues) {
//            totalThreshold += thresholdValue;
//        }
//        this.mean = totalThreshold / trials;
    }

    public double mean() {
        return this.mean;
    }

    public double stddev() {
//        double sumOfSquareDeviation = 0.0;
//        for (double thresholdValue : thresholdValues) {
//            sumOfSquareDeviation += Math.pow((thresholdValue - this.mean), 2);
//        }
//        return sumOfSquareDeviation / (trials - 1);
        return StdStats.stddev(thresholdValues);
    }

    public double confidenceLo() {
        return (this.mean - (1.96 / Math.sqrt(this.trials)));
    }

    public double confidenceHi() {
        return (this.mean + (1.96 / Math.sqrt(this.trials)));
    }

    public static void main(String[] args) {
        int n = StdIn.readInt();
        int trials = StdIn.readInt();
        PercolationStats percolationStats = new PercolationStats(n, trials);
        StdOut.println("Mean: " + percolationStats.mean());
        StdOut.println("Standard Deviation " + percolationStats.stddev());
    }
}
