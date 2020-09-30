/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import java.util.Arrays;
import java.util.List;

/**
 * 类Solution.java的实现描述：把每个时间换算成分钟，然后排序
 *
 * @author wubiao21 2020年09月29日 11:26:43
 */
public class Solution {
    public int findMinDifference(List<String> timePoints) {
        int size = timePoints.size();
        if (size > 1440) {//一天最多1440分钟，如果时间点数大于1440，必然是出现了重复时间
            return 0;
        }
        int[] times = new int[size];
        for (int i = 0; i < size; i++) {
            String[] strings = timePoints.get(i).split(":");
            times[i] = Integer.parseInt(strings[0]) * 60 + Integer.parseInt(strings[1]);
        }
        Arrays.sort(times);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < size; i++) {
            min = Math.min(min, times[i] - times[i - 1]);
            if (min == 0) {
                return min;
            }
        }
        min = Math.min(min, times[0] + 1440 - times[size - 1]);//处理一下特值，把第一个时间当成明天的这个时间，然后减去最后一个时间
        return min;
    }
}