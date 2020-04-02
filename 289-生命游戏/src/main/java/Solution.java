/**
 * @author WuBiao
 * @date 2020/4/2 20:24
 */
public class Solution {

    private int[][] board;
    private int row;
    private int col;
    private int[][] direction = {{-1, 0}, {-1, -1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}};//方向向量

    /**
     * @param board
     * @return void
     * @description 把当前数组复制下来，用来记录状态
     * @author WuBiao
     * @date 2020/4/2 20:49
     */
    public void gameOfLife(int[][] board) {
        this.board = board;
        this.row = board.length;
        this.col = board[0].length;

        int[][] states = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                states[i][j] = board[i][j];//复制到states
            }
        }
        check(states);
    }

    /**
     * @param r 横坐标
     * @param c 纵坐标
     * @return boolean
     * @description 判断一个坐标有没有出界
     * @author WuBiao
     * @date 2020/4/2 20:34
     */
    private boolean outOfBorder(int r, int c) {
        if (r < 0 || r >= row || c < 0 || c >= col) {
            return true;
        }
        return false;
    }

    /**
     * @param states
     * @return void
     * @description 检测每个细胞
     * @author WuBiao
     * @date 2020/4/2 20:49
     */
    private void check(int[][] states) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int alive = 0;
                for (int[] dire : direction) {//统计周围的活细胞数目
                    int r = i + dire[0];
                    int c = j + dire[1];
                    if (!outOfBorder(r, c)) {//如果没出界
                        if (states[r][c] == 1) {
                            alive++;
                        }
                    }
                }
                if ((states[i][j] == 1) && (alive < 2 || alive > 3)) {//条件1，3
                    board[i][j] = 0;
                } else if (states[i][j] == 0 && alive == 3) {//条件4
                    board[i][j] = 1;
                }//其他情况不用改变
            }
        }
    }
}