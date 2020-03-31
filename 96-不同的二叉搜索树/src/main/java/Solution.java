/**
 * @author WuBiao
 * @date 2020/3/31 14:46
 */
public class Solution {
    /**
     * @param n
     * @return int
     * @description 一个升序序列，可以选i作为根节点，其中[1,i-1]作为左子树，[i+1,n]作为右子树
     * @author WuBiao
     * @date 2020/3/31 14:52
     */
    public int numTrees(int n) {
        if (n < 2) {
            return n;
        }
        int[] dp = new int[n + 1];//dp[i]表示长度为i的序列组成不同二叉搜索树的个数
        dp[0] = 1;//长度为0，构造一棵空树
        dp[1] = 1;//边界
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {//以元素j为根节点
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}