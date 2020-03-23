import java.util.ArrayList;
import java.util.List;

/**
 * @author WuBiao
 * @date 2020/3/23 11:42
 */
public class Solution {
    /**
     * @param k
     * @param n
     * @return java.util.List<java.util.List < java.lang.Integer>>
     * @description 回溯
     * @author WuBiao
     * @date 2020/3/23 11:55
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (n < k || n > 45) {
            return res;
        }
        backTracking(k, n, res, new ArrayList<Integer>(), 1);
        return res;
    }

    /**
     * @param k
     * @param n
     * @param res
     * @param prefix
     * @param start
     * @return void
     * @description 回溯
     * @author WuBiao
     * @date 2020/3/23 11:55
     */
    private void backTracking(int k, int n, List<List<Integer>> res, List<Integer> prefix, int start) {
        if (k == prefix.size() || n == 0) {
            if (k == prefix.size() && n == 0) {
                res.add(new ArrayList<Integer>(prefix));
            }
            return;
        }
        for (int i = start; i <= 9; i++) {
            if (i > n) {
                continue;
            }
            prefix.add(i);
            backTracking(k, n - i, res, prefix, i + 1);
            prefix.remove(prefix.size() - 1);
        }
    }
}