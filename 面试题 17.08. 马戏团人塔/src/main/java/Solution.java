import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * 最长递增子序列类似第300题
 *
 * @author wubiao21 2020年07月10日 11:43:09
 */
public class Solution {
    public int bestSeqAtIndex(int[] height, int[] weight) {
        if (height == null || height.length == 0 || weight == null || weight.length == 0) {
            return 0;
        }
        List<Pair<Integer, Integer>> people = new ArrayList<>(height.length);
        for (int i = 0; i < height.length; i++) {
            people.add(new Pair<>(height[i], weight[i]));
        }
        //按身高升序排列，体重按照降序排列，此时身高已经升序，相当于我们找体重的最长递增子序列，
        //体重降序排列是为了防止身高体重都升序，此时如果找体重的递增子序列容易找到相同的身高
        people.sort((a, b) -> a.getKey() - b.getKey() == 0 ? b.getValue() - a.getValue() : a.getKey() - b.getKey());
        int maxLevel = 0;
        int[] dp = new int[people.size()];//dp[i]表示 以people.get(i).value的体重为结尾的最长子序列长度
        //此时动态规划的时间复杂度为O(n方)
        for (int i = 0; i < people.size(); i++) {
            dp[i] = 1;//表示自己一个序列
            for (int j = 0; j < i; j++) {
                if (people.get(j).getValue() < people.get(i).getValue()) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLevel = Math.max(maxLevel, dp[i]);
        }
        return maxLevel;
    }
}