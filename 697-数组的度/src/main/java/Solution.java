import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author WuBiao
 * @date 2020/3/11 19:35
 */
public class Solution {
    /**
     * @param nums
     * @return int
     * @description 主要是应用hashmap
     * @author WuBiao
     * @date 2020/3/11 20:10
     */
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();//存储元素出现的次数
        Map<Integer, Integer> left = new HashMap<Integer, Integer>();//存储元素出现的左下标
        Map<Integer, Integer> right = new HashMap<Integer, Integer>();//存储元素出现的右下标
        for (int i = 0; i < nums.length; i++) {//依次遍历
            left.putIfAbsent(nums[i], i);//只用存储第一次
            right.put(nums[i], i);//右坐标直接覆盖就行
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);//更新count
        }
        int degree = Collections.max(count.values());//找到count中的最大值
        int ans = nums.length;
        for (Integer num : count.keySet()) {
            if (count.get(num) == degree) {//如果等于度，则找长度最小值
                ans = Math.min(ans, right.get(num) - left.get(num) + 1);
            }
        }
        return ans;
    }
}