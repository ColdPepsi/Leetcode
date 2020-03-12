import java.util.HashMap;
import java.util.Map;

/**
 * @author WuBiao
 * @date 2020/3/12 19:14
 */
public class Solution {
    /**
     * @param nums
     * @param target
     * @return int[]
     * @description 可利用hashmap
     * @author WuBiao
     * @date 2020/3/12 19:21
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexOfMap = new HashMap<Integer, Integer>();//存放数组元素下标映射
        for (int i = 0; i < nums.length; i++) {
            if (indexOfMap.containsKey(target - nums[i])) {//如果target-num[i],已经在map中，返回结果
                return new int[]{indexOfMap.get(target - nums[i]), i};
            } else {
                indexOfMap.put(nums[i], i);
            }
        }
        return null;
    }
}