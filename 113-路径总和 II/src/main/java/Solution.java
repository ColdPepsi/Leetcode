import entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WuBiao
 * @date 2020/6/19 22:59
 */
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        backTracking(root, 0, sum, res, new ArrayList<>());
        return res;
    }

    /**
     * @param root       当前结点指针
     * @param currentSum 当前和
     * @param sum        目标和
     * @param res        结果集
     * @param prefix     前缀路径
     * @return void
     * @description 回溯法
     * @author WuBiao
     * @date 2020/6/19 23:02
     */
    private void backTracking(TreeNode root, int currentSum, int sum, List<List<Integer>> res, List<Integer> prefix) {
        if (root == null) {
            return;
        }
        prefix.add(root.val);
        currentSum += root.val;
        if (isLeaf(root) && currentSum == sum) {
            res.add(new ArrayList<>(prefix));
        }
        backTracking(root.left, currentSum, sum, res, prefix);
        backTracking(root.right, currentSum, sum, res, prefix);
        currentSum -= root.val;//恢复现场
        prefix.remove(prefix.size() - 1);
    }

    /**
     * @param root 结点指针
     * @return boolean
     * @description 判断一个结点是否是叶子结点
     * @author WuBiao
     * @date 2020/6/19 23:02
     */
    private boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }
}
