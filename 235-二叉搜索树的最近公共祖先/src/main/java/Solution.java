import entity.TreeNode;

/**
 * @author WuBiao
 * @date 2020/3/7 23:06
 */
public class Solution {
    /**
     * @param root
     * @param p
     * @param q
     * @return entity.TreeNode
     * @description 二叉搜索树的最近公共祖先。利用二叉搜索树结点值大小的性质
     * @author WuBiao
     * @date 2020/3/7 23:18
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) {//如果root的值最大，则在root的左子树中查找
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {//root值最小，则在root的右子树中查找
            return lowestCommonAncestor(root.right, p, q);
        } else {//root处于中间，则返回root
            return root;
        }
    }
}