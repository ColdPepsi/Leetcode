/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 类Solution.java的实现描述：前缀和
 *
 * @author wubiao21 2020年09月10日 13:54:09
 */
public class Solution {
    public int numSubarraysWithSum(int[] A, int S) {
        int sum = 0;
        for (int i = 1; i < A.length; i++) {//A[i]表示A[0...i]的前缀和
            A[i] += A[i - 1];
        }
        Map<Integer, Integer> preSumCount = new HashMap<>(A.length);//保存某个前缀和出现的次数
        preSumCount.put(0, 1);// A[i...j]的前缀和等于A[j]-A[i-1]，但是i==0时候需要用到A[-1]，此时我们设A[-1]==0，即0的前缀和出现1次
        int ans = 0;
        for (int preSum : A) {
            ans += preSumCount.getOrDefault(preSum - S, 0);//看看前面preSum - S这个前缀和出现多少次，因为 preSum-(preSum-S)就是区间和为s的子数组
            preSumCount.put(preSum, preSumCount.getOrDefault(preSum, 0) + 1);
        }
        return ans;
    }
}