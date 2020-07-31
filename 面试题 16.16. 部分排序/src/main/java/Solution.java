/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * @author wubiao21 2020年07月30日 11:16:11
 */
public class Solution {
    /**
     * 题目要求是升序，如果一个数右边存在比他小的数，则他一定会加入到排序中
     * 如果一个数左边存在比他大的数，那么他也一定会加入到排序中
     *
     * @param array
     * @return
     */
    public int[] subSort(int[] array) {
        if (array.length < 2) {
            return new int[]{-1, -1};
        }
        int left = -1, right = -1;
        int len = array.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            //先寻找最靠右的数，从做到右寻找
            if (array[i] < max) {//说明array[i]左边存在比他大的数
                right = i;
            } else {
                max = array[i];
            }
            //下面寻找最靠左的数，从右到左寻找
            int tempIndex = len - 1 - i;
            if (array[tempIndex] > min) {//说明当前数的右边出现比他小的数
                left = tempIndex;
            } else {
                min = array[tempIndex];
            }
        }
        return new int[]{left, right};//返回结果
    }
}