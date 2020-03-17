/**
 * @author WuBiao
 * @date 2020/3/17 15:22
 */
public class Solution {
    /**
     * @param strs
     * @param m
     * @param n
     * @return int
     * @description 多维度01背包
     * @author WuBiao
     * @date 2020/3/17 15:45
     */
    public int findMaxForm(String[] strs, int m, int n) {
        if (strs == null || strs.length == 0) {
            return 0;
        }
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {//对每个字符串进行测试，都有放与不放两种结果
            int zeros = 0, ones = 0;//计算当前字符串有多少个0和1；
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '0') {
                    zeros++;
                } else {
                    ones++;
                }
            }
            //下面开始动态规划，因为空间优化，优化了第一维，所以要逆序遍历
            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], 1 + dp[i - zeros][j - ones]);//取最大值
                }
            }
        }
        return dp[m][n];
    }
}
//二维01背包问题，把strs中的数组放进背包，限制为m个0和n个1，看看对多能放多少个
//普通的01背包限制条件为背包容量一个维度，本题为0和1个数两个维度
//dp[k][i][j]表示k个字符串，使用i个0和j个1，最多能放多少个装进背包里
//dp[k][i][j]=max（dp[k-1][i][j]，1+dp[k-1][i-当前字符串0的个数][j-减当前字符串1的个数]）；当前第k个字符串不放+放两种情况的最大值
//空间优化的话 可以省掉第一维。
//01背包优化空间，都要逆序遍历