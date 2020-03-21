/**
 * @author WuBiao
 * @date 2020/3/21 19:12
 */
public class Solution {
    /**
     * @param M
     * @return int
     * @description 求无向图的连通分量数量
     * @author WuBiao
     * @date 2020/3/21 19:45
     */
    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0 || M[0].length == 0) {
            return 0;
        }
        boolean[] hasVisited = new boolean[M.length];//标记是否访问
        int count = 0;
        for (int i = 0; i < hasVisited.length; i++) {
            if (!hasVisited[i]) {//如果某点没访问过
                count++;
                DFS(M, i, hasVisited);
            }
        }
        return count;
    }

    private void DFS(int[][] M, int start, boolean[] hasVisited) {
        hasVisited[start] = true;//标记为已经访问
        for (int i = 0; i < hasVisited.length; i++) {
            if (M[start][i] == 1 && !hasVisited[i]) {//如果存在start的朋友，并且还没有被访问过
                DFS(M, i, hasVisited);
            }
        }
    }
}