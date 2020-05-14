import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author WuBiao
 * @date 2020/5/14 17:37
 */
public class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        if (edges == null || edges.length == 0 || edges[0].length == 0) {
            return new int[0];
        }
        int n = edges.length;
        Set<Integer>[] adjList = new Set[n + 1];
        for (int[] edge : edges) {//把边映射成邻接表
            int from = edge[0];
            int to = edge[1];
            if (adjList[from] == null) {
                adjList[from] = new HashSet<>();
            }
            adjList[from].add(to);
            if (adjList[to] == null) {
                adjList[to] = new HashSet<>();
            }
            adjList[to].add(from);
        }
        for (int i = n - 1; i >= 0; i--) {
            int from = edges[i][0];
            int to = edges[i][1];
            adjList[from].remove(to);//先删去这条边
            adjList[to].remove(from);
            if (DFS(from, to, adjList, new boolean[n + 1])) {
                //如果能从起点访问到终点，说明这条边是冗余的
                int[] res = {from, to};
                Arrays.sort(res);
                return res;
            }
            adjList[from].add(to);//恢复这条边
            adjList[to].add(from);
        }
        return new int[0];
    }

    /**
     * @param start      起点
     * @param target     目标点
     * @param adjList    邻接表
     * @param hasVisited 标记结点是否访问
     * @return boolean
     * @description 深度优先遍历，看看能不能从起点，找到目标点
     * @author WuBiao
     * @date 2020/5/14 17:51
     */
    private boolean DFS(int start, int target, Set<Integer>[] adjList, boolean[] hasVisited) {
        if (start == target) {//访问到目标点，返回true
            return true;
        }
        hasVisited[start] = true;
        if (adjList[start] != null) {
            for (Integer next : adjList[start]) {
                if (hasVisited[next]) {
                    continue;
                }
                if (DFS(next, target, adjList, hasVisited)) {
                    return true;
                }
            }
        }
        return false;
    }
}