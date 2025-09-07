class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        int n = 9;
        int row = -1, col = -1;
        boolean emptyFound = false;

        // Converting 2D array to 1D Striver
        for (int i = 0; i < n * n; i++) {
            if (board[i / n][i % n] == '.') {
                row = i / n;
                col = i % n;
                emptyFound = true;
                break;
            }
        }

        // No empty cell means solved
        if (!emptyFound) return true;

    
        for (char num = '1'; num <= '9'; num++) {
            if (possible(board, row, col, num)) {
                board[row][col] = num;

                if (solve(board)) return true; // recurse

                board[row][col] = '.'; // backtrack
            }
        }

        return false; // trigger backtracking, no number works with current board state
    }

    private boolean possible(char[][] board, int row, int col, char num) {
        // check row & column
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num || board[i][col] == num) return false;
        }

        // check 3x3 box
        int rowStart = row - row % 3;
        int colStart = col - col % 3;

        for (int i = rowStart; i < rowStart + 3; i++) {
            for (int j = colStart; j < colStart + 3; j++) {
                if (board[i][j] == num) return false;
            }
        }

        return true;
    }
}
