import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author WuBiao
 * @date 2020/4/11 20:20
 */
public class Solution {

    private static int[][] MATRIX;
    private static int ROW;
    private static int COL;
    private static final int[][] DIRECTIONS = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    /**
     * @param matrix
     * @return int[][]
     * @description 多源点层次遍历
     * @author WuBiao
     * @date 2020/4/11 20:58
     */
    public int[][] updateMatrix(int[][] matrix) {
        MATRIX = matrix;
        ROW = matrix.length;
        COL = matrix[0].length;
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new Pair<>(i, j));//把0的结点入队
                } else {
                    matrix[i][j] = Integer.MAX_VALUE;//把1距离0的距离改成最大值
                }
            }
        }
        BFS(queue);//层次遍历
        return matrix;
    }

    /**
     * @param r
     * @param c
     * @return boolean
     * @description 判断坐标是否出界
     * @author WuBiao
     * @date 2020/4/11 20:27
     */
    private boolean outOfBorder(int r, int c) {
        return (r < 0 || r >= ROW || c < 0 || c >= COL);
    }

    /**
     * @param queue
     * @return void
     * @description 从每个0开始向外扩，每次更新一层。
     * @author WuBiao
     * @date 2020/4/11 22:23
     */
    private void BFS(Queue<Pair<Integer, Integer>> queue) {
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> temp = queue.poll();
            int row = temp.getKey();
            int col = temp.getValue();
            for (int[] direction : DIRECTIONS) {
                int nextRow = row + direction[0];
                int nextCol = col + direction[1];
                if (!outOfBorder(nextRow, nextCol) && MATRIX[nextRow][nextCol] > MATRIX[row][col] + 1) {
                    MATRIX[nextRow][nextCol] = MATRIX[row][col] + 1;//向外更新一层，每个点只会入队一次。
                    queue.offer(new Pair<>(nextRow, nextCol));
                }
            }
        }
    }
}