/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * 类Solution.java的实现描述：二分查找
 *
 * @author wubiao21 2020年10月21日 16:59:37
 */
public class Solution {
    public int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (right + left) / 2;
            boolean halfEven = (right - mid) % 2 == 0;//除去中间元素，两边元素是否是偶数
            if (nums[mid] == nums[mid + 1]) {//中间元素和他右边相等
                if (halfEven) {//两个子数组长度是偶数，这种情况，单个元素在右半区间
                    left = mid + 2;
                } else {//两个子数组长度是奇数，这种情况，单个元素在左半区间
                    right = mid - 1;
                }
            } else if (nums[mid - 1] == nums[mid]) {//中间元素和他左边相等
                if (halfEven) {//两个子数组长度是偶数，这种情况，单个元素在左半区间
                    right = mid - 2;
                } else {//两个子数组长度是奇数，这种情况，单个元素在右半区间
                    left = mid + 1;
                }
            } else {//中间元素和左右两边元素都不相等，中间元素就是单个元素
                return nums[mid];
            }
        }
        return nums[left];
    }
}