import entity.TreeNode;

/**
 * @author WuBiao
 * @date 2020/5/7 16:07
 */
public class Solution {

    private TreeNode preNode = null;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        if (preNode != null && preNode.val >= root.val) {
            return false;
        }
        preNode = root;
        return isValidBST(root.right);
    }
}