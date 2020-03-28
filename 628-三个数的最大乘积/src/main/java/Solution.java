import java.util.Arrays;

/**
 * @author WuBiao
 * @date 2020/3/28 20:18
 */
public class Solution {
    /**
     * @param nums
     * @return int
     * @description 学会求前几个最大的数
     * @author WuBiao
     * @date 2020/3/28 20:27
     */
    public int maximumProduct(int[] nums) {
        /*int max1 = Integer.MIN_VALUE;//存储数组中最大的元素
        int max2 = Integer.MIN_VALUE;//存储数组中第二大的元素
        int max3 = Integer.MIN_VALUE;//存储数组中第三大的元素
        int min1 = Integer.MAX_VALUE;//存储数组中最小的元素
        int min2 = Integer.MAX_VALUE;//存储数组中第二小的元素
        for (int num : nums) {
            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2) {//max1>num>max2
                max3 = max2;
                max2 = num;
            } else if (num > max3) {//max2>num>max3
                max3 = num;
            }

            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {//min1<num<min2
                min2 = num;
            }
        }
        return Math.max(max1 * max2 * max3, min1 * min2 * max1);*/
        Arrays.sort(nums);
        int len = nums.length;
        return Math.max(nums[len - 1] * nums[len - 2] * nums[len - 3], nums[0] * nums[1] * nums[len - 1]);
    }
}