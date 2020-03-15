/**
 * @author WuBiao
 * @date 2020/3/15 21:47
 */
public class Solution {
    /**
     * @param text1
     * @param text2
     * @return int
     * @description 动态规划
     * @author WuBiao
     * @date 2020/3/15 22:04
     */
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text1.length() == 0 || text2 == null || text2.length() == 0) {
            return 0;
        }
        int len1 = text1.length(), len2 = text2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];//多申请一行一列作为边界
        //dp[i][j]表示text1[i-1],text2[j-1]之前的最长公共子序列
        for (int i = 1; i <= len1; i++) {//第一行第一列 全部初始化为0
            for (int j = 1; j <= len2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[len1][len2];
    }
}