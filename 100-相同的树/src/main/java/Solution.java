import entity.TreeNode;

/**
 * @author WuBiao
 * @date 2020/4/3 16:27
 */
public class Solution {
    /**
     * @param p
     * @param q
     * @return boolean
     * @description 递归
     * @author WuBiao
     * @date 2020/4/3 16:30
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {//同时为空为真
            return true;
        }
        if (p == null || q == null) {
            return false;//一空一非空，返回假
        }
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}