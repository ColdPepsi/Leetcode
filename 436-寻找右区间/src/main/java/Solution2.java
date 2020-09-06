/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * 类Solution2.java的实现描述：排序二分
 *
 * @author wubiao21 2020年09月04日 15:19:23
 */
public class Solution2 {
    public int[] findRightInterval(int[][] intervals) {
        int[] ret = new int[intervals.length];
        Map<int[], Integer> position = new HashMap<>(intervals.length);
        for (int i = 0; i < intervals.length; i++) {
            position.put(intervals[i], i);//记录位置
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < ret.length; i++) {
            int left = 0, right = intervals.length;
            while (left < right) {//找到第一个区间左端点大于等于当前区间右端点的
                int mid = (left + right) / 2;
                if (intervals[mid][0] >= intervals[i][1]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            ret[position.get(intervals[i])] = right == intervals.length ? -1 : position.get(intervals[right]);//更新结果
        }
        return ret;
    }
}