import java.util.HashMap;
import java.util.Map;

/**
 * @author WuBiao
 * @date 2020/3/12 19:46
 */
public class Solution {
    /**
     * @param nums
     * @return int
     * @description 定义一个map存放元素出现的次数，我们假设最长序列是以索引i结束的，遍历到num[i]时，
     * 找到num[i]-1，num[i]，num[i]+1的次数，uvw，最大值是u+v或者v+w
     * @author WuBiao
     * @date 2020/3/12 19:54
     */
    public int findLHS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();//存储元素出现的次数
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);//次数加1
            if (map.containsKey(nums[i] - 1)) {
                res = Math.max(res, map.get(nums[i]) + map.get(nums[i] - 1));
            }
            if (map.containsKey(nums[i] + 1)) {
                res = Math.max(res, map.get(nums[i]) + map.get(nums[i] + 1));
            }
        }
        return res;
    }
}