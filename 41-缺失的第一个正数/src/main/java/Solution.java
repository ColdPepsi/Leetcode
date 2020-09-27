/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * 类Solution.java的实现描述：要找的数一定在[1,n+1]中，数组下标[0,n-1]，我们把数i放在下标i-1的位置，没有正确放置的数就是所要找的结果
 * n+1这个数不用特别判断，因为最后如果没有输出[1,n]，我们就输出n+1。[1,n]正好满足下标[0,n-1]
 *
 * @author wubiao21 2020年09月14日 09:53:34
 */
public class Solution {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            while (1 <= nums[i] && nums[i] <= len && nums[nums[i] - 1] != nums[i]) {//如果nums[i]在正确的数字范围，并且没放在正确的位置
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < len; i++) {//找到第一个下标位置没放置正确值的数
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return len + 1;
    }

    /**
     * 交换num数组下标i和j的元素
     *
     * @param nums
     * @param i
     * @param j
     */
    private void swap(int[] nums, int i, int j) {
        nums[i] += nums[j];
        nums[j] = nums[i] - nums[j];
        nums[i] -= nums[j];
    }
}