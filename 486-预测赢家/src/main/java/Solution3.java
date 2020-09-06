/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * 类Solution3.java的实现描述：动态规划解法，其实动态规划就是把前面Solution2递归改成循环的过程
 *
 * @author wubiao21 2020年09月01日 14:36:20
 */
public class Solution3 {
    public boolean PredictTheWinner(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[len][len];//dp[i...j]代表在区间[i,j]内，先手比后手多得的分数
        for (int i = 0; i < len; i++) {
            dp[i][i] = nums[i];//初始化边界
        }
        for (int i = len - 2; i >= 0; i--) {//注意填表顺序，因为dp[i][j]会由其左边和下边元素决定，所以我们从下往上，从左到右
            for (int j = i + 1; j < len; j++) {
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][len - 1] >= 0;
    }
}