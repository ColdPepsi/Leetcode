/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 类Solution.java的实现描述：暴力求解，所有点按照x坐标排序，对于同一列的两个点（x,y1）和（x,y2），我们找出它作为右边界的最小矩形
 *
 * @author wubiao21 2020年09月07日 20:53:36
 */
public class Solution {
    public int minAreaRect(int[][] points) {
        Map<Integer, List<Integer>> rows = new TreeMap<>();//treeMap有序,默认按照key从小到大排序
        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            rows.computeIfAbsent(x, z -> new ArrayList<>()).add(y);//如果map中没有键x，就新建一个键值对（x,list）放入map，并返回
        }
        int ans = Integer.MAX_VALUE;
        Map<Integer, Integer> lastX = new HashMap<>(points.length);//记录已经访问过的（y1,y2）
        for (Map.Entry<Integer, List<Integer>> entry : rows.entrySet()) {
            int x = entry.getKey();
            List<Integer> row = entry.getValue();
            Collections.sort(row);//对该横坐标 所对应的所有纵坐标从小到大排序
            for (int i = 0; i < row.size(); i++) {
                int y1 = row.get(i);
                for (int j = i + 1; j < row.size(); j++) {//取两个纵坐标
                    int y2 = row.get(j);
                    int code = 40001 * y1 + y2;//把x对应的（y1,y2）这条边映射成hash值
                    int x1 = lastX.getOrDefault(code, -1);
                    if (x1 != -1) {//说明之前已经出现了（y1,y2）这条边，横坐标是x1
                        ans = Math.min(ans, (x - x1) * (y2 - y1));//计算最小面积
                    }
                    lastX.put(code, x);//（y1,y2）这条边的横左边替换为x
                }
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}