import entity.TreeNode;

/**
 * @author WuBiao
 * @date 2020/5/3 14:43
 */
public class Solution {
    /**
     * @param root
     * @param target
     * @return entity.TreeNode
     * @description 后序遍历
     * @author WuBiao
     * @date 2020/5/3 14:49
     */
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);
        if (isLeaf(root) && root.val == target) {
            return null;
        }
        return root;
    }

    private boolean isLeaf(TreeNode root) {
        return root.right == null && root.left == null;
    }
}