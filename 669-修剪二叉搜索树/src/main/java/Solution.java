import entity.TreeNode;

/**
 * @author WuBiao
 * @date 2020/3/7 13:27
 */
public class Solution {
    /**
     * @param root
     * @param L
     * @param R
     * @return entity.TreeNode
     * @description 修剪二叉树
     * @author WuBiao
     * @date 2020/3/7 13:38
     */
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) {
            return null;
        }
        if (root.val > R) {//说明修剪后的结果出现在root的左子树上
            return trimBST(root.left, L, R);
        }
        if (root.val < L) {//説明修剪后的結果出現在右子树上
            return trimBST(root.right, L, R);
        }
        //上面的条件没满足，说明root的左右子树都需要修剪
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }
}