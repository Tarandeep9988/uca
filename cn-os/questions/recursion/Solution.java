import java.util.*;
class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = 9;
        boolean[][] row = new boolean[n][100];
        boolean[][] col = new boolean[n][100];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char ch = board[i][j];
                if (ch != '.') {
                    if (row[i][ch] || col[j][ch]) {
                        return false;
                    }
                    row[i][ch] = col[j][ch] = true;
                }
            }
        }

        for (int i = 0; i < n; i += 3) {
            for (int j = 0; j < n; j += 3) {
                HashSet<Character> set = new HashSet<>();
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        char ch = board[i + k][j + l];
                        if (ch == '.') continue;
                        if (set.contains(ch)) {
                            return false;
                        }
                        set.add(ch);
                    }
                }
            }
        }
        return true;
    }
}