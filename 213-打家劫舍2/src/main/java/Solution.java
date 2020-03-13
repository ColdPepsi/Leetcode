/**
 * @author WuBiao
 * @date 2020/3/13 21:49
 */
public class Solution {
    /**
     * @param nums
     * @return int
     * @description 环形房屋，所以第一间房和最后一间房只能选一个抢，结果就是两个里面的最大值。
     * 不用管从哪里作为入口开始抢，因为是个环，和从第一个开始抢结果是一样的。
     * @author WuBiao
     * @date 2020/3/13 22:17
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];//长度为1时候，调用下面的函数边界会越界，所以单独返回
        }
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }

    /**
     * @param nums
     * @param left  左区间
     * @param right 右区间
     * @return int dp[i]=max(dp[i-2]+num[i],dp[n]);
     * @description nums在区间[left, right]，内抢劫最大值。
     * @author WuBiao
     * @date 2020/3/13 22:06
     */
    private int rob(int[] nums, int left, int right) {
        int pre1 = 0, pre2 = 0;
        int current = 0;
        for (int i = left; i <= right; i++) {
            current = Math.max(pre1 + nums[i], pre2);
            pre1 = pre2;
            pre2 = current;
        }
        return current;
    }
}