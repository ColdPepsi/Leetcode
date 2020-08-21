/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * 类Solution.java的实现描述：动态规划解法，超时
 *
 * @author wubiao21 2020年08月20日 11:15:31
 */
public class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int[] dp = new int[arr.length];//dp[i]表示以arr[i]结尾的最长定长子序列；
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;//自己是一个序列
            for (int j = 0; j < i; j++) {
                if (arr[i] - arr[j] == difference && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}