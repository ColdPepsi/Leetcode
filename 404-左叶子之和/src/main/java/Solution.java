import entity.TreeNode;

/**
 * @author WuBiao
 * @date 2020/3/6 13:30
 */
public class Solution {
    /**
     * @param root
     * @return int
     * @description 求左叶子结点之和
     * @author WuBiao
     * @date 2020/3/6 13:52
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (isLeaf(root.left)) {//如果root的左孩子是叶子结点
            return root.left.val + sumOfLeftLeaves(root.right);
        } else {
            return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
        }
    }

    /**
     * @param node
     * @return boolean
     * @description 判断某个结点是否是叶子结点
     * @author WuBiao
     * @date 2020/3/6 13:47
     */
    private boolean isLeaf(TreeNode node) {
        if (node == null) {
            return false;
        }
        return (node.left == null && node.right == null);
    }
}
