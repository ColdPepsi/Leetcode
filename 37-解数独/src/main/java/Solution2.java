/**
 * @author WuBiao
 * @date 2020/4/13 20:30
 */
public class Solution2 {
    /**
     * @param board
     * @return void
     * @description 回溯，返回一个解即可，不是所有解，没有占用多余的数组来保存状态
     * @author WuBiao
     * @date 2020/4/13 17:03
     */
    public void solveSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) {
            return;
        }
        backTracking(board, 0, 0);//从左上角开始回溯
    }

    /**
     * @param c
     * @param row
     * @param col
     * @param board
     * @return boolean
     * @description 检验是否合法
     * @author WuBiao
     * @date 2020/4/13 17:02
     */

    private boolean isValid(char c, int row, int col, char[][] board) {
        int subRow = (row / 3) * 3;//锁定在第一个三行还是第二个三行，还是第三个三行
        int subCol = (col / 3) * 3;//锁定在第一个三列还是第二个三列，还是第三个三列
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == c || board[i][col] == c || board[subRow + i / 3][subCol + i % 3] == c) {
                return false;//判断有没有行冲突，列有没有冲突，小格子有没有冲突
            }
        }
        return true;
    }

    /**
     * @param board
     * @param row
     * @param col
     * @return boolean
     * @description 回溯，在每个位置依次放入1~9,看是否合法
     * @author WuBiao
     * @date 2020/4/13 17:02
     */
    private boolean backTracking(char[][] board, int row, int col) {
        if (col == 9) {//如果过了最后一列，则转向下一行
            return backTracking(board, row + 1, 0);
        }
        if (row == 9) {//所有行都已完成，返回结果。
            return true;
        }
        if (board[row][col] != '.') {//此位置有数字，不需要解
            return backTracking(board, row, col + 1);
        }
        for (char c = '1'; c <= '9'; c++) {//尝试在改位置放入1~9.
            if (!isValid(c, row, col, board)) {
                continue;//不合法直接跳过，尝试下一个数
            }
            board[row][col] = c;//在该位置放置c
            if (backTracking(board, row, col + 1)) {
                return true;//找到一个解，就返回
            }
            board[row][col] = '.';//回复现场
        }
        return false;//该位置1-9都尝试了一遍，没有返回true，说明此位置无解，返回上一层回溯
    }
}
