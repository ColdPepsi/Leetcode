/**
 * @author WuBiao
 * @date 2020/4/17 14:44
 */
public class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int len = nums.length;
        int maxIndex = 0;//某点最远能到达的下标
        for (int i = 0; i < len; i++) {
            if (i <= maxIndex) {//说明可以到达i
                maxIndex = Math.max(maxIndex, i + nums[i]);
                if (maxIndex >= len - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}