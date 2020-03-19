/**
 * @author WuBiao
 * @date 2020/3/18 9:17
 */
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int notLess = firstNotLess(nums, target);
        if (notLess == nums.length || nums[notLess] != target) {
            //说明target没在数组中
            return new int[]{-1, -1};
        }
        //如果target在数组中，找第一个大于等于target在数组中位置
        int big = firstGreat(nums, target);
        return new int[]{notLess, big - 1};
    }

    /**
     * @param nums
     * @param target
     * @return int
     * @description 在数组中找到第一个大于等于target元素的下标
     * @author WuBiao
     * @date 2020/3/18 9:19
     */
    private int firstNotLess(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * @param nums
     * @param target
     * @return int
     * @description 找到第一个大于target元素的下标
     * @author WuBiao
     * @date 2020/3/18 9:30
     */
    private int firstGreat(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}