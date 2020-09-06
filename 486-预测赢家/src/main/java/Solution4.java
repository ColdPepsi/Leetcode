/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * 类Solution4.java的实现描述：动态规划空间压缩，其实意义不大
 *
 * @author wubiao21 2020年09月01日 14:52:51
 */
public class Solution4 {
    public boolean PredictTheWinner(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (i == j) {
                    dp[j] = nums[j];
                } else {
                    dp[j] = Math.max(nums[i] - dp[j], nums[j] - dp[j - 1]);
                }
            }
        }
        return dp[len - 1] >= 0;
    }
}