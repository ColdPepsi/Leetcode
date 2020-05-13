import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author WuBiao
 * @date 2020/5/13 17:04
 */
public class Solution {
    /**
     * @param numCourses    课程数
     * @param prerequisites 先决条件，相当于有向边
     * @return boolean
     * @description 拓扑排序，检测是否是有向无环图；
     * @author WuBiao
     * @date 2020/5/13 17:15
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) {
            return false;
        }
        if (prerequisites == null || prerequisites.length == 0) {
            return true;
        }
        Set<Integer>[] adjList = new Set[numCourses];//邻接表
        int[] inDegree = new int[numCourses];//记录每个点的入度
        for (int[] prerequisite : prerequisites) {//初始化邻接表
            inDegree[prerequisite[0]]++;
            if (adjList[prerequisite[1]] == null) {
                adjList[prerequisite[1]] = new HashSet<Integer>();
            }
            adjList[prerequisite[1]].add(prerequisite[0]);
        }
        return BFS(numCourses, adjList, inDegree);
    }

    /**
     * @param numCourses 课程数
     * @param adjList    邻接表
     * @param inDegree   入度表
     * @return boolean
     * @description 广度优先遍历
     * @author WuBiao
     * @date 2020/5/13 17:33
     */
    private boolean BFS(int numCourses, Set<Integer>[] adjList, int[] inDegree) {
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {//入度为0的点进队
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int node = queue.poll();
            numCourses--;
            if (adjList[node] != null) {//如果有以node为起点的边
                for (Integer successor : adjList[node]) {
                    inDegree[successor]--;//后继者的入度减一；
                    if (inDegree[successor] == 0) {//如果后继者的入度为0，则入队
                        queue.offer(successor);
                    }
                }
            }
        }
        return numCourses == 0;
    }
}