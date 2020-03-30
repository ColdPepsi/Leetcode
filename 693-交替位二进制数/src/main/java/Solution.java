/**
 * @author WuBiao
 * @date 2020/3/30 16:16
 */
public class Solution {
    /**
     * @param n
     * @return boolean
     * @description 交替出现的二进制位如1010，右移1位变成101，异或变成1111，此时1111&10000==0
     * @author WuBiao
     * @date 2020/3/30 16:17
     */
    public boolean hasAlternatingBits(int n) {
        int temp = n ^ (n >> 1);
        return (temp & (temp + 1)) == 0;
    }
}