/**
 * @author WuBiao
 * @date 2020/3/30 14:17
 */
public class Solution {
    /**
     * @param nums
     * @return int[]
     * @description n&(-n)可以得到n最低位为1的那个数，其余位全为0
     * @author WuBiao
     * @date 2020/3/30 14:23
     */
    public int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        int diff = 0;
        for (int num : nums) {
            diff ^= num;//运算完后diff为不同的两个数异或的结果
        }
        diff &= (-diff);//n&(-n)可以得到n最低位为1的那个数，其余位全为0
        for (int num : nums) {//通过这一位来区分成两组，分别异或操作
            if ((num & diff) == 0) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }
        return res;
    }
}