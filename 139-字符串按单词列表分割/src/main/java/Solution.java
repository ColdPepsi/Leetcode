import java.util.List;

/**
 * @author WuBiao
 * @date 2020/3/17 18:25
 */
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (String word : wordDict) {
                int len = word.length();
                if (i >= len && word.equals(s.substring(i - len, i)) && dp[i - len]) {
                    //如果i前面的len个字符在字典中，并且dp[i - len]为true，则d[i]为true
                    dp[i] = true;
                }
            }
        }
        return dp[n];
    }
}
//dp[i]表示s的前i个字符，可不可以被拆分为字典中的单词
//如果dp[i-j]为true，并且s[j:i]在字典中，则dp[i]为true