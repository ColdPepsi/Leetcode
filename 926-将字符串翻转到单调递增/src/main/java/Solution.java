/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * 类Solution.java的实现描述：动态规划，很巧妙
 *
 * @author wubiao21 2020年09月07日 19:32:27
 */
public class Solution {
    public int minFlipsMonoIncr(String S) {
        char[] chars = S.toCharArray();
        int len = chars.length;
        int[][] dp = new int[len + 1][2];//dp[i][0]，dp[i][1]表示字符chars[i-1]最终选择0或1的最少翻转次数,dp[0]用作初始值
        for (int i = 1; i <= len; i++) {
            if (chars[i - 1] == '0') {//如果当前位为‘0’
                dp[i][0] = dp[i - 1][0];//因为序列递增，只能从dp[i - 1][0]转化而来，本位无需翻转
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + 1;//本位如果需要翻转为1，前面是0是1都行，选最小的，然后操作次数加1，因为本位要翻转
            } else {//如果当前位为‘1’
                dp[i][0] = dp[i - 1][0] + 1;//本位翻转为0，只能从dp[i - 1][0]转化而来，操作数加1
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]);//当前数位1，前面是0是1都行，且本位无需翻转
            }
        }
        return Math.min(dp[len][0], dp[len][1]);
    }
}