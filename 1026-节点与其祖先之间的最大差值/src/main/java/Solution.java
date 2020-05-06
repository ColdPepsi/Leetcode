import entity.TreeNode;

/**
 * @author WuBiao
 * @date 2020/4/27 16:11
 */
public class Solution {

    private static int res;//保存结果值

    public int maxAncestorDiff(TreeNode root) {
        if (root == null) {
            return 0;
        }
        res = Integer.MIN_VALUE;
        preOrder(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
        return res;
    }

    /**
     * @param root 根结点
     * @param min  路径上的最小值
     * @param max  路径上的最大值
     * @return void
     * @description 先序遍历，记录从根到叶子结点每条路径上的最大值和最小值，到叶子结点时，求出该路径上的路径差
     * @author WuBiao
     * @date 2020/4/27 16:20
     */
    private void preOrder(TreeNode root, int min, int max) {
        if (root == null) {
            return;
        }
        min = Math.min(root.val, min);
        max = Math.max(root.val, max);
        if (root.left == null && root.right == null) {
            res = Math.max(res, max - min);
        }
        preOrder(root.left, min, max);
        preOrder(root.right, min, max);
    }
}