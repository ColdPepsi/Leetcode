/**
 * @author WuBiao
 * @date 2020/3/10 11:27
 */
public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = -1;
        int count = 0;
        for (int num : nums) {
            count = (num == 0 ? 0 : count + 1);//当前元素为0的话就重新开始计数，不为0就加1
            max = Math.max(count, max);
        }
        return max;
    }
}