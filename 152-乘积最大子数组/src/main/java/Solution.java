/**
 * @author WuBiao
 * @date 2020/5/18 13:28
 */
public class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[][] dp = new int[nums.length][2];//dp[i][0]表示以nums[i]结尾的序列乘积最小值，dp[i][1]表示以nums[i]结尾的序列乘积最大值。
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        int maxProduct = dp[0][1];
        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = Math.min(Math.min(dp[i - 1][0] * nums[i], dp[i - 1][1] * nums[i]), nums[i]);
            dp[i][1] = Math.max(Math.max(dp[i - 1][0] * nums[i], dp[i - 1][1] * nums[i]), nums[i]);
            maxProduct = Math.max(maxProduct, dp[i][1]);
        }
        return maxProduct;
    }
}