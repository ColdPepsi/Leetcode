/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * 类Solution.java的实现描述：动态规划解法，把数组分成n%k个块，每个块k个元素，每个窗口可能占用一个块或者横跨两个块
 *
 * @author wubiao21 2020年08月24日 09:50:42
 */
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (len * k == 0) {
            return new int[]{0};
        }
        if (k == 1) {
            return nums;
        }
        int[] left = new int[len];//left[i]表示从块的开始到下标i的最大元素，方向从左到右
        int[] right = new int[len];//right[i]表示从块的结尾到下标i的最大元素，方向从右到左
        left[0] = nums[0];
        right[len - 1] = nums[len - 1];
        for (int i = 1; i < len; i++) {
            if (i % k == 0) {//每个块的开始
                left[i] = nums[i];
            } else {
                left[i] = Math.max(left[i - 1], nums[i]);
            }
            int j = len - 1 - i;
            if ((j + 1) % k == 0) {//j是本块的结束位置
                right[j] = nums[j];
            } else {
                right[j] = Math.max(right[j + 1], nums[j]);
            }
        }
        int resLen = len - k + 1;
        int[] res = new int[resLen];
        for (int i = 0; i < resLen; i++) {
            //当横跨两个块时候，right[i]表示左块的最大值，left[i+k-1]表示右块的最大值，合一起就是最大值
            res[i] = Math.max(left[i + k - 1], right[i]);//i+k-1是当前窗口最后一个元素
        }
        return res;
    }
}
/*https://leetcode-cn.com/problems/sliding-window-maximum/solution/hua-dong-chuang-kou-zui-da-zhi-by-leetcode-3/*/