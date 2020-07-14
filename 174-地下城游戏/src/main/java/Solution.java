/**
 * @author wubiao21 2020年07月13日 09:58:03
 */
public class Solution {

    private int rows;
    private int cols;
    private int[][] dungeon;
    private int[][] memo;//memo[i][j]表示 dungeon[i][j]到公主处所需要的最小血量

    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) {
            return 0;
        }
        this.dungeon = dungeon;
        rows = dungeon.length;
        cols = dungeon[0].length;
        this.memo = new int[rows][cols];
        return dfs(0, 0);
    }

    /**
     * 求dungeon[i][j]到公主处所需血量的最小值
     * 与1取最大值是因为骑士血量最低是1
     * 减去dungeon[row][col]，是因为在dungeon[row][col]处也会提供血量
     *
     * @param row 横坐标
     * @param col 纵坐标
     * @return 返回dungeon[i][j]到公主处所需血量的最小值
     */
    private int dfs(int row, int col) {
        if (row == rows - 1 && col == cols - 1) {
            //到达公主处
            return Math.max(1 - dungeon[row][col], 1);
        }
        if (memo[row][col] > 0) {//已经计算过值，直接返回
            return memo[row][col];
        }
        int res = 0;
        if (row == rows - 1) {//最后一行的话，向右递归
            res = Math.max(dfs(row, col + 1) - dungeon[row][col], 1);
        } else if (col == cols - 1) {//最后一列的话，向下递归
            res = Math.max(dfs(row + 1, col) - dungeon[row][col], 1);
        } else {//否则取向右或向下递归最小值
            res = Math.max(Math.min(dfs(row + 1, col), dfs(row, col + 1)) - dungeon[row][col], 1);
        }
        memo[row][col] = res;
        return res;
    }
}