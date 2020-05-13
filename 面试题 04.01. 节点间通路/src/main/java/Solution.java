import java.util.ArrayList;

/**
 * @author WuBiao
 * @date 2020/5/13 14:48
 */
public class Solution {
    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        //把图转换成邻接表
        ArrayList<Integer>[] adjList = new ArrayList[n];
        for (int[] edge : graph) {
            if (adjList[edge[0]] == null) {
                adjList[edge[0]] = new ArrayList<>();
            }
            adjList[edge[0]].add(edge[1]);
        }
        return DFS(adjList, new boolean[n], start, target);
    }

    /**
     * @param adjList    邻接表
     * @param hasVisited 标记列表是否访问过
     * @param start      起点
     * @param target     目标点
     * @return boolean
     * @description 深度有限遍历
     * @author WuBiao
     * @date 2020/5/13 15:27
     */
    private boolean DFS(ArrayList<Integer>[] adjList, boolean[] hasVisited, int start, int target) {
        if (start == target) {
            return true;
        }
        hasVisited[start] = true;//该结点标记为已经访问
        if (adjList[start] == null) {//如果start没有出边，则返回false
            return false;
        }
        for (Integer nextPoint : adjList[start]) {
            if (hasVisited[nextPoint]) {
                continue;//该结点已经访问过，则跳过
            }
            if (DFS(adjList, hasVisited, nextPoint, target)) {//找到一个结果，就返回成功
                return true;
            }
        }
        //hasVisited[start] = false; 无需增加这句恢复现场，因为其他路径访问过的点，没比较再访问，会增加计算量
        return false;
    }
}