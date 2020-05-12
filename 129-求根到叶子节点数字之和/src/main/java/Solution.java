import entity.TreeNode;

/**
 * @author WuBiao
 * @date 2020/5/8 21:50
 */
public class Solution {

    private int res = 0;//保存结果

    public int sumNumbers(TreeNode root) {
        preOrder(root, 0);
        return res;
    }

    /**
     * @param root
     * @return boolean
     * @description 判断一个结点是否是叶子结点
     * @author WuBiao
     * @date 2020/5/8 21:58
     */
    private boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }

    /**
     * @param root
     * @param currentSum
     * @return void
     * @description 先序遍历
     * @author WuBiao
     * @date 2020/5/8 21:58
     */
    private void preOrder(TreeNode root, int currentSum) {
        if (root == null) {
            return;
        }
        currentSum = currentSum * 10 + root.val;
        if (isLeaf(root)) {
            res += currentSum;
        }
        preOrder(root.left, currentSum);
        preOrder(root.right, currentSum);
    }
}