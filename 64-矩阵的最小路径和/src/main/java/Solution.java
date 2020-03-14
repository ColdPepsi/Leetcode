/**
 * @author WuBiao
 * @date 2020/3/14 14:15
 */
public class Solution {
    /**
     * @param grid
     * @return int
     * @description 动态规划，二维数组：dp[i][j]=grid[i][j]+min(dp[i-1][j],dp[i][j-1]),
     * 一维数组：dp[j]=grid[i][j]+min(dp[j-1],dp[j]);
     * @author WuBiao
     * @date 2020/3/14 14:43
     */
    //dp[i][j]=grid[i][j]+min(dp[i-1][j],dp[i][j-1]),dp[j]=grid[i][j]+min(d[j-1],d[j])
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int row = grid.length, col = grid[0].length;
        int[] dp = new int[col];//动态规划结果数组
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (j == 0) {//第一列元素，只能来自其上边
                    //dp[j]=dp[j];
                } else if (i == 0) {//第一行元素，只能来自其左边
                    dp[j] = dp[j - 1];
                } else {//取其中的最小值
                    dp[j] = Math.min(dp[j - 1], dp[j]);
                }
                dp[j] += grid[i][j];
            }
        }
        return dp[col - 1];//循环完，最后一个元素就是结果
    }
}