import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author WuBiao
 * @date 2020/3/21 21:50
 */
public class Solution {

    private int[][] direction = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};//方向向量
    private int row;//矩阵行数
    private int col;//矩阵列数

    /**
     * @param matrix
     * @return java.util.List<java.util.List < java.lang.Integer>>
     * @description 也是从边缘开始DFS，同130题
     * @author WuBiao
     * @date 2020/3/21 22:39
     */
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<List<Integer>>();
        }
        row = matrix.length;
        col = matrix[0].length;
        boolean[][] canReachPO = new boolean[row][col];//记录一个点能否到达太平洋
        boolean[][] canReachAO = new boolean[row][col];//记录一个点能否到达大西洋
        //下面对四个边缘的点进行处理
        for (int i = 0; i < row; i++) {
            DFS(matrix, i, 0, canReachPO);//左边缘临近太平洋
            DFS(matrix, i, col - 1, canReachAO);//右边缘临近大西洋
        }
        for (int i = 0; i < col; i++) {
            DFS(matrix, 0, i, canReachPO);//上边缘临近太平洋
            DFS(matrix, row - 1, i, canReachAO);//下边缘临近大西洋
        }
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (canReachPO[i][j] && canReachAO[i][j]) {//某点同时能达到太平洋和大西洋，则放入结果集
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    /**
     * @param r
     * @param c
     * @return boolean
     * @description 判断一个坐标是否出界，出界返回true
     * @author WuBiao
     * @date 2020/3/21 21:58
     */
    private boolean outOfBorder(int r, int c) {
        if (r < 0 || r >= row || c < 0 || c >= col) {
            return true;
        }
        return false;
    }

    private void DFS(int[][] matrix, int r, int c, boolean[][] canReach) {
        if (canReach[r][c]) {
            return;//已经能到达，则返回，无需加越界判断，因为不越界才进入的这个函数
        }
        canReach[r][c] = true;//标记为可到达
        for (int[] ints : direction) {
            int nextRow = r + ints[0];
            int nextCol = c + ints[1];
            if ((!outOfBorder(nextRow, nextCol)) && matrix[r][c] <= matrix[nextRow][nextCol]) {
                DFS(matrix, nextRow, nextCol, canReach);//如果周围元素没越界，并且周围比自己高，递归访问周围
            }
        }
    }
}