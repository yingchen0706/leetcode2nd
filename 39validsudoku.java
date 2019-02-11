class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set[] row = new Set[board.length];
        for (int i = 0; i < row.length; i++) {
            row[i] = new HashSet<Integer>();
        }
        Set[] column = new Set[board[0].length];
        for (int i = 0; i < column.length; i++) {
            column[i] = new HashSet<Integer>();
        }
        Set[][] subBox = new Set[board.length/3][];
        for (int i = 0; i < subBox.length; i++) {
            subBox[i] = new Set[3];
            for (int j = 0; j < 3; j++) {
                subBox[i][j] = new HashSet<Integer>();
            }
        }
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                Set rows = row[i];
                if (rows.contains(board[i][j])) {
                    return false;
                } else {
                    rows.add(board[i][j]);
                }
                Set cols = column[j];
                if (cols.contains(board[i][j])) {
                    return false;
                } else {
                    cols.add(board[i][j]);
                }
                Set box = subBox[i/3][j/3];
                if (box.contains(board[i][j])) {
                    return false;
                } else {
                    box.add(board[i][j]);
                }
            }
        }
        return true;
    }
}
