/**
 * @author WuBiao
 * @date 2020/3/17 21:24
 */
public class Solution {
    /**
     * @param word1
     * @param word2
     * @return int
     * @description 动态规划
     * @author WuBiao
     * @date 2020/3/17 21:49
     */
    public int minDistance(String word1, String word2) {
        if (word1 == null && word2 == null) {
            return 0;
        }
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) {
                    dp[i][j] = j;//初始化边界
                } else if (j == 0) {
                    dp[i][j] = i;//初始化边界
                } else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        return dp[m][n];
    }
}
//动态规划
//dp[i][j],表示word1前i个字符和word2前j个字符的最短距离

//dp[i][j]=dp[i-1][j-1] if(word1[i-1]=word2[j-1])
//dp[i][j]=min(dp[i-1][j-1],dp[i-1][j],dp[i][j-1])+1
//dp[i-1][j-1]代表替换word[i]
//dp[i-1][j]代表第一个单词的前i-1位变成第二个单词的前j位，然后再删去一个字符
//dp[i][j-1]代表第一个单词的前i位变成第二个单词的前j-1位，再插入一位