/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * 类Solution.java的实现描述：双指针
 *
 * @author wubiao21 2020年10月16日 09:44:38
 */
public class Solution {
    public int[] sortedSquares(int[] A) {
        int len = A.length;
        int[] ret = new int[len];
        if (A[0] >= 0) {//此时ret递增
            int index = 0;
            for (int num : A) {
                ret[index++] = num * num;
            }
        } else {//A的平方先递减再递增
            for (int left = 0, right = len - 1; left <= right; ) {
                int lefts = A[left] * A[left];
                int rights = A[right] * A[right];
                if (lefts <= rights) {
                    ret[--len] = rights;
                    right--;
                } else {
                    ret[--len] = lefts;
                    left++;
                }
            }
        }
        return ret;
    }
}