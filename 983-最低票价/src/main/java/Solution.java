/**
 * @author WuBiao
 * @date 2020/5/6 11:02
 */
public class Solution {

    private int minCost;
    private int[] Days;
    private int[] Costs;
    private static final int[] DURATION = {1, 7, 30};

    public int mincostTickets(int[] days, int[] costs) {
        Days = days;
        Costs = costs;
        minCost=Integer.MAX_VALUE;
        BackTracking(0, 0);
        return minCost;
    }
    //回溯法容易超时
    private void BackTracking(int startIndex, int currentCost) {
        if (startIndex >= Days.length) {
            if (minCost > currentCost) {//更新结果
                minCost = currentCost;
            }
            return;
        }
        for (int i = 0; i < Costs.length; i++) {
            currentCost += Costs[i];
            if (currentCost < minCost) {
                int nextIndex = getNextIndex(startIndex, i);
                BackTracking(nextIndex, currentCost);
            }
            currentCost -= Costs[i];
        }
    }

    private int getNextIndex(int startIndex, int durationIndex) {
        int dayLimit = Days[startIndex] + DURATION[durationIndex] - 1;
        while (startIndex < Days.length && Days[startIndex] <= dayLimit) {
            startIndex++;
        }
        return startIndex;
    }
}