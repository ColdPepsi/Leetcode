/**
 * @author WuBiao
 * @date 2020/3/19 19:37
 */
public class Solution {
    /**
     * @param prices
     * @return int
     * @description 只要记录前面的最小价格，将这个最小价格作为买入价格，然后将当前的价格作为售出价格，查看当前收益是不是最大收益。
     * @author WuBiao
     * @date 2020/3/19 19:41
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int profit = 0;
        for (int price : prices) {
            if (price < min) {
                min = price;//更新最低价格
            } else {
                profit = Math.max(profit, price - min);
            }
        }
        return profit;
    }

    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        //change[i]保存price[i]与price[i-1]的差值
        int[] changes = new int[prices.length];
        for (int i = 1; i < prices.length; i++) {
            changes[i] = prices[i] - prices[i - 1];
        }
        //然后求change[i]的最大子数组和
        int sum = 0;
        int profit = 0;
        for (int i = 1; i < changes.length; i++) {
            sum += changes[i];
            if (sum < 0) {
                sum = 0;
            }
            profit = Math.max(profit, sum);
        }
        return profit;
    }

    public int maxProfit3(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        //change[i]保存price[i]与price[i-1]的差值
        int[] changes = new int[prices.length];
        for (int i = 1; i < prices.length; i++) {
            changes[i] = prices[i] - prices[i - 1];
        }
        //然后求change[i]的最大子数组和
        int pre = 0;
        int current = 0;//保存截止到目前的最大子数组和
        int profit = 0;
        for (int i = 1; i < changes.length; i++) {
            current = Math.max(pre + changes[i], changes[i]);//动态规划做法
            profit = Math.max(current, profit);//profit保存所有的最大值
            pre = current;
        }
        return Math.max(profit, 0);
    }
}