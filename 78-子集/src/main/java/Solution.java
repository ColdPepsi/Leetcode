import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author WuBiao
 * @date 2020/3/23 12:05
 */
public class Solution {
    /**
     * @param nums
     * @return java.util.List<java.util.List < java.lang.Integer>>
     * @description 求子集，每次求k大小的组合
     * @author WuBiao
     * @date 2020/3/23 12:18
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        for (int size = 0; size <= nums.length; size++) {//来求各种长度的组合
            backTracking(nums, res, new ArrayList<Integer>(), size, 0);
        }
        return res;
    }

    /**
     * @param nums
     * @param res
     * @param prefix
     * @param k
     * @param start
     * @return void
     * @description 在nums数组中找到长度为k的组合
     * @author WuBiao
     * @date 2020/3/23 12:15
     */
    private void backTracking(int[] nums, List<List<Integer>> res, List<Integer> prefix,
                              int k, int start) {
        if (prefix.size() == k) {//找到长度为k的排列，保存结果
            res.add(new ArrayList<Integer>(prefix));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            prefix.add(nums[i]);
            backTracking(nums, res, prefix, k, i + 1);
            prefix.remove(prefix.size() - 1);
        }
    }
}