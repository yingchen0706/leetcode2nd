class Solution {
    class UnionFind {
        private int roots[];
        public UnionFind(int roots[]) {
            this.roots = roots;
        }
        public int findRoot(int index) {
            while (roots[index] != index) {
                index = roots[index];
            }
            return index;
        }
        public boolean union(int index1, int index2) {
            int p1 = findRoot(index1);
            int p2 = findRoot(index2);
            roots[p1] = p2;
            return p1 != p2;
        }
        public boolean isUnion(int index1, int index2) {
            int p1 = findRoot(index1);
            int p2 = findRoot(index2);
            return p1 == p2;
        }
    }
    public int numIslands(char[][] grid) {
        int m = grid.length;
        if (m == 0) {
            return 0;
        }
        int n = grid[0].length;
        if (n == 0) {
            return 0;
        }
        
        int[] roots = new int[m*n];
        int count = 0;
        for (int i = 0; i < m*n; i++) {
            roots[i] = i;
            if (grid[i/n][i%n] == '1') {
                count++;
            }
        }
        UnionFind uf = new UnionFind(roots);
        int dx[] = {0, 1, 0, -1};
        int dy[] = {1, 0, -1, 0};
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') {
                    continue;
                }
                for (int k = 0; k < 4; k++) {
                    int ni = i + dx[k];
                    int nj = j + dy[k];
                    if (ni >= 0 && ni <m && nj >=0 && nj < n && grid[ni][nj] == '1') {
                        if (uf.union(i*n+j, ni*n+nj)) {
                            count--;
                        }   
                    }
                }
            }
        }
        return count;
    }
}
