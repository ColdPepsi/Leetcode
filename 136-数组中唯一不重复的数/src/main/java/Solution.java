/**
 * @author WuBiao
 * @date 2020/3/12 22:03
 */
public class Solution {
    /**
     * @param nums
     * @return int
     * @description 依次异或操作
     * @author WuBiao
     * @date 2020/3/12 22:04
     */
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }
}