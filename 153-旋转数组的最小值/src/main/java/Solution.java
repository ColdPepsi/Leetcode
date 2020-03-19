/**
 * @author WuBiao
 * @date 2020/3/18 9:51
 */
public class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] <= nums[right]) {
                //说明升序，最小值在左区间
                right = mid;
            } else {//中間值大於最右元素，説明最小值在右邊區間
                left = mid + 1;
            }
        }
        return nums[left];
    }
}
//456712