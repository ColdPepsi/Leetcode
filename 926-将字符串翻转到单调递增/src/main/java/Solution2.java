/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * 类Solution2.java的实现描述：动态规划的状态压缩，因为dp[i]只与dp[i-1]有关,时间复杂度一样，凡是用单变量，访问速度会加快很多
 *
 * @author wubiao21 2020年09月07日 20:15:37
 */
public class Solution2 {
    public int minFlipsMonoIncr(String S) {
        char[] chars = S.toCharArray();
        int zero = 0;//代表dp[i][0]
        int one = 0;//代表dp[i][1]
        for (char aChar : chars) {
            if (aChar == '1') {
                one = Math.min(zero, one);
                zero = zero + 1;
            } else {
                one = Math.min(zero, one) + 1;
            }
        }
        return Math.min(zero, one);
    }
}