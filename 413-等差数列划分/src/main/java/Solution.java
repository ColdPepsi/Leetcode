/**
 * @author WuBiao
 * @date 2020/3/14 16:28
 */
public class Solution {
    /**
     * @param A
     * @return int
     * @description 动态规划，d[i]表示以A[i]结尾的等差数列的个数
     * @author WuBiao
     * @date 2020/3/14 17:00
     */
    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length < 3) {
            return 0;
        }
        int[] dp = new int[A.length];
        int res = 0;
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                //A[i-2],A[i-1],A[i]构成一个新的等差数列
                dp[i] = dp[i - 1] + 1;
                res += dp[i];//因为等差数列不一定以最后一个元素结尾，所以需要把前面的结果累加。
            }
            //否则的话 dp[i]=0;
        }
        return res;
    }
}