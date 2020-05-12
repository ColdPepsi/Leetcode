/**
 * @author WuBiao
 * @date 2020/5/8 11:15
 */
public class Solution {
    /**
     * @param matrix
     * @return int
     * @description dp[i][j]表示以matrix[i][j]元素为正方形右下角所能组成的最大正方形的边长
     * @author WuBiao
     * @date 2020/5/8 12:05
     */
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        int max = -1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {//dp状态转移方程
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                }
                if (dp[i][j] > max) {
                    max = dp[i][j];
                }
            }
        }
        return max * max;
    }
}