/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * 类Solution.java的实现描述：旋转数组有重复元素  二分法解
 *
 * @author wubiao21 2020年07月23日 11:09:36
 */
public class Solution {
    /**
     * 旋转数组如果不考虑特殊情况，左部分是整体大于右边部分
     *
     * @param numbers
     * @return
     */
    public int minArray(int[] numbers) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 3456712
            if (numbers[mid] < numbers[right]) {
                right = mid;//最小值不会出现在右边 如果最小值在(mid...right]，num[mid]需要大于num[right] 不符合，说明最小值在[left...mid]中
            } else if (numbers[mid] > numbers[right]) {
                left = mid + 1;//最小值在(mid...rigth]中
            } else {
                right--;//此时不能确定结果，r-- 缩小区间
            }
        }
        return numbers[left];
    }
}