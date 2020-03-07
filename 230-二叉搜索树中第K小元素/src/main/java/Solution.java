import entity.TreeNode;

/**
 * @author WuBiao
 * @date 2020/3/7 16:49
 */
public class Solution {
    /**
     * @param root
     * @param k
     * @return int 二叉搜索树中第K小的元素的值
     * @description 用动态顺序统计的思想来做
     * @author WuBiao
     * @date 2020/3/7 17:06
     */
    public int kthSmallest(TreeNode root, int k) {
        int leftSize = Size(root.left);
        if (leftSize + 1 == k) {
            return root.val;//根是第K个数
        } else if (leftSize + 1 < k) {//在root的右子树中查找
            return kthSmallest(root.right, k - leftSize - 1);
        } else {//左子树中查找
            return kthSmallest(root.left, k);
        }
    }

    /**
     * @param root
     * @return int
     * @description 求以root为根的子树包含的所有结点数（包含root）
     * @author WuBiao
     * @date 2020/3/7 17:11
     */
    private int Size(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Size(root.left) + Size(root.right) + 1;
    }
}