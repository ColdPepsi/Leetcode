import java.util.Arrays;

/**
 * @author WuBiao
 * @date 2020/3/14 14:51
 */
public class Solution {
    /**
     * @param m
     * @param n
     * @return int
     * @description 动态规划，dp[j]=dp[j]+d[j-1]
     * @author WuBiao
     * @date 2020/3/14 14:51
     */
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        int[] dp = new int[n];
        Arrays.fill(dp, 1);//初始化全1
        for (int i = 1; i < m; i++) {//从下标1开始，因为第一行第一列路径全为1
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];// 取上方和左方之和
            }
        }
        return dp[n - 1];
    }
}