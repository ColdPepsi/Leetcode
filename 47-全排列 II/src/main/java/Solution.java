import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author WuBiao
 * @date 2020/3/22 20:46
 */
public class Solution {
    /**
     * @param nums
     * @return java.util.List<java.util.List < java.lang.Integer>>
     * @description 全排列
     * @author WuBiao
     * @date 2020/3/22 21:02
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);//对nums进行排序，这是后面判重的基础
        boolean[] hasVisited = new boolean[nums.length];
        backTracking(res, hasVisited, new ArrayList<>(), nums);
        return res;
    }

    /**
     * @param res
     * @param hasVisited
     * @param prefix
     * @param nums
     * @return void
     * @description 有重复的数怎么去重是重点
     * @author WuBiao
     * @date 2020/3/22 21:02
     */
    private void backTracking(List<List<Integer>> res, boolean[] hasVisited,
                              List<Integer> prefix, int[] nums) {
        if (prefix.size() == nums.length) {//保存结果集
            res.add(new ArrayList<>(prefix));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !hasVisited[i - 1]) {
                //如果一个数和前面的数相等，并且前面一个数并没有被访问过，但是访问到自己了
                //说明前面一个数，已经被访问过了，只不过撤销了，所有自己不用访问了，访问的话和前面一个元素排列结果一样
                continue;
            }
            if (!hasVisited[i]) {//如果的当前数没有访问过
                prefix.add(nums[i]);
                hasVisited[i] = true;
                backTracking(res, hasVisited, prefix, nums);
                hasVisited[i] = false;//下面两行为恢复现场
                prefix.remove(prefix.size() - 1);
            }
        }
    }
}