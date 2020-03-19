/**
 * @author WuBiao
 * @date 2020/3/19 20:43
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[i - 1] > 0) {
                profit += prices[i] - prices[i - 1];//取每一个递增区间作为利润
            }
        }
        return profit;
    }
}