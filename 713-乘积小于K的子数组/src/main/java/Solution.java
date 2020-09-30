/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * 类Solution.java的实现描述：滑动窗口
 *
 * @author wubiao21 2020年09月28日 16:59:41
 */
public class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int count = 0;
        int product = 1;
        //窗口区间是左闭右开
        while (right < nums.length) {
            product *= nums[right++];
            while (product >= k) {
                product /= nums[left++];
            }
            //此时窗口内有right-left个元素，并且窗口内累积乘小于k
            //所以[left,right)、[left+1,right)、[left+2,right)等等乘积都是小于k的，因为窗口内都是正数，一共k个以nums[right-1]结尾的子数组
            count += right - left;
        }
        return count;
    }
}