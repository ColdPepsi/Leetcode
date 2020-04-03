/**
 * @author WuBiao
 * @date 2020/4/3 15:54
 */
public class Solution {
    /**
     * @param s
     * @return int
     * @description 动态规划
     * @author WuBiao
     * @date 2020/4/3 16:17
     */
    public int longestPalindromeSubseq(String s) {
        if (s.length() < 2) {
            return s.length();
        }
        int len = s.length();
        int[][] dp = new int[len][len];//dp[i,j]表示s[i,j]之间的最长回文子序列长度
        for (int i = len - 2; i >= 0; i--) {//i要倒着来，因为得利用以前算出的结果
            dp[i][i] = 1;
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i < 3) {//在这种情况下s[i,j]肯定是回文
                        dp[i][j] = j - i + 1;
                    } else {//如果直接用此公式，当j=i+1时候，dp[i+1][j-1]会越界。因为i+1>j-1;
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    }
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][len - 1];
    }
}