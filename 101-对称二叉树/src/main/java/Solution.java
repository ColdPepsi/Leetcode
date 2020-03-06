import entity.TreeNode;

/**
 * @author WuBiao
 * @date 2020/3/5 23:00
 */
public class Solution {
    /**
     * @param root
     * @return boolean
     * @description 一棵树是对称二叉树要求他的左右孩子对称。
     * @author WuBiao
     * @date 2020/3/5 23:20
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }


    /**
     * @param s
     * @param t
     * @return boolean
     * @description 判断两棵树对称
     * @author WuBiao
     * @date 2020/3/5 23:20
     */
    private boolean isSymmetric(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;//同时为空，返回真
        }
        if (s == null || t == null) {
            return false;//一空一非空，返回假
        }
        return (s.val == t.val) && isSymmetric(s.left, t.right) && isSymmetric(s.right, t.left);
    }
}
