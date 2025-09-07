class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;

        for (int i = 0; i < n * n; i++) {
            if (board[i / n][i % n] != '.') {
                int row = i / n;
                int col = i % n;
                if (!possible(board, row, col, board[row][col])) return false;
            }
        }
        return true;
    }

    public static boolean possible(char[][] board, int row, int col, char num) {
        int n = board.length;

        // Check row
        for (int i = 0; i < n; i++) {
            if (i == col) continue;
            if (board[row][i] == num) return false;
        }

        // Check column
        for (int i = 0; i < n; i++) {
            if (i == row) continue;
            if (board[i][col] == num) return false;
        }

        // Check 3x3 subgrid
        int rowStart = row - row % 3;
        int colStart = col - col % 3;

        for (int i = rowStart; i < rowStart + 3; i++) {
            for (int j = colStart; j < colStart + 3; j++) {
                if (i == row && j == col) continue;
                if (board[i][j] == num) return false;
            }
        }

        return true;
    }
}
