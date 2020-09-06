/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 类Solution.java的实现描述：20200903百度笔试题第二题
 *
 * @author wubiao21 2020年09月04日 14:08:43
 */
public class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> ret = new ArrayList<>();
        int aIndex = 0;//指向A最小的区间
        int bIndex = 0;//指向B最小的区间
        while (aIndex < A.length && bIndex < B.length) {
            int start = Math.max(A[aIndex][0], B[bIndex][0]);//取区间交集起点
            int end = Math.min(A[aIndex][1], B[bIndex][1]);//取区间交集终点
            if (start <= end) {//满足条件说明相交，加入结果集
                ret.add(new int[]{start, end});
            }
            //end取到哪个区间右端点，哪个区间就出局
            if (end == A[aIndex][1]) {
                aIndex++;
            }
            if (end == B[bIndex][1]) {
                bIndex++;
            }
        }
        return ret.toArray(new int[ret.size()][2]);
    }
}