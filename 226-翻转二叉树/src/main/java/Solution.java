import entity.TreeNode;

/**
 * @author WuBiao
 * @date 2020/3/5 14:16
 */
public class Solution {
    /**
     * @param root
     * @return entity.TreeNode
     * @description 翻转二叉树
     * @author WuBiao
     * @date 2020/3/5 14:20
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = invertTree(root.left);
        root.right = invertTree(root.right);
        //交换左右孩子
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }
}
