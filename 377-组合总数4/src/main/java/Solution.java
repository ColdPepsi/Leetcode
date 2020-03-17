/**
 * @author WuBiao
 * @date 2020/3/17 19:18
 */
public class Solution {
    /**
     * @param nums
     * @param target
     * @return int
     * @description 抽象出动态规划的模型
     * @author WuBiao
     * @date 2020/3/17 19:29
     */
    public int combinationSum4(int[] nums, int target) {
        if (target == 0) {
            return 1;
        }
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }
}
//dp[i]表示nums中的数相加为i的总方案数
//dp[i]=sum(dp[i-nums[j]])