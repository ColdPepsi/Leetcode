/**
 * @author WuBiao
 * @date 2020/3/16 20:47
 */
public class Solution {
    /**
     * @param nums
     * @return boolean
     * @description 判断能否把数字分割成等和的两个子集，可以当成0-1背包问题，
     * 定义dp[i][j]表示前i个数中是否有有数字可以相加为j
     * nums[i]面临取或者不取，dp[i][j]=dp[i-1][j]||dp[i-1][j-num[i]];
     * @author WuBiao
     * @date 2020/3/16 20:47
     */
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;//求所有数的和
        }
        if (sum % 2 == 1) {
            return false;//sum是奇数，直接返回false
        }
        sum /= 2;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;//dp[i][0]理论上应该等于false，但是如果当j-num==0时候，
        // 说明num这个数自己一组。
        for (int num : nums) {//nums中的数每个判断一回
            for (int j = sum; j >= num; j--) {//j<num无意义，num自己就撑爆总和j了
                dp[j] = dp[j] || dp[j - num];
            }
        }
        return dp[sum];
    }
}