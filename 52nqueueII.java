class Solution {
    private int solution;
    
    public int totalNQueens(int n) {
        solution = 0;
        DFS(n, 0, 0, 0, 0);
        return solution;
    }
    
    private void DFS(int n, int row, int col, int pie, int na) {
        if (row >= n) {
            solution++;
            return;
        }
        
        int bits = (~(col|pie|na) & ((1<< n) - 1));
        while (bits > 0) {
            int p = bits & -bits;
            DFS(n, row+1, col|p, (pie|p) << 1, (na|p) >> 1);
            bits &= (bits-1);
        }
    }
}
