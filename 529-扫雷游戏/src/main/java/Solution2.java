/**
 * @author WuBiao
 * @date 2020/5/25 7:58
 */
public class Solution2 {

    private static final int[][] DIRECTIONS = {{-1, 0}, {-1, -1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}};

    public char[][] updateBoard(char[][] board, int[] click) {
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
        } else {
            DFS(board, click[0], click[1]);
        }
        return board;
    }

    private boolean InTheBorder(int x, int y, char[][] board) {
        return x >= 0 && x < board.length && y >= 0 && y < board[0].length;
    }

    private void DFS(char[][] board, int row, int col) {
        int count = 0;
        for (int[] direction : DIRECTIONS) {
            int nextRow = row + direction[0];
            int nextCol = col + direction[1];
            if (InTheBorder(nextRow, nextCol, board) && board[nextRow][nextCol] == 'M') {
                count++;
            }
        }
        if (count == 0) {
            board[row][col] = 'B';
            for (int[] direction : DIRECTIONS) {
                int nextRow = row + direction[0];
                int nextCol = col + direction[1];
                if (InTheBorder(nextRow, nextCol, board) && board[nextRow][nextCol] == 'E') {
                    DFS(board, nextRow, nextCol);
                }
            }
        } else {
            board[row][col] = Character.forDigit(count, 10);
        }
    }
}