import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author WuBiao
 * @date 2020/3/23 14:39
 */
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);//排序
        for (int size = 0; size <= nums.length; size++) {
            BackTracking(nums, size, res, new ArrayList<Integer>(), 0);
        }
        return res;
    }

    private void BackTracking(int[] nums, int size, List<List<Integer>> res,
                              List<Integer> prefix, int start) {
        if (prefix.size() == size) {
            res.add(new ArrayList<Integer>(prefix));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (i != start && nums[i] == nums[i - 1]) {
                continue;//组合去重，比如133，2个3都会产生3这个子集，如果第一个3已经产生过一个3，第二个3直接跳过
            }
            prefix.add(nums[i]);
            BackTracking(nums, size, res, prefix, i + 1);
            prefix.remove(prefix.size() - 1);
        }
    }
}