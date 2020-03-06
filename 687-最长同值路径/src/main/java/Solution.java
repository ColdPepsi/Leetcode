import entity.TreeNode;

/**
 * @author WuBiao
 * @date 2020/3/6 14:10
 */
public class Solution {

    private int ans = 0;//保存结果


    /**
     * @param root
     * @return int
     * @description 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。
     * @author WuBiao
     * @date 2020/3/6 14:11
     */
    public int longestUnivaluePath(TreeNode root) {
        arrowLength(root);
        return ans;
    }

    /**
     * @param node
     * @return int
     * @description arrow_length(node) 为从节点 node 延伸出的最长箭头的长度
     * @author WuBiao
     * @date 2020/3/6 14:46
     */
    private int arrowLength(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = arrowLength(node.left);//求左边的最长长度
        int right = arrowLength(node.right);
        // 如果node.left.val！=node.val leftPath=0，说明断了这条路径
        int leftPath = (node.left != null && (node.left.val == node.val)) ? left + 1 : 0;
        int rightPath = (node.right != null && (node.right.val == node.val)) ? right + 1 : 0;
        ans = Math.max(ans, leftPath + rightPath);
        return Math.max(leftPath, rightPath);//返回最长路径
    }
}
