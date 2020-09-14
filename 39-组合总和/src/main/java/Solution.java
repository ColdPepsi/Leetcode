import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author WuBiao
 * @date 2020/3/23 10:30
 */
public class Solution {
    /**
     * @param candidates
     * @param target
     * @return java.util.List<java.util.List < java.lang.Integer>>
     * @description 回溯
     * @author WuBiao
     * @date 2020/3/23 10:41
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);//排序有利于剪枝
        backtracking(candidates, target, res, new ArrayList<>(), 0);
        return res;
    }

    /**
     * @param candidates
     * @param target
     * @param res
     * @param prefix
     * @param start
     * @return void
     * @description 回溯
     * @author WuBiao
     * @date 2020/3/23 10:40
     */
    private void backtracking(int[] candidates, int target, List<List<Integer>> res,
                              List<Integer> prefix, int start) {
        if (target <= 0) {
            if (target == 0) {
                res.add(new ArrayList<>(prefix));//保存结果
            }
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;//如果把candidates[i]放到prefix里就超过target了
            }
            prefix.add(candidates[i]);
            //下一次回溯还从i开始不是i+1，因为i可以重复利用
            backtracking(candidates, target - candidates[i], res, prefix, i);
            prefix.remove(prefix.size() - 1);//恢复现场
        }
    }
}