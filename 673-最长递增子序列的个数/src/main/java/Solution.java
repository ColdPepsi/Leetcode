/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * 类Solution.java的实现描述：再复习一遍最长递增子序列吧
 *
 * @author wubiao21 2020年09月27日 15:24:25
 */
public class Solution {
    public int findNumberOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];//dp[i]表示以nums[i]结尾的最长递增序列长度
        int[] count = new int[len];//count[i]表示以nums[i]结尾的最长递增序列长度为dp[i]有几个
        int maxLen = 0;//保存最大长度
        for (int i = 0; i < len; i++) {
            dp[i] = 1;
            count[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] >= dp[i]) {//找到更长的长度
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];//原来有几个，现在还是有几个，只不过是把nums[i]加在原来最长序列的最后，最后个数不会增加
                    } else if (dp[j] + 1 == dp[i]) {//说明此时出现了重复的nums[i]结尾的最长递增序列长度为dp[i]的序列
                        count[i] += count[j];
                    }
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        int ans = 0;
        for (int i = 0; i < len; i++) {
            if (dp[i] == maxLen) {
                ans += count[i];//计算总和
            }
        }
        return ans;
    }
}