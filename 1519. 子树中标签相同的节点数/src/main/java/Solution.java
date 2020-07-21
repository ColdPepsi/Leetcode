/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 类Solution.java的实现描述：dfs深度优先遍历
 *
 * @author wubiao21 2020年07月20日 10:11:45
 */
public class Solution {

    private int[] res;//保存结果
    private List<Set<Integer>> graph;//保存无向图
    private String labels;

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        this.res = new int[n];
        this.labels = labels;
        this.graph=new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            this.graph.add(new HashSet<>());
        }
        for (int[] edge : edges) {//把边矩阵映射成邻接表
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        dfs(0, new boolean[n]);
        return res;
    }

    /**
     * 统计以index为根节点的子树的每个字符的个数
     *
     * @param index      当前遍历的结点下标
     * @param hasVisited 标记某个结点是否已经访问
     * @return 返回统计的数组
     */
    private int[] dfs(int index, boolean[] hasVisited) {
        hasVisited[index] = true;//标记为已访问
        int[] count = new int[26];//统计以index为根节点的子树中每个字符的个数
        count[labels.charAt(index) - 'a']++;//把根节点的字符统计上
        for (Integer next : graph.get(index)) {//递归处理子孩子
            if (hasVisited[next]) {//跳过已经访问过的结点
                continue;
            }
            int[] temp = dfs(next, hasVisited);
            for (int i = 0; i < temp.length; i++) {
                count[i] += temp[i];//统计每个子孩子的字符数
            }
        }
        res[index] = count[labels.charAt(index) - 'a'];//更新结果集合
        return count;
    }
}