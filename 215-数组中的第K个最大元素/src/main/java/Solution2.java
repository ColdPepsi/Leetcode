/**
 * @author WuBiao
 * @date 2020/6/17 22:49
 */
public class Solution2 {
    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, k, 0, nums.length - 1);
    }

    /**
     * @param nums  数组
     * @param left  区间左端点
     * @param right 区间右端点
     * @return int
     * @description 快排的partition函数
     * @author WuBiao
     * @date 2020/6/17 22:50
     */
    private int partition(int[] nums, int left, int right) {
        int temp = nums[left];
        while (left < right) {
            while (left < right && nums[right] < temp) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] >= temp) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = temp;
        return left;
    }

    /**
     * @param nums  数组
     * @param k     第k大
     * @param left  区间左端点
     * @param right 区间右端点
     * @return int
     * @description 快排的思想
     * @author WuBiao
     * @date 2020/6/17 22:50
     */
    private int findKthLargest(int[] nums, int k, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int pos = partition(nums, left, right);
        int temp = pos - left + 1;
        if (temp == k) {
            return nums[pos];
        } else if (temp < k) {
            return findKthLargest(nums, k - temp, pos + 1, right);
        } else {
            return findKthLargest(nums, k, left, pos - 1);
        }
    }
}
