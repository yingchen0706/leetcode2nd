class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        if (m == 0) {
            return 0;
        }
        int n = grid[0].length;
        if (n == 0) {
            return 0;
        }
        int res = 0;
        
        boolean visited[][] = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    DFS(grid, i, j, visited);
                    res++;
                }               
            }
        }
        return res;
    }
    private void DFS(char[][] grid, int row, int col, boolean[][]  visited) {
        int m = grid.length;
        int n = grid[0].length;
        if (row < 0 || row > m-1 || col < 0 || col > n-1 || visited[row][col] || grid[row][col] == '0') {
            return;
        }
        
        visited[row][col] = true;
        
        int dx[] = {0, 1, 0, -1};
        int dy[] = {1, 0, -1, 0};
        
        for (int i = 0; i < 4; i++) {
            DFS(grid, row+dx[i], col+dy[i], visited);
        }
        return;
    }
}
