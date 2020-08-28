/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * 类Solution.java的实现描述：把数组二分，总有一部分是有序的
 *
 * @author wubiao21 2020年08月24日 13:52:40
 */
public class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= nums[mid]) {//说明数组左半部分是有序的
                if (nums[0] <= target && target < nums[mid]) {//target在左区间内
                    right = mid - 1;//缩小right，去左区间寻找
                } else {
                    left = mid + 1;
                }
            } else {//右半部分是有序的
                if (nums[mid] < target && target <= nums[right]) {//target在右区间内
                    left = mid + 1;//缩小left，取右区间寻找
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}