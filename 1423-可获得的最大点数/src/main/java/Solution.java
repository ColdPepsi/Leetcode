/**
 * @author WuBiao
 * @date 2020/5/17 17:10
 */
public class Solution {
    /**
     * @param cardPoints 数组
     * @param k          卡牌数
     * @return int
     * @description 其实就是求cardPoints[len-k,len-1]+cardPoints[0,k-1]这个数组的最大k区间和
     * @author WuBiao
     * @date 2020/5/17 17:35
     */
    public int maxScore(int[] cardPoints, int k) {
        int len = cardPoints.length;
        int sum = 0;
        for (int i = len - k; i < len; i++) {
            sum += cardPoints[i];
        }
        int maxSum = sum;
        if (k != len) {
            for (int i = 0, j = len - k; i < k; i++, j++) {
                sum = sum + cardPoints[i] - cardPoints[j];//减掉第一个元素，加上新元素
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }
}