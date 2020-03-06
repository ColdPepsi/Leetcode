import entity.TreeNode;

/**
 * @author WuBiao
 * @date 2020/3/5 23:31
 */
public class Solution {

    /**
     * @param root
     * @return int
     * @description 到叶子结点的最短距离
     * @author WuBiao
     * @date 2020/3/5 23:33
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.right == null && root.left == null) {//左右孩子同時為空時，返回1
            return 1;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (root.right == null || root.left == null) {//左右孩子只有一个为空时，返回非空孩子高度+1
            return left + right + 1;//left和right中有一个为0
        }
        //都非空的时候返回左右孩子高度较小值+1
        return Math.min(left, right) + 1;
    }
}