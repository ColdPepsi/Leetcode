/**
 * @author WuBiao
 * @date 2020/3/21 20:37
 */
public class Solution {

    int[][] direction = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};//方向向量

    /**
     * @param board
     * @return void
     * @description 只从边界开始DFS，看看有多少区域和边界“O”相连
     * @author WuBiao
     * @date 2020/3/21 21:10
     */
    public void solve(char[][] board) {
        if (board == null || board.length < 2 || board[0].length < 2) {
            return;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean isBorder = (i == 0 || i == board.length - 1 || j == 0 || j == board[0].length - 1);//判断当前结点是否是边界
                if (isBorder && board[i][j] == 'O') {//看看有多少元素和边界相连
                    DFS(board, i, j);//把与边界相连的区域换成“#”表示占位符
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';//内部的O直接换成X
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O';//与边界相连的“O”都被换成了“#”,现在恢复原样。
                }
            }
        }
    }

    /**
     * @param board
     * @param row
     * @param col
     * @return void
     * @description 深度优先遍历
     * @author WuBiao
     * @date 2020/3/21 21:09
     */
    private void DFS(char[][] board, int row, int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != 'O') {
            return;//越界，或者已经处理过，则返回
        }
        board[row][col] = '#';//标记为占位符
        for (int[] ints : direction) {
            DFS(board, row + ints[0], col + ints[1]);
        }
    }
}