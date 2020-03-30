/**
 * @author WuBiao
 * @date 2020/3/30 14:32
 */
public class Solution {
    /**
     * @param n
     * @return int
     * @description 利用位运算
     * @author WuBiao
     * @date 2020/3/30 14:36
     */
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1;//res右移一位，最低位为0
            res |= n & 1;//n&1取出n的最低位，加到res的最低位
            n >>>= 1;//n右移一位，去掉最低位,>>>为无符号右移，最高位补0
        }
        return res;
    }
}