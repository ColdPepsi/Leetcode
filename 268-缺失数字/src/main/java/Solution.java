/**
 * @author WuBiao
 * @date 2020/3/30 14:04
 */
public class Solution {
    /**
     * @param nums
     * @return int
     * @description 利用下标和数进行异或
     * @author WuBiao
     * @date 2020/3/30 14:10
     */
    public int missingNumber(int[] nums) {
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            res ^= i ^ nums[i];
        }
        return res;
    }
}
//数组中的数是0~n,放在下标[0,n]
//先计算出求出[0,n]的异或值，再分别异或数组中的0~n最后得到的结果就是缺失的数
//异或具有结合律和交换律
//相同的两个数异或，结果为0，0和任何数异或，结果不变