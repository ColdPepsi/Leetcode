/**
 * @author WuBiao
 * @date 2020/7/5 22:09
 */
public class Solution {
    private int ROW;
    private int COL;
    private static final int[][] DIRECTIONS = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    /**
     * @param A 二维数组
     * @return int
     * @description 从四个边界开始DFS
     * @author WuBiao
     * @date 2020/7/5 22:10
     */
    public int numEnclaves(int[][] A) {
        ROW = A.length;
        COL = A[0].length;
        for (int i = 0; i < COL; i++) {
            DFS(A, 0, i);
            DFS(A, ROW - 1, i);
        }
        for (int i = 0; i < ROW; i++) {
            DFS(A, i, 0);
            DFS(A, i, COL - 1);
        }
        int res = 0;
        for (int i = 1; i < ROW - 1; i++) {//统计个数
            for (int j = 1; j < COL - 1; j++) {
                if (A[i][j] == 1) {
                    res++;
                }
            }
        }
        return res;
    }

    /**
     * @param A   二维数组
     * @param row 横坐标
     * @param col 纵坐标
     * @return void
     * @description DFS
     * @author WuBiao
     * @date 2020/7/5 22:10
     */
    private void DFS(int[][] A, int row, int col) {
        if (!inArea(row, col) || A[row][col] == 0) {
            return;
        }
        A[row][col] = 0;
        for (int[] direction : DIRECTIONS) {
            int nextRow = direction[0] + row;
            int nextCol = direction[1] + col;
            DFS(A, nextRow, nextCol);
        }
    }

    /**
     * 判断一个点是否在界内
     *
     * @param r 横坐标
     * @param c 纵坐标
     * @return 界内返回true
     */
    private boolean inArea(int r, int c) {
        return r >= 0 && r < ROW && c >= 0 && c < COL;
    }
}
