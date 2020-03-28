/**
 * @author WuBiao
 * @date 2020/3/28 19:31
 */
public class Solution {
    /**
     * @param n
     * @return boolean
     * @description 在整型范围内，3的幂最大值是1162261467
     * @author WuBiao
     * @date 2020/3/28 19:32
     */
    public boolean isPowerOfThree(int n) {
        return n > 0 && (1162261467 % n == 0);
    }
}