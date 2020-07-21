/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * 类Solution2.java的实现描述：动态规划解法
 *
 * @author wubiao21 2020年07月20日 09:11:34
 */
public class Solution2 {
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int[] newNums = new int[len + 2];
        System.arraycopy(nums, 0, newNums, 1, len);
        newNums[0] = 1;//加上边界
        newNums[len + 1] = 1;
        len += 2;
        int[][] dp = new int[len][len];//dp[i][j]的定义与前面分治函数的定义相同
        //dp[i][j]=max{dp[i][k]+dp[k][j]+newNums[i]*newNums[k]*newNums[j]}  ,  i<k<j
        //dp[i][j]由自己所在行的左边和自己所在列的下边决定
        for (int i = len - 2; i >= 0; i--) {//i倒着遍历，i不用从最后一行开始，因为j要比i大，i==最后一行的话，j没法取值了
            for (int j = i + 2; j < len; j++) {
                int max = 0;//记录最大值
                for (int k = i + 1; k < j; k++) {  //i<k<j
                    int temp = dp[i][k] + dp[k][j] + newNums[i] * newNums[k] * newNums[j];//动态转移方程
                    max = Math.max(max, temp);
                }
                dp[i][j] = max;
            }
        }
        return dp[0][len - 1];
    }
}