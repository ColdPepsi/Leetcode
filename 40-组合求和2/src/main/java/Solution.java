import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author WuBiao
 * @date 2020/3/23 11:10
 */
public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);//排序有利于剪枝
        backtracking(candidates, target, res, new ArrayList<Integer>(), 0);
        return res;
    }

    private void backtracking(int[] candidates, int target, List<List<Integer>> res,
                              List<Integer> prefix, int start) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(prefix));//保存结果
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) {
                continue;//如果把candidates[i]放到prefix里就超过target了
            }
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;//去重，因为每次都向后回溯，如果一个数和前面一个元素相同，他前面回溯的结果，可能和他回溯的结果相同
                //比如1125，求8，两个1都会遍历到125，125，所以直接跳过即可
            }
            prefix.add(candidates[i]);
            //下一次回溯从i+1开始，因为i不可以重复利用
            backtracking(candidates, target - candidates[i], res, prefix, i + 1);
            prefix.remove(prefix.size() - 1);//恢复现场
        }
    }
}