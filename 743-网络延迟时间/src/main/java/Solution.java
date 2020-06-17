import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author WuBiao
 * @date 2020/6/17 23:02
 */
public class Solution {

    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, ArrayList<int[]>> graph = new HashMap<>(N);//保存图信息
        Map<Integer, Integer> arriveAtNodeEarliestTime = new HashMap<>(N);//到达某个节点的最早时间
        for (int i = 1; i <= N; i++) {
            arriveAtNodeEarliestTime.put(i, Integer.MAX_VALUE);
        }
        for (int[] time : times) {
            int u = time[0];
            int v = time[1];
            int w = time[2];
            graph.putIfAbsent(u, new ArrayList<>());
            graph.get(u).add(new int[]{v, w});
        }
        for (Map.Entry<Integer, ArrayList<int[]>> integerArrayListEntry : graph.entrySet()) {
            Collections.sort(integerArrayListEntry.getValue(), Comparator.comparingInt(a -> a[1]));//排序，到时候优先访问距离近的。
        }
        DFS(K, 0, graph, arriveAtNodeEarliestTime);
        int maxtime = -1;
        for (Map.Entry<Integer, Integer> entry : arriveAtNodeEarliestTime.entrySet()) {
            if (entry.getValue() == Integer.MAX_VALUE) {//有结点没访问到
                return -1;
            }
            maxtime = Math.max(maxtime, entry.getValue());
        }
        return maxtime;
    }

    private void DFS(int start, int currentTime, Map<Integer, ArrayList<int[]>> graph,
                     Map<Integer, Integer> arriveAtNodeEarliestTime) {
        if (currentTime >= arriveAtNodeEarliestTime.get(start)) {//剪枝
            return;
        }
        arriveAtNodeEarliestTime.put(start, currentTime);//保存最短时间
        ArrayList<int[]> list = graph.getOrDefault(start, null);
        if (list != null) {
            for (int[] edge : list) {
                DFS(edge[0], currentTime + edge[1], graph, arriveAtNodeEarliestTime);
            }
        }
    }
}
