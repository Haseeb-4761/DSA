package Arrays.UnionFind;

public class UnionFindWithLargest {
    private int[] parent;       // Parent array
    private int[] rank;         // Rank array for union by rank
    private int[] maxElement;   // Array to store the largest element in each component

    // Constructor
    public UnionFindWithLargest(int n) {
        parent = new int[n];
        rank = new int[n];
        maxElement = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;      // Each element is its own parent initially
            maxElement[i] = i;  // Initially, the largest element is the element itself
        }
    }

    // Find with path compression
    public int find(int p) {
        if (parent[p] != p) {
            parent[p] = find(parent[p]); // Path compression
        }
        return parent[p];
    }

    // Union with union by rank and updating maxElement
    public void union(int p, int q) {
        int rootP = find(p); // Find the root of p
        int rootQ = find(q);  // Find the root of q

        if (rootP != rootQ) {
            if (rank[rootP] > rank[rootQ]) {
                parent[rootQ] = rootP;
                maxElement[rootP] = Math.max(maxElement[rootP], maxElement[rootQ]);
            } else if (rank[rootP] < rank[rootQ]) {
                parent[rootP] = rootQ;
                maxElement[rootQ] = Math.max(maxElement[rootP], maxElement[rootQ]);
            } else {
                parent[rootQ] = rootP;
                maxElement[rootP] = Math.max(maxElement[rootP], maxElement[rootQ]);
                rank[rootP]++;
            }
        }
    }

    // Check if two elements are in the same component
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    // Find the largest element in the connected component containing p
    public int findLargest(int p) {
        int rootP = find(p);
        return maxElement[rootP];
    }

    // Main method for demonstration
    public static void main(String[] args) {
        UnionFindWithLargest uf = new UnionFindWithLargest(10);

        uf.union(1, 2);
        uf.union(2, 6);
        uf.union(6, 9);

        System.out.println(uf.findLargest(1)); // Output: 9
        System.out.println(uf.findLargest(2)); // Output: 9
        System.out.println(uf.findLargest(9)); // Output: 9

        uf.union(3, 4);
        uf.union(4, 5);

        System.out.println(uf.findLargest(3)); // Output: 5
        System.out.println(uf.findLargest(4)); // Output: 5
    }
}
