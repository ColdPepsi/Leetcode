/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * 类Solution.java的实现描述：动态规划
 *
 * @author wubiao21 2020年09月17日 15:12:12
 */
public class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int res = 0;
        int[] dp = new int[chars.length];//dp[i]表示以chars[i]为序列最后一个元素的最长有效括号长度
        //以‘（’结尾的有效括号长度为0，只考虑以‘）’结尾的元素
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == ')') {
                if (chars[i - 1] == '(') {
                    //dp[i]=dp[i-2]+2;
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;//主要是为了保证i-2>=0
                } else {//chars[i - 1] == ')',[i-dp[i-1],i-1]构成一个最小子串，chars[i] == ')'，若要构成合法括号，需要char[i-dp[i-1]-1]=='('
                    if (i - dp[i - 1] > 0 && chars[i - dp[i - 1] - 1] == '(') {
                        //dp[i] = dp[i - 1] + 2 + dp[i - dp[i - 1] - 2];
                        //dp[i-1]+2就是[i-dp[i-1]-1,i]最长的有效子串，相当于在dp[i-1]这个子串外层包了一层（）
                        //dp[i - dp[i - 1] - 2]就是i-dp[i-1]-1前面的最长的子串，万一连续要加上
                        dp[i] = dp[i - 1] + 2 + ((i - dp[i - 1] - 2 >= 0) ? dp[i - dp[i - 1] - 2] : 0);
                    }
                }
                res = Math.max(res, dp[i]);
            }
        }
        return res;
    }
}