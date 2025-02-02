package Arrays.UnionFind;/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;

public class Percolation {
    private boolean[] grid;
    private int[] parent;
    private int[] rank;
    private int openSites;
    private int n;

    public Percolation(int n) {

        if (n <= 0) throw new IllegalArgumentException("Grid size should be greater than 0");

        this.n = n;
        int size = (n * n) + 2; // +2 for top and bottom virtual nodes
        this.grid = new boolean[n * n];
        this.parent = new int[size];
        this.rank = new int[size];
        this.openSites = 0;

        for (int i = 0; i < size; i++) {
            parent[i] = i;   // Initially each element is parent of itself
            rank[i] = 0;
        }

        // The grid is stored in 1D array of size = (n * n) + 2
        // where index n * n and (n * n) + 1 are for top and bottom nodes

        int topNodeIndex = n * n;

        for (int i = 0; i < n; i++) {
            union(topNodeIndex, i);  // connect top row to top virtual node
        }

        int bottomNodeIndex = (n * n) + 1;

        for (int i = topNodeIndex - n; i < topNodeIndex; i++) {
            union(bottomNodeIndex, i);  // connect bottom row to bottom virtual node
        }
    }

    private int find(int p) {
        if (p < 0 || p > (n*n)+1) {
            throw new IllegalArgumentException(
                    "row and column index must be greater than 0 and less than " +  (n+1));
        }
        if (p != parent[p]) {
            parent[p] = find(parent[p]);
        }
        return parent[p];
    }

    private void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        if (rootP != rootQ) {
            if (rank[rootP] > rank[rootQ]) {
                parent[rootQ] = rootP;
            }
            else if (rank[rootP] < rank[rootQ]) {
                parent[rootP] = rootQ;
            }
            else {
                parent[rootQ] = rootP;
                rank[rootP]++;
            }
        }
    }

    public boolean isOpen(int row, int col) {
        if (row <= 0 || row > n || col <= 0 || col > n) {
            throw new IllegalArgumentException(
                    "row and column index must be greater than 0 and less than " +  (n+1));
        }
        return grid[((row-1) * n) + (col-1)];
    }

    public void open(int row, int col) {
        if (!isOpen(row, col)) {
            int index = ((row-1) * n) + (col-1);
            grid[index] = true;
            openSites++;
            if (col-1 > 0 && grid[index - 1]) union(index - 1, index);
            if (col < n && grid[index + 1]) union(index + 1, index);
            if (row-1 > 0 && grid[index - n]) union(index - n, index);
            if (row < n && grid[index + n]) union(index + n, index);
        }
    }

    public boolean isFull(int row, int col) {
        return find(n * n) == find(((row-1) * n) + col-1);
    }

    public int numberOfOpenSites() {
        return openSites;
    }

    public boolean percolates() {
        return find(n * n) == find((n * n) + 1);
    }

    public static void main(String[] args) {
        Percolation grid = new Percolation(10);
        grid.open(1,1);
        StdOut.println(grid.isOpen(1,1));
    }
}
