/**
 * @author WuBiao
 * @date 2020/7/5 21:45
 */
public class Solution {

    /**
     * @param A 数组A
     * @param B 数组B
     * @return int
     * @description 动态规划
     * @author WuBiao
     * @date 2020/7/5 21:46
     */
    public int findLength(int[] A, int[] B) {
        int lenA = A.length;
        int lenB = B.length;
        int[][] dp = new int[lenA + 1][lenB + 1];//多申请一行一列，作为边界
        int max = 0;
        for (int i = 1; i <= lenA; i++) {
            for (int j = 1; j <= lenB; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max;
    }
    //dp[i][j]表示A[0..i]和B[0..j]的最长公共后缀子数组的长度
    //dp[i][j]=dp[i-1][j-1]+1,if(A[i]==B[j])
    //dp[i][j]=0,if(A[i]!=B[j]).
    //因为边界的问题，代码中的坐标会微调1
}
