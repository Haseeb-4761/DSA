package Arrays.UnionFind;/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;

public class SocialNetworkConnectivity {
    private int[] parent;
    private int[] rank;
    private int connectionCount;

    public SocialNetworkConnectivity(int n) {
        parent = new int[n];
        rank = new int[n];
        connectionCount = n;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    private int find(int p) {
        if (parent[p] != p) {
            parent[p] = find(parent[p]);
            p = parent[p];
        }
        return p;
    }

    public int union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        if (rootP != rootQ) {
            if (rank[rootP] > rank[rootQ]) parent[rootQ] = rootP;
            else if (rank[rootP] < rank[rootQ]) parent[rootP] = rootQ;
            else {
                parent[rootQ] = rootP;
                rank[rootP]++;
            }
            connectionCount--;
        }
        return connectionCount;
    }

    public static void main(String[] args) {
        SocialNetworkConnectivity uf = new SocialNetworkConnectivity(5);
        int[][] logs = {
                { 20190101, 0, 1 },
                { 20190102, 1, 2 },
                { 20190103, 2, 3 },
                { 20190104, 3, 4 }
        };
        for (int[] log : logs) {
            if (uf.union(log[1], log[2]) == 1) {
                StdOut.println("Earliest time at which all members get connected " + log[0]);
                break;
            }
        }
    }
}
