/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 类Solution.java的实现描述：模仿785判断2分图的写法。采用层次遍历把自己和孩子涂成2种颜色，如果涂色过程中碰到自己和孩子颜色相同，说明矛盾，不能二分
 *
 * @author wubiao21 2020年09月30日 11:30:43
 */
public class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        List<Integer>[] dislikeGraph = new List[N + 1];
        for (int[] dislike : dislikes) {//把dislikes中的数组当成边，映射成图
            int num1 = dislike[0];
            int num2 = dislike[1];
            if (dislikeGraph[num1] == null) {
                dislikeGraph[num1] = new ArrayList<>();
            }
            dislikeGraph[num1].add(num2);
            if (dislikeGraph[num2] == null) {
                dislikeGraph[num2] = new ArrayList<>();
            }
            dislikeGraph[num2].add(num1);
        }
        int[] colored = new int[N + 1];//标记涂色状态，0是没涂色，1是一种颜色，-1是另一种颜色
        for (int node = 1; node <= N; node++) {
            if (colored[node] == 0 && !dfs(node, -1, colored, dislikeGraph)) {//调用下面的bfs或者dfs都行
                return false;
            }
        }
        return true;
    }

    private boolean bfs(int node, int[] colored, List<Integer>[] dislikeGraph) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        colored[node] = 1;
        while (!queue.isEmpty()) {
            int head = queue.poll();
            int color = colored[head];
            if (dislikeGraph[head] != null) {//把自己不喜欢的，涂成另一种颜色
                for (Integer next : dislikeGraph[head]) {
                    if (colored[next] == color) {//碰到和自己同色的，返回涂色失败
                        return false;
                    } else if (colored[next] == 0) {
                        colored[next] = -color;
                        queue.add(next);
                    }
                }
            }
        }
        return true;//涂色成功
    }

    private boolean dfs(int node, int color, int[] colored, List<Integer>[] dislikeGraph) {
        //color是父亲的颜色
        colored[node] = -color;
        if (dislikeGraph[node] != null) {
            for (int next : dislikeGraph[node]) {
                if (colored[next] == -color || colored[next] == 0 && !dfs(next, -color, colored, dislikeGraph)) {
                    return false;
                }
            }
        }
        return true;
    }
}