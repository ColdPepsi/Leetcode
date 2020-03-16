/**
 * @author WuBiao
 * @date 2020/3/16 21:56
 */
public class Solution {
    /**
     * @param nums
     * @param S
     * @return int
     * @description 动态规划，01背包的变形
     * @author WuBiao
     * @date 2020/3/16 23:39
     */
    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;//计算总和
        }
        if (sum < S || (sum + S) % 2 == 1) {
            return 0;
        }
        sum = (sum + S) / 2;
        int[] dp = new int[sum + 1];
        dp[0] = 1;//取出和为0的数，方法总数为1，即什么也不取
        for (int i = 1; i <= nums.length; i++) {
            for (int j = sum; j >= nums[i - 1]; j--) {
                dp[j] = dp[j] + dp[j - nums[i - 1]];
            }
        }
        return dp[sum];
    }
}
//p代表数组中取加号的数，N代表数组中要减的数
//                  sum(P) - sum(N) = target
//sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) + sum(N)
//                       2 * sum(P) = target + sum(nums)
//所以我们可以从nums集合中取出一个子集，他们全取正号，并且和为（target+sum(nums)）/2，即为一个解
//dp[i][j]表示我们从前i个数中取出子集总和是j的子集总数
//nums[i]有取和不取两种情况
//dp[i][j]=dp[i-1][j-num[i]]+dp[i-1][j];取nums[i]+不取nums[i]的方法总数
//初始化dp[i][0]=1;表示取出和为0的数方法为1，即什么也不取