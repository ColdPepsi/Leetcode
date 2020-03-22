import java.util.ArrayList;
import java.util.List;

/**
 * @author WuBiao
 * @date 2020/3/22 21:33
 */
public class Solution {
    /**
     * @param n
     * @param k
     * @return java.util.List<java.util.List < java.lang.Integer>>
     * @description 回溯
     * @author WuBiao
     * @date 2020/3/22 21:52
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n < k || n < 1 || k < 1) {
            return res;
        }
        backTracking(res, new ArrayList<>(), k, n, 1);//从1开始
        return res;
    }

    /**
     * @param res
     * @param prefix
     * @param k
     * @param n
     * @param start
     * @return void
     * @description 回溯，求解组合的话，只回溯自己后面的元素
     * @author WuBiao
     * @date 2020/3/22 21:51
     */
    private void backTracking(List<List<Integer>> res, List<Integer> prefix, int k, int n, int start) {
        if (prefix.size() == k) {//找到结果，保存结果
            res.add(new ArrayList<>(prefix));
            return;
        }
        for (int i = start; i <= n; i++) {//因为题目要求的是组合，所以回溯自己后面的元素
            prefix.add(i);
            backTracking(res, prefix, k, n, i + 1);//回溯i后面的!!!!!
            prefix.remove(prefix.size() - 1);//去掉最后一个元素，恢复现场
        }
    }
}