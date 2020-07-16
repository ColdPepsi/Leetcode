/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * @author wubiao21 2020年07月14日 17:40:46
 */
public class Solution {
    /**
     * 用31题的思想，一直求下一个排列，新循环k-1次
     */
    public String getPermutation(int n, int k) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        for (int i = 1; i < k; i++) {
            nextPermutation(nums);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int num : nums) {
            stringBuilder.append(num);
        }
        return stringBuilder.toString();
    }

    private void swap(int[] nums, int i, int j) {
        nums[i] += nums[j];
        nums[j] = nums[i] - nums[j];
        nums[i] -= nums[j];
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    /**
     * 返回nums的下一个排列，第31题
     *
     * @param nums 数组
     */
    private void nextPermutation(int[] nums) {
        int len = nums.length;
        int i = len - 1;
        while (i > 0 && nums[i - 1] >= nums[i]) {
            i--;
        }
        reverse(nums, i, len - 1);
        if (i > 0) {
            int left = i, right = len - 1;
            while (left < right) {
                int mid = (right - left) / 2 + left;
                if (nums[mid] > nums[i - 1]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            swap(nums, i - 1, left);
        }
    }
}