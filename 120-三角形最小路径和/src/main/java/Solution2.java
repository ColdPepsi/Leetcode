/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import java.util.List;

/**
 * 类Solution2.java的实现描述：压缩空间版
 *
 * @author wubiao21 2020年07月14日 09:33:21
 */
public class Solution2 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        int[] dp = new int[len];//用一维空间计算
        for (int i = 0; i < len; i++) {
            dp[i] = triangle.get(len - 1).get(i);//初始化
        }
        for (int i = len - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}