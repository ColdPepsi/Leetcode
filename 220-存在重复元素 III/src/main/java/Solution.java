/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * 暴力解法
 *
 * @author wubiao21 2020年07月16日 19:54:06
 */
public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || t < 0) {
            return false;
        }
        int len = nums.length;
        k = Math.min(k, len - 1);
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= i + k && j < len; j++) {
                if (Math.abs((double) nums[i] - (double) nums[j]) <= t) {//double防止溢出
                    return true;
                }
            }
        }
        return false;
    }
}