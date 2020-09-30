/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 类Solution.java的实现描述：模仿最长递增子序列的写法
 *
 * @author wubiao21 2020年09月28日 11:27:20
 */
public class Solution {
    public int longestArithSeqLength(int[] A) {
        if (A == null || A.length < 3) {
            return 0;
        }
        int len = A.length;
        int ans = 2;
        Map<Integer, Integer>[] dp = new Map[len];//dp[i]表示以A[i]结尾的最长等差数列，其中hashmap的key是差，value是值
        for (int i = 0; i < len; i++) {
            dp[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                int diff = A[i] - A[j];//和前面元素的差
                int count = dp[j].getOrDefault(diff, 0);
                if (count == 0) {//如果前面元素以前没有过这个差，说明 A[i]和A[j]两个元素先暂时一个序列
                    dp[i].put(diff, 2);
                } else {//有的话长度加1
                    dp[i].put(diff, count + 1);
                }
                ans = Math.max(ans, dp[i].get(diff));
            }
        }
        return ans;
    }
}