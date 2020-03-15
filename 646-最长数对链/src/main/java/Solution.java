import java.util.Arrays;
import java.util.Comparator;

/**
 * @author WuBiao
 * @date 2020/3/15 19:43
 */
public class Solution {
    /**
     * @param pairs
     * @return int
     * @description 思路类似最长递增子序列，leetcode第300题，题目不要求序列，
     * 对元素的相对位置没要求，所以可以排序
     * @author WuBiao
     * @date 2020/3/15 19:53
     */
    public int findLongestChain(int[][] pairs) {
        if (pairs == null || pairs.length == 0 || pairs[0].length == 0) {
            return 0;
        }
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[0]));//按照第一个数字升序排序
        int row = pairs.length;//有多少个数对
        int[] dp = new int[row];//dp[i]代表以为pair[i]结尾的最长数对链的长度
        int res = 0;
        for (int i = 0; i < row; i++) {
            dp[i] = 1;//初始化为1，表示自己单独是数对链
            for (int j = 0; j < i; j++) {
                if (pairs[j][1] < pairs[i][0] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
            if (res < dp[i]) {//更新结果
                res = dp[i];
            }
        }
        return res;
    }

    /**
     * @param pairs
     * @return int
     * @description 贪心算法，构造最长数对链，应该选第二个数尽可能小的入队，所以先排序
     * @author WuBiao
     * @date 2020/3/15 20:38
     */
    public int findLongestChain2(int[][] pairs) {
        if (pairs == null || pairs.length == 0 || pairs[0].length == 0) {
            return 0;
        }
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);//按照第二个元素排序
        int res = 0;
        int current = Integer.MIN_VALUE;//指向当前数对链的第二个数
        for (int[] pair : pairs) {
            if (pair[0] > current) {
                //表示pair可以接在当前链的最后
                current = pair[1];//指向第二个数
                res++;//更新结果
            }
        }
        return res;
    }
}