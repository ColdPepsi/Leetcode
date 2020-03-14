/**
 * @author WuBiao
 * @date 2020/3/14 20:11
 */
public class Solution {
    /**
     * @param s
     * @return int
     * @description 动态规划dp[i]表示s[0...i-1]的解码总数，考虑s[i]和s[i-1]是分开编码还是组合编码
     * @author WuBiao
     * @date 2020/3/14 21:42
     */
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        int[] dp = new int[s.length() + 1];//dp[i]表示s[0...i-1]的解码总数
        dp[0] = 1;//dp的长度长一位，方便初始化
        dp[1] = 1;
        for (int i = 1; i < s.length(); i++) {//从第二个字符开始算
            if (s.charAt(i) == '0') {//s[i]==0,只能和s[i-1]合并编码，所以s[i-1]只能是1或2
                if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2') {
                    //当s[i]和s[i-1]合并编码时
                    dp[i + 1] = dp[i - 1];
                } else {
                    return 0;//编码出错，直接返回0
                }
            } else if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2' && s.charAt(i) > '0' && s.charAt(i) <= '6') {
                //s[i-1]为1或者 s[i-1]=2且0<s[i]<7;此时s[i]和s[i-1]既能合并编码，也能分开编码
                dp[i + 1] = dp[i - 1] + dp[i];//dp[i-1]为合并编码，dp[i]为分开编码，两种结果要加一起
            } else {//s[i-1]不等于1，且 s[i-1]s[i]为29，45这种情况，只能分开编码
                dp[i + 1] = dp[i];//分开编码把s[i]加到前面的结果集中即可，不会增加情况
            }
        }
        return dp[s.length()];
    }
}
