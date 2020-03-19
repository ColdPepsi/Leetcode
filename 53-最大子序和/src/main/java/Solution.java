/**
 * @author WuBiao
 * @date 2020/3/19 22:26
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;//保存nums[i]之前的最大子数组和
        int res = Integer.MIN_VALUE;
        for (int num : nums) {
            sum = Math.max(sum + num, num);
            res = Math.max(res, sum);
        }
        return res;
    }
}