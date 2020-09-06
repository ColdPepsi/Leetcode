/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import java.util.Arrays;

/**
 * 类Solution.java的实现描述：前缀和
 *
 * @author wubiao21 2020年08月31日 16:48:06
 */
public class Solution {
    static class Pair {
        int index;
        int preSum;

        public Pair(int _index, int _preSum) {
            index = _index;
            preSum = _preSum;
        }
    }

    /**
     * 求最接近0的区间和
     *
     * @param nums
     * @return 返回区间左右端点拼成的数组
     */
    public int[] subarraySumClosest(int[] nums) {
        int[] result = new int[]{0, 0};
        if (nums == null || nums.length < 2) {
            return result;
        }
        int length = nums.length;
        Pair[] prefixSum = new Pair[length];//前缀和数组，prefixSum[i]等于num[0...i]的和
        prefixSum[0] = new Pair(0, nums[0]);
        for (int i = 1; i < length; i++) {
            prefixSum[i] = new Pair(i, prefixSum[i - 1].preSum + nums[i]);
        }
        Arrays.sort(prefixSum, (a, b) -> a.preSum != b.preSum ? a.preSum - b.preSum : a.index - b.index);
        int minSum = Integer.MAX_VALUE;
        //排序后最接近的两个前缀和做差就是最小的区间和
        for (int i = 0; i < length; i++) {
            if (prefixSum[i].preSum == 0) {
                return new int[]{0, prefixSum[i].index};
            }
            if (i > 0 && prefixSum[i].preSum - prefixSum[i - 1].preSum < minSum) {
                minSum = prefixSum[i].preSum - prefixSum[i - 1].preSum;
                result[0] = Math.min(prefixSum[i - 1].index, prefixSum[i].index) + 1;
                result[1] = Math.max(prefixSum[i - 1].index, prefixSum[i].index);
            }
        }
        return result;
    }
}