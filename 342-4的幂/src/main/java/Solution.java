/**
 * @author WuBiao
 * @date 2020/3/30 16:05
 */
public class Solution {
    /**
     * @param num
     * @return boolean
     * @description 4的n次幂只有一位为1其余位全为0，且1出现在奇数位上
     * @author WuBiao
     * @date 2020/3/30 16:09
     */
    public boolean isPowerOfFour(int num) {
        return (num > 0) && ((num & (num - 1)) == 0) && ((num & (0xaaaaaaaa)) == 0);
    }
}