/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * 类Solution.java的实现描述：打家劫舍变种
 *
 * @author wubiao21 2020年09月30日 10:54:51
 */
public class Solution {
    public int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int maxNum = 0;//数组中最大的数
        for (int num : nums) {
            maxNum = Math.max(maxNum, num);
        }
        int[] count = new int[maxNum + 1];
        for (int num : nums) {//统计每个数字出现的次数
            count[num]++;
        }
        int[] dp = new int[maxNum + 1];//dp[num]表示截止到数num，所能获得的最大点数
        dp[1] = count[1];//只有数字1的话，数字1出现几次 就是分数值
        for (int num = 2; num <= maxNum; num++) {
            dp[num] = Math.max(dp[num - 1], dp[num - 2] + num * count[num]);//取不要当前数和要当前数的最大点数
        }
        return dp[maxNum];
    }
}