import entity.TreeNode;

/**
 * @author WuBiao
 * @date 2020/3/5 22:08
 */
public class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        //t为空肯定是子树
        if (t == null) {
            return true;
        }
        if (s == null) {
            return false;
        }
        //判断两棵树是否是同一颗树，或者t是否是s的左右子树。
        return isSameTree(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    /**
     * @param s
     * @param t
     * @return boolean
     * @description 判断两棵树是否是一棵树
     * @author WuBiao
     * @date 2020/3/5 22:34
     */
    private boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;//同时为空，则相同
        }
        if (s == null || t == null) {
            return false;//一空一非空，肯定相同
        }
        return (s.val == t.val) && isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }
}