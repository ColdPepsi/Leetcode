/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import java.util.HashSet;
import java.util.List;

/**
 * 类Solution2.java的实现描述：方法2
 *
 * @author wubiao21 2020年08月31日 15:14:07
 */
public class Solution2 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        return backTracking(0, rooms, new HashSet<>(rooms.size()));
    }

    /**
     * 返回从0房间能不能访问所有房间
     *
     * @param index   当前访问的房间号
     * @param rooms   房间钥匙数组
     * @param visited 记录已经访问的房间
     * @return 能访问所有的房间返回true
     */
    private boolean backTracking(int index, List<List<Integer>> rooms, HashSet<Integer> visited) {
        visited.add(index);//把index号房标记为已访问
        if (visited.size() == rooms.size()) {//如果visited中包含了所有的房间，返回true
            return true;
        }
        for (Integer next : rooms.get(index)) {//遍历本房间的所有钥匙
            if (visited.contains(next)) {
                continue;
            }
            if (backTracking(next, rooms, visited)) {
                return true;
            }
        }
        return false;
    }
}