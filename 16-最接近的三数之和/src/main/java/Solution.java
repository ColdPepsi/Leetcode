import java.util.Arrays;

/**
 * @author wubiao21 2020年07月08日 10:42:48
 */
public class Solution {

    private int closestSum;//当前最接近的和

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);//排序是去重的基础
        closestSum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 && nums[i] > target) {//已经排过序，nums[i]越加越大，后面不用算了
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;//去重
            }
            if (doublePointer(nums, i, i + 1, nums.length - 1, target)) {
                return target;//找到target，直接返回target
            }
        }
        return closestSum;
    }

    /**
     * 双指针解法，类似15题
     *
     * @param nums    数组
     * @param current 当前固定的坐标
     * @param left    左指针
     * @param right   右指针
     * @param target  目标和
     * @return 找到目标和的值返回true，其他返回false
     */
    private boolean doublePointer(int[] nums, int current, int left, int right, int target) {
        while (left < right) {
            int sum = nums[current] + nums[left] + nums[right];
            if (sum == target) {
                return true;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
            if (Math.abs(sum - target) < Math.abs(closestSum - target)) {
                closestSum = sum;
            }
        }
        return false;
    }
}