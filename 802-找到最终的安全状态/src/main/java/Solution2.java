import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @author WuBiao
 * @date 2020/6/14 23:56
 */
public class Solution2 {
    /**
     * 出度为0的点一定是安全的，按照出度为0拓扑排序
     *
     * @param graph
     * @return
     */
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList<>();
        if (graph == null || graph.length == 0) {
            return res;
        }
        ArrayList<Set<Integer>> rGraph = new ArrayList<>(graph.length);//统计每个点有几个点指向它，其实就是把图反向
        for (int i = 0; i < graph.length; i++) {
            rGraph.add(new HashSet<>());
        }
        int[] outDgree = new int[graph.length];//出度表
        boolean[] isSafe = new boolean[graph.length];//表明某个点是否是安全
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            outDgree[i] = graph[i].length;//统计每个节点的出度
            if (outDgree[i] == 0) {
                queue.add(i);//出度为0的节点入队
            }
            for (int end : graph[i]) {
                rGraph.get(end).add(i);//加入反向图
            }
        }
        while (!queue.isEmpty()) {
            int point = queue.poll();
            isSafe[point] = true;
            for (Integer begin : rGraph.get(point)) {
                outDgree[begin]--;
                if (outDgree[begin] == 0) {
                    queue.add(begin);
                }
            }
        }
        for (int i = 0; i < isSafe.length; i++) {
            if (isSafe[i]) {
                res.add(i);
            }
        }
        return res;
    }
}
