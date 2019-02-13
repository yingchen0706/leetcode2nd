class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        
        for (int i = 0; i < n/2; i++) {
            for (int j = 0; j < n; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[n-1-i][j];
                matrix[n-1-i][j] = t;
            }
        }
        
        for (int i = 0; i < n - 1; i++) {
            for (int j = i+1; j < n; j++) {
                int  t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        }
    }
}
