/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import java.util.Arrays;
import java.util.Comparator;

/**
 * 类Solution.java的实现描述：TODO 类实现描述
 *
 * @author wubiao21 2020年09月04日 15:46:26
 */
public class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int left = intervals[0][0];
        int right = intervals[0][1];
        int count = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][1] <= right) {//前面的覆盖后面的
                count++;
            } else if (intervals[i][0] == left) {//后面的覆盖前面的
                count++;
                right = intervals[i][1];
            } else {
                left = intervals[i][0];
                right = intervals[i][1];
            }
        }
        return intervals.length - count;
    }
}