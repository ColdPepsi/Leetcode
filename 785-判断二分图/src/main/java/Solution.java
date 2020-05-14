import java.util.LinkedList;
import java.util.Queue;

/**
 * @author WuBiao
 * @date 2020/5/14 20:20
 */
public class Solution {
    public boolean isBipartite(int[][] graph) {
        if (graph == null || graph.length == 0) {
            return false;
        }
        int n = graph.length;
        int[] colored = new int[n];
        for (int i = 0; i < n; i++) {//要进行多次BFS，防止图不是连通图
            if (colored[i] == 0) {//如果该结点没涂色
                if (!BFS(i, graph, colored)) {//从该结点开始涂色，涂色失败返回false
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * @param start   起始结点
     * @param graph   邻接表
     * @param colored 记录结点有没有涂色，0：未涂色；1：涂成红色；-1；黑色
     * @return boolean
     * @description 广度优先遍历，把一个结点和他的相邻结点涂成相反色，涂成功返回true
     * @author WuBiao
     * @date 2020/5/14 20:32
     */
    private boolean BFS(int start, int[][] graph, int[] colored) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        colored[start] = 1;
        while (!queue.isEmpty()) {
            int front = queue.poll();
            int color = colored[front];
            for (int next : graph[front]) {
                if (colored[next] == 0) {//如果没涂色
                    colored[next] = -color;//涂相反色
                    queue.offer(next);//入队
                } else if (colored[next] == color) {//如果涂的颜色相同
                    return false;
                }
            }
        }
        return true;
    }
}