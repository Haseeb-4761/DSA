package Arrays.UnionFind;

class SuccessorWithDeleteUF {
    private int[] parent;

    public SuccessorWithDeleteUF(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    private int find(int p) {
        if (p != parent[p]) {
            parent[p] = find(parent[p]);
        }
        return parent[p];
    }

    private void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        if (rootP != rootQ) {
            parent[rootP] = rootQ;
        }
    }

    public void remove(int p) {
        if (p + 1 < parent.length) {
            union(p, p + 1);
        }
    }

    public int getSuccessor(int p) {
        return parent[find(p)];
    }

    public static void main(String[] args) {
        int n = 10; // Example: S = {0, 1, ..., 9}
        SuccessorWithDeleteUF swd = new SuccessorWithDeleteUF(n);

        swd.remove(2);
        swd.remove(3);
        swd.remove(8);

        System.out.println(swd.getSuccessor(2)); // Output: 4
        System.out.println(swd.getSuccessor(3)); // Output: 4
        System.out.println(swd.getSuccessor(7)); // Output: 1
    }
}
