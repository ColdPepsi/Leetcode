/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * 类Solution.java的实现描述：计数排序
 *
 * @author wubiao21 2020年10月26日 10:15:40
 */
public class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int len = nums.length;
        int[] ret = new int[len];
        int[] count = new int[101];
        for (int num : nums) {
            count[num]++;
        }
        int pre = 0;
        for (int i = 0; i < 101; i++) {
            int temp = pre + count[i];
            count[i] = pre;
            pre = temp;
        }
        for (int i = 0; i < len; i++) {
            ret[i] = count[nums[i]];
        }
        return ret;
    }
}