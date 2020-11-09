/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * 类Solution.java的实现描述：单调栈解法
 *
 * @author wubiao21 2020年10月16日 14:32:25
 */
public class Solution {
    public int maxDistToClosest(int[] seats) {
        int len = seats.length;
        int[] leftToRight = new int[len];
        int[] rightToLeft = new int[len];
        int preLeft = len, preRight = len;
        for (int i = 0, j = len - 1; i < len; i++, j--) {
            if (seats[i] == 0) {
                leftToRight[i] = preLeft == len ? len : i - preLeft;
            } else {
                preLeft = i;
            }
            if (seats[j] == 0) {
                rightToLeft[j] = preRight == len ? len : preRight - j;
            } else {
                preRight = j;
            }
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            if (seats[i] == 0) {
                res = Math.max(res, Math.min(leftToRight[i], rightToLeft[i]));
            }
        }
        return res;
    }
}