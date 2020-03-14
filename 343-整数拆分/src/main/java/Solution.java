/**
 * @author WuBiao
 * @date 2020/3/14 18:02
 */
public class Solution {
    /**
     * @param n
     * @return int
     * @description 动态规划
     * @author WuBiao
     * @date 2020/3/14 18:27
     */
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];//d[i]表示数字i拆分为最少两个整数和的最大乘积
        dp[2] = 1;
        dp[1] = 1;//1是不可拆分的，dp[1]主要用来计算
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {//i可以被分为 j与i-j两数之和
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }
}