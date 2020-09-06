/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * 类Solution.java的实现描述：滑动窗口
 *
 * @author wubiao21 2020年09月01日 16:01:59
 */
public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int len = nums.length;
        int minInterval = len + 1;
        int left = 0, right = 0;
        //[left,right)
        int sum = 0;
        while (right < len) {
            sum += nums[right++];
            while (sum >= s) {
                minInterval = Math.min(minInterval, right - left);//记录区间最短长度
                sum -= nums[left++];
            }
        }
        return minInterval == len + 1 ? 0 : minInterval;
    }
}