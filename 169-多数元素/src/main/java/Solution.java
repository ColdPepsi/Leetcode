import java.util.Arrays;

/**
 * @author WuBiao
 * @date 2020/3/28 19:09
 */
public class Solution {
    /**
     * @param nums
     * @return int
     * @description 排序后，众数一定出现在中间位置
     * @author WuBiao
     * @date 2020/3/28 19:10
     */
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}