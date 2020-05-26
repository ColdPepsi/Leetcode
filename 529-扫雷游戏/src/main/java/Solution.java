/**
 * @author WuBiao
 * @date 2020/5/24 21:32
 */
public class Solution {

    private static final int[][] DIRECTIONS = {{-1, 0}, {-1, -1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}};
    private int rows;
    private int cols;

    public char[][] updateBoard(char[][] board, int[] click) {
        rows = board.length;
        cols = board[0].length;
        int x = click[0];//横坐标
        int y = click[1];//纵坐标
        if (board[x][y] == 'M') {//踩到雷直接返回结果
            board[x][y] = 'X';
        } else {
            int count = 0;
            for (int[] direction : DIRECTIONS) {
                int nextX = x + direction[0];
                int nextY = y + direction[1];
                if (InTheBorder(nextX, nextY) && board[nextX][nextY] == 'M') {
                    count++;//统计周围雷数；
                }
            }
            if (count != 0) {//如果周围有雷，可以直接返回结果；
                board[x][y] = (char) ('0' + count);
            } else {//周围没雷
                board[x][y] = 'B';//设置为B
                for (int[] direction : DIRECTIONS) {
                    int nextX = x + direction[0];
                    int nextY = y + direction[1];
                    if (InTheBorder(nextX, nextY) && board[nextX][nextY] == 'E') {
                        updateBoard(board, new int[]{nextX, nextY});//递归处理周围未挖出的空白块
                    }
                }
            }
        }
        return board;//返回结果
    }

    /**
     * @param x 横坐标
     * @param y 纵坐标
     * @return boolean
     * @description 判断一个点有没有出界
     * @author WuBiao
     * @date 2020/5/24 22:14
     */
    private boolean InTheBorder(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}