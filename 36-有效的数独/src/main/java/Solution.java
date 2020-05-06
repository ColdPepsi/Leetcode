/**
 * @author WuBiao
 * @date 2020/5/1 18:12
 */
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (!checkRow(board, i, j) || !checkCol(board, i, j) || !checkBox(board, i, j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean checkRow(char[][] board, int row, int col) {
        for (int i = 0; i < 9; i++) {
            if (i == col) {
                continue;
            }
            if (board[row][i] == board[row][col]) {
                return false;
            }
        }
        return true;
    }

    private boolean checkCol(char[][] board, int row, int col) {
        for (int i = 0; i < 9; i++) {
            if (i == row) {
                continue;
            }
            if (board[i][col] == board[row][col]) {
                return false;
            }
        }
        return true;
    }

    private boolean checkBox(char[][] board, int row, int col) {
        int subRow = (row / 3) * 3;
        int subCol = (col / 3) * 3;
        for (int i = 0; i < 9; i++) {
            if (subRow + i / 3 == row && subCol + i % 3 == col) {
                continue;
            }
            if (board[subRow + i / 3][subCol + i % 3] == board[row][col]) {
                return false;
            }
        }
        return true;
    }
}
