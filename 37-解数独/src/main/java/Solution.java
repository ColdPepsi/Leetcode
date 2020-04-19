/**
 * @author WuBiao
 * @date 2020/4/13 16:35
 */
public class Solution {

    private boolean[][] Row;
    private boolean[][] Col;
    private boolean[][] Boxes;

    /**
     * @param board
     * @return void
     * @description 回溯法，需要额外的空间记录状态，但是速度快，空间换时间
     * @author WuBiao
     * @date 2020/4/13 20:34
     */
    public void solveSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) {
            return;
        }
        boolean[][] Row = new boolean[9][10];//用来判断某行某个数有没有放
        boolean[][] Col = new boolean[9][10];//用来判断某列某个数有没有放
        boolean[][] Boxes = new boolean[9][10];//用来判断某小盒子某个数有没有放

        this.Row = Row;//这三个数组不能在上面new，因为每次调用solveSudoku，都需要全新的状态表
        this.Col = Col;
        this.Boxes = Boxes;

        for (int i = 0; i < board.length; i++) {//进行记录表的初始化
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    int boxIndex = (i / 3) * 3 + j / 3;
                    Row[i][num] = true;
                    Col[j][num] = true;
                    Boxes[boxIndex][num] = true;
                }
            }
        }
        backTracking(board, 0, 0);//从左上角开始回溯
    }

    /**
     * @param num      放置的数字
     * @param row      横坐标
     * @param col      纵坐标
     * @param boxIndex 小盒子坐标，取值0~8
     * @return boolean
     * @description 记录某数是否在某行某列某小格子已经放置过
     * @author WuBiao
     * @date 2020/4/13 20:34
     */
    private boolean isPlaced(int num, int row, int col, int boxIndex) {
        return Row[row][num] || Col[col][num] || Boxes[boxIndex][num];
    }

    /**
     * @param board
     * @param row
     * @param col
     * @return boolean
     * @description 回溯法，每个位置放置1~9来测试
     * @author WuBiao
     * @date 2020/4/13 20:36
     */
    private boolean backTracking(char[][] board, int row, int col) {
        if (col == 9) {
            return backTracking(board, row + 1, 0);
        }
        if (row == 9) {
            return true;
        }
        if (board[row][col] != '.') {
            return backTracking(board, row, col + 1);
        }
        for (char c = '1'; c <= '9'; c++) {
            int num = c - '0';
            int boxIndex = (row / 3) * 3 + col / 3;//小盒子坐标，取值0~8
            if (isPlaced(num, row, col, boxIndex)) {
                continue;
            }
            board[row][col] = c;//放置C
            Row[row][num] = true;
            Col[col][num] = true;
            Boxes[boxIndex][num] = true;

            if (backTracking(board, row, col + 1)) {
                return true;
            }

            Boxes[boxIndex][num] = false;//恢复现场
            Col[col][num] = false;
            Row[row][num] = false;
            board[row][col] = '.';
        }
        return false;
    }
}