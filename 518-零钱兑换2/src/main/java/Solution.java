/**
 * @author WuBiao
 * @date 2020/3/17 16:58
 */
public class Solution {
    /**
     * @param amount
     * @param coins
     * @return int
     * @description 完全背包
     * @author WuBiao
     * @date 2020/3/17 17:10
     */
    public int change(int amount, int[] coins) {
        if (amount == 0) {
            return 1;
        }
        if (coins == null || coins.length == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        dp[0] = 1;//凑总数0，只有1种方案，就是什么也不选
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}
//完全背包
//dp[i][j]表示前i个数组合成总数k的方案数
//dp[i][j]=dp[i-1][j]+dp[i][j-coin[i]],不选+选的方案数总和