import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author WuBiao
 * @date 2020/6/14 23:55
 */
public class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        if (graph == null || graph.length == 0) {
            return new ArrayList<Integer>(0);
        }
        Set<Integer> notSafeNodeSet = new HashSet<>(graph.length);//不安全点集合
        for (int i = 0; i < graph.length; i++) {
            if (notSafeNodeSet.contains(i)) {
                continue;
            }
            backTracking(i, notSafeNodeSet, new ArrayList<>(), graph, new int[graph.length]);
        }
        List<Integer> res = new ArrayList<>(graph.length - notSafeNodeSet.size());
        for (int i = 0; i < graph.length; i++) {
            if (!notSafeNodeSet.contains(i)) {
                res.add(i);
            }
        }
        return res;
    }


    private void backTracking(int start, Set<Integer> notSafeNodeSet,
                              List<Integer> prefix, int[][] graph, int[] flags) {
        if (flags[start] == 1) {//出现环,路径上全是不安全点
            notSafeNodeSet.addAll(prefix);
            return;
        }
        if (flags[start] == -1) {//该点已经访问过，直返返回
            return;
        }
        flags[start] = 1;
        prefix.add(start);
        for (int next : graph[start]) {
            if (notSafeNodeSet.contains(next)) {
                notSafeNodeSet.addAll(prefix);
                break;
            }
            backTracking(next, notSafeNodeSet, prefix, graph, flags);
        }
        prefix.remove(prefix.size() - 1);
        flags[start] = -1;
    }
}