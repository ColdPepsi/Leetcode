/**
 * 动态规划
 *
 * @author WuBiao
 * @date 2020/7/18 22:36
 */
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length(), len2 = s2.length(), len3 = s3.length();
        if (len1 + len2 != len3) {
            return false;
        }
        //dp[i][j]表示s1[0...i-1]和s2[0...j-1]是否交错组成s3[0...i+j-1]
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true;//下面开始初始化边界
        for (int i = 1; i <= len1 && s1.charAt(i - 1) == s3.charAt(i - 1); i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= len2 && s2.charAt(i - 1) == s3.charAt(i - 1); i++) {
            dp[0][i] = true;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                int k = i + j - 1;
                //如果 s1[i-1]==s3[k],则s1[0..i-1]和s2[0...j-1]能否交错组成s3[0...k]取决于
                // s1[0...i-2]和s2[0...j-1]有没有交错组成s3[0...k-1]即dp[i-1][j]的值
                //s2同理
                dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(k) ||
                        dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(k);
            }
        }
        return dp[len1][len2];
    }
}