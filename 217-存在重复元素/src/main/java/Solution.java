import java.util.HashSet;
import java.util.Set;

/**
 * @author WuBiao
 * @date 2020/3/12 19:25
 */
public class Solution {
    /**
     * @param nums
     * @return boolean
     * @description 用hashset
     * @author WuBiao
     * @date 2020/3/12 19:28
     */
    public boolean containsDuplicate(int[] nums) {
        if (nums.length < 2) {
            return false;
        }
        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            set.add(num);//加到set里
        }
        return set.size() < nums.length;//小于说明肯定有重复元素
    }
}