/**
 * @author WuBiao
 * @date 2020/5/6 16:30
 */
public class Solution2 {
    public Integer[] memo;//memo[i]记录从第 days[i]天到最后的旅行计划的最小花费。
    private int[] Days;
    private int[] Costs;
    private static final int[] DURATION = {1, 7, 30};

    /**
     * @param days
     * @param costs
     * @return int
     * @description 动态规划的方法比回溯效率高，本题采用的是从后往前的遍历方式
     * @author WuBiao
     * @date 2020/5/6 16:54
     */
    public int mincostTickets(int[] days, int[] costs) {
        Days = days;
        Costs = costs;
        memo = new Integer[days.length];
        return dp(0);
    }

    /**
     * @param i
     * @return int
     * @description dp(i)表示能够完成从第 days[i]天到最后的旅行计划的最小花费
     * @author WuBiao
     * @date 2020/5/6 16:34
     */
    private int dp(int i) {
        if (i >= Days.length) {
            return 0;//越界返回0
        }
        if (memo[i] != null) {//如果有保存的值，直接返回保存的值
            return memo[i];
        }
        //没有保存的值，进行下面的计算
        memo[i] = Integer.MAX_VALUE;
        for (int j = 0; j < Costs.length; j++) {
            int nextIndex = getNextIndex(i, j);
            memo[i] = Math.min(dp(nextIndex) + Costs[j], memo[i]);//days[nextIndex]为下一个需要买票的日期
        }
        return memo[i];
    }

    private int getNextIndex(int startIndex, int durationIndex) {
        int dayLimit = Days[startIndex] + DURATION[durationIndex] - 1;
        while (startIndex < Days.length && Days[startIndex] <= dayLimit) {
            startIndex++;
        }
        return startIndex;
    }
}