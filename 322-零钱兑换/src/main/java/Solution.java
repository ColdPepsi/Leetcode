import java.util.Arrays;

/**
 * @author WuBiao
 * @date 2020/3/17 15:58
 */
public class Solution {
    /**
     * @param coins
     * @param amount
     * @return int
     * @description 完全背包，每种物品的数量不受限制
     * @author WuBiao
     * @date 2020/3/17 16:11
     */
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);//初始化为最大值，及时全是1元的，也需要amount张
        dp[0] = 0;
        for (int coin : coins) {//遍历每个硬币
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
//完全背包
//dp[i][j]表示，使用前i个硬币正好凑成总数k，所需要的最少硬币数
//dp[i][j]=min(dp[i-1][j],1+dp[i][j-coins[i]]);取不选与选的最小值
//空间优化，我们可以省掉第一维
//完全背包，空间优化，需要正序遍历，不能逆序！