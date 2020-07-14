import java.util.List;

/**
 * @author wubiao21 2020年07月14日 09:06:27
 */
public class Solution {
    /**
     * 数塔问题，动态规划
     *
     * @param triangle 数塔
     * @return 返回塔尖
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {//初始化最下面一层，边界
            dp[len - 1][i] = triangle.get(len - 1).get(i);
        }
        for (int i = len - 2; i >= 0; i--) {//从最后倒数第二层往上计算
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }
    //dp[i][j]==min(dp[i+1][j],dp[i+1][j+1])+triangle[i][j]
}