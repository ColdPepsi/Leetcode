/**
 * @author WuBiao
 * @date 2020/6/14 23:49
 */
public class Solution2 {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int[] map = new int[n + 1];
        map[1] = 1;
        map[2] = 2;
        return climbStairs(n, map);
    }

    /**
     * @param n
     * @param map
     * @return int
     * @description 带备忘录递归
     * @author WuBiao
     * @date 2020/6/14 23:49
     */
    private int climbStairs(int n, int[] map) {
        if (map[n] != 0) {
            return map[n];
        }
        int res = climbStairs(n - 1, map) + climbStairs(n - 2, map);
        map[n] = res;
        return res;
    }
}
