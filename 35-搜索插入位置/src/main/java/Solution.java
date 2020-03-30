/**
 * @author WuBiao
 * @date 2020/3/29 13:14
 */
public class Solution {
    /**
     * @param nums
     * @param target
     * @return int
     * @description 返回数组中第一个大于等于target元素的下标
     * @author WuBiao
     * @date 2020/3/29 13:17
     */
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length;//注意右区间，因为target可能大于nums中的所有数
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
}