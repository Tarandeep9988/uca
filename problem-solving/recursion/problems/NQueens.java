
public class NQueens {
    /**
     * The n-queens puzzle is the problem of placing n queens on an n x n chessboard
     * such that no two queens attack each other.
     * Given an integer n, return the number of distinct solutions to the n-queens
     * puzzle.
     * 
     * Example:
     * Input n = 4
     * Output: 2
     * Explanation: There are two distinct solutions to the 4-queens puzzle as shown
     * below.
     *
     * [
     * [".Q..", // Solution 1
     * "...Q",
     * "Q...",
     * "..Q."],
     * ["..Q.", // Solution 2
     * "Q...",
     * "...Q",
     * ".Q.."
     * ]
     * ]
     * 
     * Constraints:
     * 1. 1 <= n <= 9
     * 2. You may assume that n is a positive integer.
     *
     * @param n - The size of the chessboard and the number of queens to place.
     * @returns int - The number of distinct solutions to the n-queens puzzle.
     **/
    public int totalNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        return helper(board, 0);
    }

    private int helper(boolean[][] board, int row) {
        int n = board.length;
        if (row == n) {
            return 1;
        }
        int cnt = 0;
        for (int col = 0; col < n; col++) {
            if (canPlace(board, row, col)) {
                // Place here
                board[row][col] = true;
                cnt += helper(board, row + 1);
                // Reset cell
                board[row][col] = false;
            }
        }
        return cnt;
    }

    private boolean canPlace(boolean[][] board, int row, int col) {
        int i = row;
        while (i >= 0) {
            // Checking if Queen exists upward
            if (board[i][col]) {
                return false;
            }
            i--;
        }
        // Checking first diagonal
        i = row;
        int j = col;
        while (i >= 0 && j >= 0) {
            if (board[i][j]) {
                return false;
            }
            i--;
            j--;
        }
        // Checking second diagonal
        i = row;
        j = col;
        while (i >= 0 && j < board.length) {
            if (board[i][j]) {
                return false;
            }
            i--;
            j++;
        }
        return true;
    }

    /**
     * Main method for testing the NQueens class.
     */
    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
        assert nQueens.totalNQueens(4) == 2 : "Test case 1 failed";
        assert nQueens.totalNQueens(1) == 1 : "Test case 2 failed";
        assert nQueens.totalNQueens(5) == 10 : "Test case 3 failed";
    }
}