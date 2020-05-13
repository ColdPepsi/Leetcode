import java.util.HashSet;
import java.util.Set;

/**
 * @author WuBiao
 * @date 2020/5/13 17:48
 */
public class Solution2 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) {
            return false;
        }
        if (prerequisites == null || prerequisites.length == 0) {
            return true;
        }
        Set<Integer>[] adjList = new Set[numCourses];//邻接表
        for (int[] prerequisite : prerequisites) {//初始化邻接表
            if (adjList[prerequisite[1]] == null) {
                adjList[prerequisite[1]] = new HashSet<Integer>();
            }
            adjList[prerequisite[1]].add(prerequisite[0]);
        }
        //flag[i]==0,表示未访问；flag[i]==1，表示本轮访问，出现环；flag[i]==-1，表示其他路径访问的此点
        int[] flags = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (backTracking(i, adjList, flags)) {//每个结点为起点，开始遍历
                return false;//如果出现环，则不能完成课程
            }
        }
        return true;//不存在环，能完成课程
    }

    /**
     * @param start   开始的结点
     * @param adjList 邻接表
     * @param flags   状态表
     * @return boolean
     * @description 深度优先遍历，看看图中有没有环，存在环返回true
     * @author WuBiao
     * @date 2020/5/13 18:27
     */
    private boolean backTracking(int start, Set<Integer>[] adjList, int[] flags) {
        if (flags[start] == 1) {
            return true;//出现环
        }
        if (flags[start] == -1) {
            return false;//该结点已经被访问
        }
        //走到这里时，flags[start]==0;
        flags[start] = 1;//设置为此结点已经访问
        if (adjList[start] != null) {
            for (Integer successor : adjList[start]) {
                if (backTracking(successor, adjList, flags)) {//回溯后继结点
                    return true;//出现环，则返回true;
                }
            }
        }
        flags[start] = -1;//start的所有后继结点都访问完，发现没有环，把此结点标记为已访问
        return false;
    }
}