/**
 * @author WuBiao
 * @date 2020/3/19 22:05
 */
public class Solution {
    /**
     * @param nums
     * @return boolean
     * @description 在出现 nums[i] < nums[i - 1] 时，需要考虑的是应该修改数组的哪个数，
     * 使得本次修改能使 i 之前的数组成为非递减数组，并且 不影响后续的操作 。
     * 优先考虑令 nums[i - 1] = nums[i]，因为如果修改 nums[i] = nums[i - 1] 的话，
     * 那么 nums[i] 这个数会变大，就有可能比 nums[i + 1] 大，从而影响了后续操作。
     * 还有一个比较特别的情况就是 nums[i] < nums[i - 2]，
     * 修改 nums[i - 1] = nums[i] 不能使数组成为非递减数组，只能修改 nums[i] = nums[i - 1]。
     * @author WuBiao
     * @date 2020/3/19 22:21
     */
    public boolean checkPossibility(int[] nums) {
        int count = 0;//记录修改几个数
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                count++;//出现下降了，肯定要发生修改
                if (i > 1 && nums[i] < nums[i - 2]) {
                    nums[i] = nums[i - 1];
                } else {
                    nums[i - 1] = nums[i];
                }
                if (count > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}