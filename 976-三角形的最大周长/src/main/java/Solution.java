/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import java.util.Arrays;

/**
 * 类Solution.java的实现描述：滑动窗口
 *
 * @author wubiao21 2020年08月20日 10:38:52
 */
public class Solution {
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        int right = A.length - 1;//因为排序的顺序是升序，我们滑动窗口从右往左滑动
        int left = A.length - 1;
        while (left >= 0) {
            left--;//扩张窗口
            int len = right - left;//有效区间(left,right]
            if (len == 3) {//窗口内有3个变量的时候
                int sum = A[left + 1] + A[left + 2];
                if (sum > A[right]) {//如果两边之和大于第三边，返回结果
                    return sum + A[right];
                } else {//否则的话窗口缩小一个，去掉最右边的值
                    right--;
                }
            }
        }
        return 0;
    }
}