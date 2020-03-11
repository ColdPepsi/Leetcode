/**
 * @author WuBiao
 * @date 2020/3/11 14:03
 */
public class Solution {
    /**
     * @param nums
     * @return int[]
     * @description 已知 numsnums 中所有数字都是正数，且处于 1 到 n 之间。遍历 nums 中的所有数字，
     * 根据数字 i 找到 nums[∣i∣-1]，如果是第一次访问 nums[∣i∣-1]，
     * 将它反转为负数。如果是第二次访问，则会发现它已经是负数。因此，可以根据访问一个数字时它是否为负数找出重复数字。
     * 完成上述操作后，所有出现过的数字对应索引处的数字都是负数，只有缺失数字 j 对应的索引处仍然是正数。
     * @author WuBiao
     * @date 2020/3/11 14:22
     */
    public int[] findErrorNums(int[] nums) {
        int dup = -1;
        int missing = -1;
        for (int num : nums) {
            if (nums[Math.abs(num) - 1] < 0) {//要减一，因为下标从0开始
                //说明已经翻转过一次了
                dup = Math.abs(num);
            } else {
                nums[Math.abs(num) - 1] *= -1;
            }
        }//循环执行完，存在的数已经都变成负数，找那个数是正数，找他的索引，因为没人访问她，所以索引就是缺失的数
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                missing = i + 1;//要加上1，因为都是按照减一的规则变负数的
            }
        }
        return new int[]{dup, missing};
    }
}