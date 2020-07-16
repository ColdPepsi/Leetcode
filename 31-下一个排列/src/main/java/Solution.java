/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * @author wubiao21 2020年07月14日 18:48:14
 */
public class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int len = nums.length;
        int i = len - 1;
        while (i > 0 && nums[i - 1] >= nums[i]) {//从后往前找到第一个递增对 nums[i-1],nums[i]
            i--;
        }//如果nums完全逆序，则退出循环的时候，i==0；
        if (i != 0) {
            /*int j = len - 1;
            while (j >= i && nums[j] <= nums[i - 1]) {//从后往前，找到第一个大于nums[i-1]的数 nums[j]
                j--;
            }
            swap(nums, i - 1, j);//交换 nums[i-1],nums[j]，此时nums[i...len-1]是降序*/
            /*nums[i...len-1]是降序,我们寻找最后一个大于nums[i-1]的数，相当于升序寻找第一个大于nums[i-1]的数，upper_bound函数
            使用二分法来加速*/
            //或者是先翻转nums[i...len-1]，再用upper_bound找到第一个大于nums[i-1]的数，再交换
            int left = i, right = len - 1;
            while (left < right) {
                int mid = (int) Math.ceil(left + (right - left) / 2.0);//当区间中点有两个时候，让mid指向右中点
                if (nums[mid] > nums[i - 1]) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
            swap(nums, i - 1, left);
        }
        reverse(nums, i, len - 1);//逆序nums[i...len-1]，使之成为升序
    }

    /**
     * 交换nums[i]与nums[j]的值
     *
     * @param nums 数组
     * @param i    下标1
     * @param j    下标2
     */
    private void swap(int[] nums, int i, int j) {
        nums[i] += nums[j];
        nums[j] = nums[i] - nums[j];
        nums[i] -= nums[j];
    }

    /**
     * 把nums[left...right]逆置
     *
     * @param nums  数组
     * @param left  左区间端点
     * @param right 右区间端点
     */
    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}