import entity.TreeNode;

/**
 * @author WuBiao
 * @date 2020/3/8 13:49
 */
public class Solution {

    /**
     * @param root
     * @param p
     * @param q
     * @return entity.TreeNode
     * @description 处理递归问题时，先想函数的返回值是什么，怎么利用
     * @author WuBiao
     * @date 2020/3/8 14:05
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == q || root == p) {
            return root;//root等于其中的一个，则返回root
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);//递归处理左右孩子
        if (left == null) {//说明祖先在右边
            return right;
        }
        if (right == null) {
            return left;//left != null&&right == null 说明祖先在左边
        }
        return root;//如果left != null&&right ！= null 说明pq分别在root的两边，left和right都只搜到了1个结点的祖先。
    }
}