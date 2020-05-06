/**
 * @author WuBiao
 * @date 2020/5/1 18:46
 */
public class Solution2 {
    public boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][10];
        int[][] col = new int[9][10];
        int[][] box = new int[9][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int boxIndex = (i / 3) * 3 + j / 3;
                int num = board[i][j] - '0';
                row[i][num]++;
                col[j][num]++;
                box[boxIndex][num]++;
                if (row[i][num] > 1 || col[j][num] > 1 || box[boxIndex][num] > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}