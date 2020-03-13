/**
 * @author WuBiao
 * @date 2020/3/13 21:06
 */
public class Solution {
    /**
     * @param nums
     * @return int
     * @description dp[i]=max(dp[i-1],dp[i-2]+nums[i])
     * @author WuBiao
     * @date 2020/3/13 21:07
     */
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        } else if (n == 1) {//只有1家，返回第一家
            return nums[0];
        } else if (n == 2) {//只有2家，两家中挑一个返回
            return Math.max(nums[0], nums[1]);
        }
        int pre1 = nums[0], pre2 = Math.max(nums[0], nums[1]);
        int current = 0;
        int max = 0;
        for (int i = 2; i < n; i++) {
            current = Math.max(pre1 + nums[i], pre2);
            max = Math.max(max, current);//max可以省略，因为current是递增的，最后返回current即可
            pre1 = pre2;
            pre2 = current;
        }
        return max;
    }
}