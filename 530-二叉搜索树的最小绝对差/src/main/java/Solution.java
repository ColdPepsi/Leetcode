import entity.TreeNode;

/**
 * @author WuBiao
 * @date 2020/3/8 21:08
 */
public class Solution {

    private int minVal = Integer.MAX_VALUE;//保存最小值
    private TreeNode pre = null;//保存当前结点的前一个结点

    /**
     * @param root
     * @return int
     * @description 利用BST性质，升序遍历获取升序序列，找到相邻两个值最小的差
     * @author WuBiao
     * @date 2020/3/8 21:27
     */
    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return minVal;
    }

    /**
     * @param root
     * @return void
     * @description 通过中序遍历获取升序遍历，获取最小的两个值的差
     * @author WuBiao
     * @date 2020/3/8 21:26
     */
    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        if (pre != null) {
            minVal = Math.min(minVal, root.val - pre.val);
        }
        pre = root;
        inOrder(root.right);
    }
}