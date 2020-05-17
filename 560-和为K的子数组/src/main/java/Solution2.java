import java.util.HashMap;
import java.util.Map;

/**
 * @author WuBiao
 * @date 2020/5/15 15:06
 */
public class Solution2 {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);//map映射里保存某个累加和出现的次数
        int preSum = 0;//preSum记录从数组第一个元素到当前元素的累加和，nums[j...i]相加的和为preSum[i]-preSum[j-1]
        int res = 0;
        map.put(0, 1);//初始化map里面累加和0出现的次数为1，nums[0...i]的累加和为preSum[i]-preSum[-1]，perSum[-1]为，我们设置为0，map里累加和为0出现了1次
        for (int num : nums) {
            preSum += num;
            res += map.getOrDefault(preSum - k, 0);
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return res;
    }
}