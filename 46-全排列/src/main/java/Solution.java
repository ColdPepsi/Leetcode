import java.util.ArrayList;
import java.util.List;

/**
 * @author WuBiao
 * @date 2020/3/22 20:08
 */
public class Solution {
    /**
     * @param nums
     * @return java.util.List<java.util.List < java.lang.Integer>>
     * @description 回溯
     * @author WuBiao
     * @date 2020/3/22 20:22
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        boolean[] hasVisited = new boolean[nums.length];
        backTracking(res, new ArrayList<>(), hasVisited, nums);
        return res;
    }

    /**
     * @param res
     * @param prefix
     * @param hasVisited
     * @param nums
     * @return void
     * @description 回溯法，排列数，不是子集树
     * @author WuBiao
     * @date 2020/3/22 20:22
     */
    private void backTracking(List<List<Integer>> res, List<Integer> prefix, boolean[] hasVisited, int[] nums) {
        if (prefix.size() == nums.length) {//找到结果把排列加到结果集中
            res.add(new ArrayList<>(prefix));//新建一个对象，如果不新建，prefix内容会被覆盖
            return;
        }
        for (int i = 0; i < hasVisited.length; i++) {//对每个没访问过的元素访问
            if (!hasVisited[i]) {
                prefix.add(nums[i]);
                hasVisited[i] = true;
                backTracking(res, prefix, hasVisited, nums);
                hasVisited[i] = false;//恢复现场
                prefix.remove(prefix.size() - 1);//恢复现场
            }
        }
    }
}