/**
 * @author WuBiao
 * @date 2020/3/25 20:17
 */
public class Solution {
    /**
     * @param s
     * @return java.lang.String
     * @description 动态规划
     * @author WuBiao
     * @date 2020/3/25 20:40
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {//长度小于2肯定是回文串
            return s;
        }
        int len = s.length();
        boolean[][] dp = new boolean[len][len];//dp[i][j]表示s[i:j]是否是回文
        int max = 1;
        int startIndex = 0;//记录下最长子串起始坐标
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
/*        for (int L = 2; L <= len; L++) {//枚举子串的长度，从2开始
            for (int i = 0; i + L - 1 < len; i++) {//枚举子串的起始端点
                int j = i + L - 1;//区间右端点
                if (s.charAt(i) == s.charAt(j)) {
                    if (j-i<3){// (j-1)-(i+1)+1<2推出j-i<3
                        dp[i][j]=true;//s[i+1:j-1]只有1个字符作者空串时候
                    }else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                } else {
                    dp[i][j] = false;
                }
                if (dp[i][j]) {
                    //表示s[i:j]是否是回文
                    if (L > max) {
                        max = L;//记录下最大长度
                        startIndex = i;
                    }
                }
            }
        }*/
        for (int i=len-2;i>=0;i--){//注意填表顺序
            for (int j=len-1;j>i;j--){
                if (s.charAt(i) == s.charAt(j)) {
                    if (j-i<3){// (j-1)-(i+1)+1<2推出j-i<3
                        dp[i][j]=true;//s[i+1:j-1]只有1个字符作者空串时候
                    }else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                } else {
                    dp[i][j] = false;
                }
                if (dp[i][j]) {
                    //表示s[i:j]是回文
                    if (j-i+1 > max) {
                        max = j-i+1;//记录下最大长度
                        startIndex = i;
                    }
                }
            }
        }
        return s.substring(startIndex, startIndex + max);//返回最长子串
    }
}