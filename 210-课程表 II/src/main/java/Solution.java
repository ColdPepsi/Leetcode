import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @author WuBiao
 * @date 2020/5/13 21:00
 */
public class Solution {
    /**
     * @param numCourses
     * @param prerequisites
     * @return int[]
     * @description 类似207
     * @author WuBiao
     * @date 2020/5/13 21:19
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) {
            return new int[0];
        }
        Set<Integer>[] adjList = new Set[numCourses];
        int[] inDegrees = new int[numCourses];
        for (int[] prerequisite : prerequisites) {//映射成邻接表
            inDegrees[prerequisite[0]]++;//相应入度加1；
            if (adjList[prerequisite[1]] == null) {
                adjList[prerequisite[1]] = new HashSet<>();
            }
            adjList[prerequisite[1]].add(prerequisite[0]);
        }
        List<Integer> res = new ArrayList<>(numCourses);
        BFS(adjList, inDegrees, res);
        if (res.size() == numCourses) {//找到一个拓扑
            int[] ret = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                ret[i] = res.get(i);
            }
            return ret;
        } else {//没找到拓扑
            return new int[0];
        }
    }

    private void BFS(Set<Integer>[] adjList, int[] inDegrees, List<Integer> res) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegrees.length; i++) {
            if (inDegrees[i] == 0) {//入度为0的结点入队
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int node = queue.poll();
            res.add(node);//保存结果
            if (adjList[node] != null) {
                for (Integer nextPoint : adjList[node]) {
                    inDegrees[nextPoint]--;//相应点的入度减1
                    if (inDegrees[nextPoint] == 0) {////入度为0的结点入队
                        queue.offer(nextPoint);
                    }
                }
            }
        }
    }
}