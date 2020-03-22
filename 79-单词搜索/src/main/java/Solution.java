/**
 * @author WuBiao
 * @date 2020/3/22 16:21
 */
public class Solution {

    private int row;//board的行数
    private int col;//board的列数
    //方向向量
    private final static int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    /**
     * @param board
     * @param word
     * @return boolean
     * @description 回溯
     * @author WuBiao
     * @date 2020/3/22 16:54
     */
    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) {
            return true;
        }
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        row = board.length;
        col = board[0].length;
        boolean[][] hasVisited = new boolean[row][col];//记录board上的点有没有被访问过
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {//对每个点进行回溯
                if (backTracking(board, hasVisited, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @param r
     * @param c
     * @return boolean
     * @description 判断某点有没有出界，出界返回true
     * @author WuBiao
     * @date 2020/3/22 16:34
     */
    private boolean outOfBorder(int r, int c) {
        return r < 0 || r >= row || c < 0 || c >= col;
    }

    /**
     * @param board
     * @param hasVisited
     * @param word
     * @param currIndex  表示当期处理的word下标
     * @param r          行号
     * @param c          列号
     * @return boolean
     * @description 回溯
     * @author WuBiao
     * @date 2020/3/22 17:04
     */
    private boolean backTracking(char[][] board, boolean[][] hasVisited, String word,
                                 int currIndex, int r, int c) {
        if (currIndex == word.length()) {
            return true;//找到结果，返回true
        }
        if (outOfBorder(r, c) || board[r][c] != word.charAt(currIndex) || hasVisited[r][c]) {
            return false;
        }
        hasVisited[r][c] = true;//标记为已经访问
        for (int[] ints : direction) {
            if (backTracking(board, hasVisited, word, currIndex + 1, r + ints[0], c + ints[1])) {
                return true;
            }
        }
        hasVisited[r][c] = false;//没有找到，恢复现场
        return false;
    }
}