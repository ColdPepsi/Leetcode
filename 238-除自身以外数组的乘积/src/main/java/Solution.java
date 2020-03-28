/**
 * @author WuBiao
 * @date 2020/3/28 19:58
 */
public class Solution {
    /**
     * @param nums
     * @return int[]
     * @description res[i]等于左边的累乘积*右边的累乘积
     * @author WuBiao
     * @date 2020/3/28 20:03
     */
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int left = 1;
        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            left *= nums[i - 1];
            res[i] = left;
        }
        int right = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            right *= nums[i + 1];
            res[i] *= right;
        }
        return res;
    }
}