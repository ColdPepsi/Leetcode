/**
 * @author WuBiao
 * @date 2020/5/18 17:17
 */
public class Solution3 {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = nums[0];
        int temp = 1;
        for (int num : nums) {
            temp *= num;
            max = Math.max(max, temp);
            if (num == 0) {
                temp = 1;
            }
        }
        temp = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            temp *= nums[i];
            max = Math.max(max, temp);
            if (nums[i] == 0) {
                temp = 1;
            }
        }
        return max;
    }
}