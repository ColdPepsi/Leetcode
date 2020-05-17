import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author WuBiao
 * @date 2020/5/15 16:06
 */
public class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] hasVisited = new boolean[n];
        Set<Integer> visitedRoomNums = new HashSet<>(n);
        DFS(0, rooms, hasVisited, visitedRoomNums);//从0开始访问
        return visitedRoomNums.size() == n;
    }

    /**
     * @param start      开始结点
     * @param rooms      邻接表
     * @param hasVisited 记录结点访问状态
     * @return void
     * @description 深度优先遍历
     * @author WuBiao
     * @date 2020/5/15 16:12
     */
    private void DFS(int start, List<List<Integer>> rooms, boolean[] hasVisited, Set<Integer> visitedRoomNums) {
        hasVisited[start] = true;//标记为已访问
        visitedRoomNums.add(start);//加到列表里
        for (Integer next : rooms.get(start)) {
            if (!hasVisited[next]) {//访问邻接的没有访问的结点
                DFS(next, rooms, hasVisited, visitedRoomNums);
            }
        }
    }
}