/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import java.util.ArrayList;

/**
 * 类Solution.java的实现描述：桶排序
 *
 * @author wubiao21 2020年12月16日 16:10:23
 */
public class Solution {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] res = new int[R * C][2];
        int maxDistance = Math.max(r0, R - 1 - r0) + Math.max(c0, C - 1 - c0);
        ArrayList<int[]>[] buckets = new ArrayList[maxDistance + 1];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int distance = getDistance(i, j, r0, c0);
                if (buckets[distance] == null) {//根据距离放入相应的桶中
                    buckets[distance] = new ArrayList<>();
                }
                buckets[distance].add(new int[]{i, j});
            }
        }
        int index = -1;
        //下面就是单纯的拷贝结果
        for (ArrayList<int[]> bucket : buckets) {
            if (bucket == null) {
                continue;
            }
            for (int[] ints : bucket) {
                res[++index] = ints;
            }
        }
        return res;
    }

    /**
     * 计算(i,j)到(r0,c0)的距离
     *
     * @param i
     * @param j
     * @param r0
     * @param c0
     * @return
     */
    private int getDistance(int i, int j, int r0, int c0) {
        return Math.abs(i - r0) + Math.abs(j - c0);
    }
}