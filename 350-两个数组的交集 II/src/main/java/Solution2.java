import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 类Solution2.java的实现描述：和solution同一个思想，但是只用1个map
 *
 * @author wubiao21 2020年07月13日 09:31:49
 */
public class Solution2 {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);//保持num1的长度最短
        }
        Map<Integer, Integer> countMap = new HashMap<>(nums1.length);
        for (int num : nums1) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        int[] tempRes = new int[nums1.length];
        int index = 0;
        for (int num : nums2) {
            int count = countMap.getOrDefault(num, 0);
            if (count > 0) {
                count--;
                tempRes[index++] = num;
                if (count > 0) {
                    countMap.put(num, count);
                } else {
                    countMap.remove(num);
                }
            }
        }
        return Arrays.copyOfRange(tempRes, 0, index);
    }
}