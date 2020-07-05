import java.util.LinkedList;
import java.util.Queue;

/**
 * @author WuBiao
 * @date 2020/7/5 21:51
 */
public class Solution {
    private static int ROW;
    private static int COL;
    private static final int[][] DIRECTIONS = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    /**
     * @param grid 二维数组
     * @return int
     * @description 多源BFS
     * @author WuBiao
     * @date 2020/7/5 21:51
     */
    public int maxDistance(int[][] grid) {
        ROW = grid.length;
        COL = grid[0].length;
        Queue<Pos> queue = new LinkedList<>();
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new Pos(i, j));//把1入队，从陆地开始BFS
                }
            }
        }
        if (queue.isEmpty() || queue.size() == ROW * COL) {//全0或者全1
            return -1;
        }
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {//一层一层来
                Pos front = queue.poll();
                for (int[] direction : DIRECTIONS) {//遍历上下左右4个方向
                    int nextRow = front.row + direction[0];
                    int nextCol = front.col + direction[1];
                    if (!inArea(nextRow, nextCol) || grid[nextRow][nextCol] == 1) {
                        continue;
                    }
                    grid[nextRow][nextCol] = 1;//标记为已经访问
                    queue.add(new Pos(nextRow, nextCol));//加入队列
                }
            }
            step++;
        }
        return step - 1;//因为最后一层，没有继续扩张，减1
    }

    /**
     * @param row 横坐标
     * @param col 纵坐标
     * @return boolean
     * @description 判断一个点是否在界内
     * @author WuBiao
     * @date 2020/7/5 21:53
     */
    private boolean inArea(int row, int col) {
        return row >= 0 && row < ROW && col >= 0 && col < COL;
    }
}

/**
 * @author WuBiao
 * @description 坐标类
 * @return
 * @date 2020/7/5 21:54
 */
class Pos {
    int row;//横坐标
    int col;//纵坐标

    public Pos(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
