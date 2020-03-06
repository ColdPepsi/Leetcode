import entity.TreeNode;

/**
 * @author WuBiao
 * @date 2020/3/5 20:52
 */
public class Solution {

    /**
     * @param root
     * @param sum
     * @return boolean
     * @description 路径和定义为从 root 到 leaf 的所有节点的和。
     * @author WuBiao
     * @date 2020/3/5 21:08
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.right == null && root.left == null) {//如果root为根节点
            if (root.val == sum) {
                return true;
            } else {
                return false;
            }
        }
        //左孩子或右孩子有一条路径即可
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
