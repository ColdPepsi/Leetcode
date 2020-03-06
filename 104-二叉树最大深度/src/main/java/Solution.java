import entity.TreeNode;

/**
 * @author WuBiao
 * @date 2020/3/5 12:07
 */
public class Solution {
    /**
     * @param root
     * @return int
     * @description 递归，树的高度等于左右孩子的最高值+1；
     * @author WuBiao
     * @date 2020/3/5 12:09
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
