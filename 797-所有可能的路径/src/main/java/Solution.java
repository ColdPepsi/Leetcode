/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 类Solution.java的实现描述：直接回溯每条路径
 *
 * @author wubiao21 2020年09月28日 10:30:58
 */
public class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>(graph.length);
        backTracking(0, graph, new ArrayList<>(), res);//从0开始回溯
        return res;
    }

    /**
     * 回溯从index出发的每条路径
     *
     * @param index  当前访问的结点
     * @param graph  邻接表
     * @param prefix 路径前缀
     * @param res    结果集
     */
    private void backTracking(int index, int[][] graph, ArrayList<Integer> prefix, List<List<Integer>> res) {
        prefix.add(index);//把当前点加入路径前缀
        if (index == graph.length - 1) {//到达终点
            res.add(new ArrayList<>(prefix));//把结果添加到结果集
            prefix.remove(prefix.size() - 1);//因为当前结点在路径中，所以我们要移除当前结点然后返回，这句不能忘！
            return;
        }
        if (graph[index] != null && graph[index].length > 0) {//如果当前结点有邻接的点，回溯邻接的点
            for (int next : graph[index]) {
                backTracking(next, graph, prefix, res);
            }
        }
        prefix.remove(prefix.size() - 1);//恢复现场
    }
}