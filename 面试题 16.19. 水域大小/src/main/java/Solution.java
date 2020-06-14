import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author WuBiao
 * @date 2020/6/14 23:52
 */
public class Solution {
    private static final int[][] Directions = {{-1, 0}, {-1, -1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}};
    private int[][] land;

    public int[] pondSizes(int[][] land) {
        this.land = land;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                if (land[i][j] == 0) {
                    ans.add(DFS(i, j));
                }
            }
        }
        int[] ret = new int[ans.size()];
        int index = 0;
        for (Integer integer : ans) {
            ret[index++] = integer;
        }
        Arrays.sort(ret);
        return ret;
    }

    private int DFS(int row, int col) {
        if (!inAera(row, col) || land[row][col] != 0) {
            return 0;
        }
        int ans = 1;
        land[row][col] = 1;
        for (int[] direction : Directions) {
            int nextRow = row + direction[0];
            int nextCol = col + direction[1];
            ans += DFS(nextRow, nextCol);
        }
        return ans;
    }

    private boolean inAera(int row, int col) {
        return 0 <= row && row < land.length && 0 <= col && col < land[0].length;
    }
}
