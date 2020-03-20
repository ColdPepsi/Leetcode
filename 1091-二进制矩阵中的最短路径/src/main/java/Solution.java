import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author WuBiao
 * @date 2020/3/20 22:54
 */
public class Solution {
    /**
     * @param grid
     * @return int
     * @description 8方向BFS
     * @author WuBiao
     * @date 2020/3/20 23:17
     */
    public int shortestPathBinaryMatrix(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        if (grid[0][0] == 1 || grid[row - 1][col - 1] == 1) {//起始结点阻塞，返回失败
            return -1;
        }
        int[][] direction = {{-1, 0}, {-1, -1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}};//方向向量
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(0, 0));//起点入队，pair存放坐标
        int pathLength = 0;
        while (!queue.isEmpty()) {
            pathLength++;//每遍历一层，路径加1
            int size = queue.size();
            for (int i = 0; i < size; i++) {//一层一层的遍历
                Pair<Integer, Integer> pair = queue.poll();
                int curRow = pair.getKey();
                int curCol = pair.getValue();
                if (grid[curRow][curCol] == 1) {
                    continue;//当前结点已经访问过，则跳过
                }
                if (curRow == row - 1 && curCol == col - 1) {//如果元素是终点
                    return pathLength;
                }
                grid[curRow][curCol] = 1;//当前结点设置为阻塞，表示已经访问
                for (int[] dire : direction) {//八个方向都遍历一遍
                    int tempRow = curRow + dire[0];
                    int tempCol = curCol + dire[1];
                    if (tempRow < 0 || tempRow >= row || tempCol < 0 || tempCol >= col) {
                        continue;//如果越界，则跳过
                    }
                    queue.offer(new Pair<>(tempRow, tempCol));
                }
            }
        }
        return -1;
    }
}