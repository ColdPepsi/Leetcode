/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * 类Solution.java的实现描述：暴力遍历，能通过
 *
 * @author wubiao21 2020年09月04日 14:58:00
 */
public class Solution {
    public int[] findRightInterval(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0];
        }
        int[] ret = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            int end = intervals[i][1];
            int minStart = Integer.MAX_VALUE;
            int index = -1;
            for (int j = 0; j < intervals.length; j++) {
                if (j != i) {
                    if (intervals[j][0] >= end && intervals[j][0] < minStart) {
                        index = j;
                        minStart = intervals[j][0];
                    }
                    if (minStart == end) {
                        break;
                    }
                }
            }
            ret[i] = index;
        }
        return ret;
    }
}