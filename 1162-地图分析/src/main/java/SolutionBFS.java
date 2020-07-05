import java.util.LinkedList;
import java.util.Queue;

/**
 * @author WuBiao
 * @date 2020/7/5 22:02
 */
public class SolutionBFS {
    private static int ROW;
    private static int COL;
    private static final int[][] DIRECTIONS = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    /**
     * @param grid 二维数组
     * @return int
     * @description 暴力BFS解法
     * @author WuBiao
     * @date 2020/7/5 22:02
     */
    public int maxDistance(int[][] grid) {
        int max = -1;
        ROW = grid.length;
        COL = grid[0].length;
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (grid[i][j] == 0) {
                    boolean[][] hasvisited = new boolean[ROW][COL];//生成新数组记录状态
                    int step = BFS(grid, i, j, hasvisited);
                    max = Math.max(max, step);
                }
            }
        }
        return max;
    }

    /**
     * @param grid       二维数组
     * @param row        横坐标
     * @param col        纵坐标
     * @param hasvisited 标记一个点是否访问
     * @return int
     * @description BFS
     * @author WuBiao
     * @date 2020/7/5 22:02
     */
    private int BFS(int[][] grid, int row, int col, boolean[][] hasvisited) {
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(row, col));
        hasvisited[row][col] = true;
        int step = 0;
        boolean flag = true;//正常执行一定会循环中途退出，如果循环执行完，说明碰到全0或者全1
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Position head = queue.poll();
                for (int[] direction : DIRECTIONS) {
                    int nextRow = head.row + direction[0];
                    int nextCol = head.col + direction[1];
                    if (!inAera(nextRow, nextCol) || hasvisited[nextRow][nextCol]) {
                        continue;
                    }
                    if (grid[nextRow][nextCol] == 0) {
                        queue.add(new Position(nextRow, nextCol));
                        hasvisited[nextRow][nextCol] = true;
                    } else {//碰到1，直接返回
                        return step;
                    }
                }
            }
        }
        return flag ? -1 : step;
    }

    private boolean inAera(int row, int col) {
        return row >= 0 && row < ROW && col >= 0 && col < COL;
    }
}

class Position {
    int row;
    int col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
