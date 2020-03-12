/**
 * @author WuBiao
 * @date 2020/3/12 22:09
 */
public class Solution {
    /**
     * @param n
     * @return boolean
     * @description 判断一个数，是否是2的n次幂
     * @author WuBiao
     * @date 2020/3/12 22:11
     */
    public boolean isPowerOfTwo(int n) {
        //Integer.bitCount（）返回一个数二进制中1的个数，2的n次幂只有最高位为1其余都为0
        return n > 0 && Integer.bitCount(n) == 1;
    }
}