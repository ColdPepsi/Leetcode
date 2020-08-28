/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 求欧拉通路，每条边只能走一遍
 *
 * @author wubiao21 2020年08月27日 09:39:10
 */
public class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> ret = new LinkedList<>();
        Map<String, Queue<String>> graph = new HashMap<>(tickets.size() * 2);
        for (List<String> ticket : tickets) {//构建邻接表
            String from = ticket.get(0);
            String to = ticket.get(1);
            Queue<String> nextStation = graph.getOrDefault(from, new PriorityQueue<>());
            nextStation.add(to);
            graph.put(from, nextStation);
        }
        dfs("JFK", ret, graph);
        return ret;
    }

    /**
     * 以前的dfs是先把结果加到结果集，在进行dfs递归，这个是反过来，先进行dfs递归，递归完了以后，再加入到结果集，采用链表头插法的形式，最后得到的结果也是正序的
     *
     * @param station
     * @param ret
     * @param graph
     */
    private void dfs(String station, List<String> ret, Map<String, Queue<String>> graph) {
        Queue<String> nextStation = graph.get(station);
        if (nextStation != null) {
            while (!nextStation.isEmpty()) {
                String next = nextStation.poll();
                dfs(next, ret, graph);
            }
        }
        ret.add(0, station);
    }
}