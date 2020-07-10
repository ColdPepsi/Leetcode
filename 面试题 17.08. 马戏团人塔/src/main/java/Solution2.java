import java.util.ArrayList;
import java.util.List;

/**
 * 类Solution2.java的实现描述：二分求解最长递增子序列，相当于复习第300题
 *
 * @author wubiao21 2020年07月10日 14:51:14
 */
public class Solution2 {

    /**
     * 定义一个内部类，用来绑定一个人的身高体重
     */
    private static class Persion {
        private int height;
        private int weight;

        public Persion(int _height, int _weight) {
            height = _height;
            weight = _weight;
        }
    }

    public int bestSeqAtIndex(int[] height, int[] weight) {
        if (height == null || height.length == 0 || weight == null || weight.length == 0) {
            return 0;
        }
        List<Persion> people = new ArrayList<>(height.length);
        for (int i = 0; i < height.length; i++) {
            people.add(new Persion(height[i], weight[i]));
        }
        //按身高升序排列，体重按照降序排列，此时身高已经升序，相当于我们找体重的最长递增子序列，
        // 体重降序排列是为了防止身高体重都升序，此时如果找体重的递增子序列容易找到相同的身高
        people.sort((a, b) -> a.height != b.height ? a.height - b.height : b.weight - a.weight);
        int[] dp = new int[people.size()];//dp[i]表示长度为i+1的子序列的末尾元素，我们要想序列越长，其实想序列增长的越慢
        dp[0] = people.get(0).weight;
        int len = 1;
        for (int i = 1; i < people.size(); i++) {
            int currentWeight = people.get(i).weight;
            if (currentWeight > dp[len - 1]) {//大于末尾的元素，直接加到末尾
                dp[len++] = currentWeight;
            } else {
                int index = binarySearch(dp, len, currentWeight);
                dp[index] = currentWeight;//更新该位置的值，也就是降低该长度序列的末尾元素
            }
        }
        return len;
    }

    /**
     * 长度为len的dp[0...len-1]数组中找到第一个大于等于key的元素
     *
     * @param dp  数组
     * @param len 长度
     * @param key 目标元素
     * @return 返回找到元素的下标
     */
    private int binarySearch(int[] dp, int len, int key) {
        int left = 0, right = len;
        while (left < right) {
            int mid = (left + right) / 2;
            if (dp[mid] >= key) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;//循环结束时，left==right
    }
}