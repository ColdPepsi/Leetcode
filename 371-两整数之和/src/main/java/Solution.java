/**
 * @author WuBiao
 * @date 2020/3/30 17:14
 */
public class Solution {
    /**
     * @param a
     * @param b
     * @return int
     * @description a ^ b 表示没有考虑进位的情况下两数的和，(a & b) << 1 就是进位。
     * @author WuBiao
     * @date 2020/3/30 17:16
     */
    public int getSum(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return getSum(a ^ b, (a & b) << 1);
        }
    }
}