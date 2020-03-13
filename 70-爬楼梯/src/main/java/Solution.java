/**
 * @author WuBiao
 * @date 2020/3/13 20:53
 */
public class Solution {
    /**
     * @param n
     * @return int
     * @description 斐波那契改成循環
     * @author WuBiao
     * @date 2020/3/13 20:59
     */
    public int climbStairs(int n) {
        if (n < 3) {
            return n;
        }
        int pre1 = 1, pre2 = 2;
        int current = 0;
        for (int i = 3; i <= n; i++) {
            current = pre1 + pre2;
            pre1 = pre2;
            pre2 = current;
        }
        return current;
    }
}