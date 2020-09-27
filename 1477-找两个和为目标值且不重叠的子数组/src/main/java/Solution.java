/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * 类Solution.java的实现描述：滑动窗口加动态规划
 *
 * @author wubiao21 2020年09月18日 10:20:30
 */
public class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int left = 0;//区间左端点
        int right = 0;//区间右端点
        int sum = 0;//区间和
        int ans = Integer.MAX_VALUE;
        int[] dp = new int[arr.length];//dp[i]表示截止到arr[i]子数组和等于target的最小区间，不一定以arr[i]结尾,dp[i]==0，表示没有找到区间
        while (right < arr.length) {
            sum += arr[right];
            while (sum > target) {
                sum -= arr[left++];
            }
            if (sum == target) {//此时窗口和为target
                dp[right] = right - left + 1;//先更新dp[right]，记录当前窗口长度，窗口区间为[left,right]
                if (left > 0 && dp[left - 1] != 0) {//因为需要两个区间和，[left,right]之前最小区间和为dp[left+1]
                    ans = Math.min(ans, dp[left - 1] + dp[right]);
                }
            }
            //如果当前dp[right]为0或者区间长度比以前的区间长，直接继承以前的
            if (right > 0 && dp[right - 1] != 0 && (dp[right] == 0 || dp[right] > dp[right - 1])) {
                dp[right] = dp[right - 1];
            }
            right++;
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}