import entity.TreeNode;

/**
 * @author WuBiao
 * @date 2020/3/5 14:41
 */
public class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {//都为空时，返回空
            return null;
        }
        if (t1 == null) {//t1为空，t2不为空则返回t2
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        TreeNode root = new TreeNode(t1.val + t2.val);//构造根节点
        root.left = mergeTrees(t1.left, t2.left);//递归处理左孩子
        root.right = mergeTrees(t1.right, t2.right);//递归处理右孩子
        return root;
    }
}
