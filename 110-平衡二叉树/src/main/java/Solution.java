import entity.TreeNode;

/**
 * @author WuBiao
 * @date 2020/3/5 12:18
 */
public class Solution {

//    /**
//     * @param root
//     * @return boolean
//     * @description 平衡二叉树：所有结点左右孩子高度差绝对值不超过1。
//     * @author WuBiao
//     * @date 2020/3/5 12:19
//     */
//    public boolean isBalanced(TreeNode root) {
//        if (root == null) {
//            return true;
//        }
//        int leftDepth = getDepth(root.left);
//        int rightDepth = getDepth(root.right);
//        if (Math.abs(leftDepth - rightDepth) > 1) {
//            return false;
//        }
//        return isBalanced(root.left) && isBalanced(root.right);
//    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        //左右孩子都是平衡二叉树，再判断树高
        if (isBalanced(root.left) && isBalanced(root.right)) {
            if (Math.abs(getDepth(root.left) - getDepth(root.right)) > 1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }


    /**
     * @param root
     * @return int
     * @description 获取树高
     * @author WuBiao
     * @date 2020/3/5 12:26
     */
    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
