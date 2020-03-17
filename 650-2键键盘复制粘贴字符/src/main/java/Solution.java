/**
 * @author WuBiao
 * @date 2020/3/17 22:16
 */
public class Solution {
    public int minSteps(int n) {
        int[] dp = new int[n + 1];
        int h = (int) Math.sqrt(n);
        for (int i = 2; i <= n; i++) {
            dp[i] = i;//设成最差情况，n是质数，一个一个粘贴
            for (int j = 2; j <= h && j <= i; j++) {
                if (i % j == 0) {
                    //如果j是i的因子
                    dp[i] = dp[j] + dp[i / j];
                }
            }
        }
        return dp[n];
    }
}
//每一个操作序列都可以看成以copy开头paste结尾的子序列
//假如我们把序列分解成s1和s2两个序列，字符串长度分别为len1，len2，
//执行完s1操作后，现在有len1个A
//接着执行s2，现在有len1*len2个A

//dp[i]表示生成i个A最少的操作,dp[1]==0；因为已经存在一个A了
// 假设 j是i的因子，dp[i]=dp[j]+dp[i/j];