import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 笨方法
 *
 * @author wubiao21 2020年07月13日 09:13:46
 */
public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> count1 = new HashMap<>(nums1.length);
        Map<Integer, Integer> count2 = new HashMap<>(nums2.length);
        for (int i : nums1) {
            count1.put(i, count1.getOrDefault(i, 0) + 1);
        }
        for (int i : nums2) {
            count2.put(i, count2.getOrDefault(i, 0) + 1);
        }
        List<Integer> res = new ArrayList<>(Math.max(nums1.length, nums2.length));
        for (Map.Entry<Integer, Integer> entry : count1.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();
            int countIn2 = count2.getOrDefault(num, 0);
            int min = Math.min(count, countIn2);
            for (int i = 0; i < min; i++) {
                res.add(num);
            }
        }
        int[] ret = new int[res.size()];
        int index = 0;
        for (Integer re : res) {
            ret[index++] = re;
        }
        return ret;
    }
}