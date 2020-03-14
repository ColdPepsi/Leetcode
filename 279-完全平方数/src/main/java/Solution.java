/**
 * @author WuBiao
 * @date 2020/3/14 19:12
 */
public class Solution {
    /**
     * @param n
     * @return int
     * @description 动态规划，转移方程：dp[i]=min（dp[i-j*j]+1）
     * @author WuBiao
     * @date 2020/3/14 19:54
     */
    public int numSquares(int n) {
        int[] dp = new int[n + 1];//dp[i]表示i最少由d[i]个完全平方数组成
        for (int i = 1; i <= n; i++) {
            dp[i] = i;//最坏的结果，表示i由i个1相加组成；
            for (int j = 1; i - j * j >= 0; j++) {//不能是i - j * j > 0，当i-j*j==0时候，i=j*j，所以dp[i]==1
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);//dp[i]取最小值
            }
        }
        return dp[n];
    }
}
//n可以被分解为某个数+一个完全平方数的和,设d+k*k=n,因为k*k为完全平方数，所以f（k）==1；
//f（d）+f(k*k)=f(n),化简得到f（n）=f(n-k*k)+1;dp[i]=dp[x]+1;