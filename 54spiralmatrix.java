class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new LinkedList<>();
        if (matrix.length ==0 || matrix[0].length == 0) {
            return list;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        boolean[][] seen = new boolean[m][n];
        
        int dr[] = {0, 1, 0, -1};
        int dc[] = {1, 0, -1, 0};
        
        int x = 0, y = 0, di = 0;
        for (int i = 0; i < m*n; i++) {
            list.add(matrix[x][y]);
            seen[x][y] = true;
            int nx = x + dr[di];
            int ny = y + dc[di];
            if (nx >=0 && nx < m && ny>=0 && ny<n && !seen[nx][ny]) {
                x = nx;
                y = ny;
            } else {
                di = (di + 1)%4;
                x += dr[di];
                y += dc[di]; 
            }
        }
        
        return list;
    }
}
