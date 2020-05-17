/**
 * @author WuBiao
 * @date 2020/5/15 15:01
 */
public class Solution {
    /**
     * @param nums 数组
     * @param k    目标和
     * @return int
     * @description 暴力解法，先固定右区间，然后遍历左区间
     * @author WuBiao
     * @date 2020/5/15 15:05
     */
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        for (int right = 0; right < nums.length; right++) {//固定右区间
            int sum = 0;
            for (int left = right; left >= 0; left--) {//遍历左区间
                sum += nums[left];
                if (sum == k) {
                    res++;
                }
            }
        }
        return res;
    }
}