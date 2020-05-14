import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @author WuBiao
 * @date 2020/5/13 21:30
 */
public class Solution2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) {
            return new int[0];
        }
        if (prerequisites == null || prerequisites.length == 0) {//没有课程约束，返回一个结果
            int[] ret = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                ret[i] = i;
            }
            return ret;
        }
        Set<Integer>[] adjList = new Set[numCourses];
        for (int[] prerequisite : prerequisites) {//映射成邻接表
            if (adjList[prerequisite[1]] == null) {
                adjList[prerequisite[1]] = new HashSet<>();
            }
            adjList[prerequisite[1]].add(prerequisite[0]);
        }
        Stack<Integer> res = new Stack<>();
        int[] flag = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (DFS(res, i, adjList, flag)) {//以每个课程为起点DFS，防止以某条路径DFS不完所有课程
                return new int[0];//出现环，返回空
            }
        }
        //DFS完的话，拓扑已经存在栈里,后续结点先入的栈，所以要弹出，就是拓扑排序
        int[] ret = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            ret[i] = res.pop();
        }
        return ret;
    }

    /**
     * @param res     结果集
     * @param start   起点
     * @param adjList 邻接表
     * @param flags   状态矩阵
     * @return boolean
     * @description 以某结点为起点访问，看看会不会出现环
     * @author WuBiao
     * @date 2020/5/13 22:29
     */
    private boolean DFS(Stack<Integer> res, int start,
                        Set<Integer>[] adjList, int[] flags) {
        if (flags[start] == 1) {//本轮正在访问中，说明出现环
            return true;
        }
        if (flags[start] == -1) {
            return false;//已经访问过，返回false，不会出现环
        }
        flags[start] = 1;//标记为本轮正在访问
        if (adjList[start] != null) {
            for (Integer next : adjList[start]) {
                if (DFS(res, next, adjList, flags)) {
                    return true;//出现环返回true
                }
            }
        }
        flags[start] = -1;//start的所有后继结点都访问完，发现没有环，把此结点标记为已访问
        res.push(start);//此节点入栈
        return false;
    }
}