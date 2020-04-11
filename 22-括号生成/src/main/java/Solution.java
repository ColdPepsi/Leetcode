import java.util.ArrayList;
import java.util.List;

/**
 * @author WuBiao
 * @date 2020/4/3 15:30
 */
public class Solution {
    /*public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        if (n != 0) {
            DFS("", 0, 0, n, res);
        }
        return res;
    }

    *//**
     * @param curStr 当前的结果，注意类型是String，不是StringBuilder，每次都生成新的字符串，所以不用记录状态
     * @param left   左括号用了几个
     * @param right  右括号用了几个
     * @param n      括号数
     * @param res    结果集
     * @return void
     * @description 深度优先，不是回溯，因为不用记录状态
     * @author WuBiao
     * @date 2020/4/3 15:39
     *//*
    private void DFS(String curStr, int left, int right, int n, List<String> res) {
        if (left == n && right == n) {
            res.add(curStr);
        }
        if (left < right) {
            return;//如果右括号数超过左括号数，则剪枝
        }
        if (left < n) {
            DFS(curStr + '(', left + 1, right, n, res);
        }
        if (right < n) {
            DFS(curStr + ')', left, right + 1, n, res);
        }
    }*/

    /**
     * @param prefix
     * @param left
     * @param right
     * @param n
     * @param res
     * @return void
     * @description 回溯写法
     * @author WuBiao
     * @date 2020/4/6 10:18
     */
    private void backTracking(StringBuilder prefix, int left, int right, int n, List<String> res) {
        if (left > n || right > n || left < right) {//剪枝
            return;
        }
        if (left == n && right == n) {//找到结果
            res.add(prefix.toString());
            return;
        }
        prefix.append('(');
        backTracking(prefix, left + 1, right, n, res);
        prefix.delete(prefix.length() - 1, prefix.length());
        prefix.append(')');
        backTracking(prefix, left, right + 1, n, res);
        prefix.delete(prefix.length() - 1, prefix.length());
    }

    /**
     * @param n
     * @return java.util.List<java.lang.String>
     * @description 回溯写法
     * @author WuBiao
     * @date 2020/4/6 10:18
     */
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        if (n != 0) {
            backTracking(new StringBuilder(), 0, 0, n, res);
        }
        return res;
    }
}