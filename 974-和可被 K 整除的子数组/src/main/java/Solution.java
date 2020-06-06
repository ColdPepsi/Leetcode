import java.util.HashMap;
import java.util.Map;

/**
 * @author WuBiao
 * @date 2020/5/27 10:41
 */
public class Solution {
    /**
     * @param A 数组
     * @param K 参数k
     * @return int
     * @description 连续数字和的题一定要想前缀和，用map来做
     * @author WuBiao
     * @date 2020/5/27 11:11
     */
    public int subarraysDivByK(int[] A, int K) {
        Map<Integer, Integer> map = new HashMap<>(2 * A.length);
        int count = 0;
        int preSum = 0;
        map.put(0, 1);
        for (int integer : A) {
            preSum += integer;
            int mod = Math.floorMod(preSum, K);
            int temp = map.getOrDefault(mod, 0);
            count += temp;
            map.put(mod, temp + 1);
        }
        return count;
    }
}