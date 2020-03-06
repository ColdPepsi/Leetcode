import entity.TreeNode;

/**
 * @author WuBiao
 * @date 2020/3/5 21:21
 */
public class Solution {
    /**
     * @param root
     * @param sum
     * @return int
     * @description 把每个结点当成根节点来处理
     * @author WuBiao
     * @date 2020/3/5 21:53
     */
    public int pathSum(TreeNode root, int sum) {

        if (root == null) {
            return 0;
        }
        int res = 0;
        //把root当成根，再分别递归左右孩子
        res += pathSumWithRoot(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
        return res;
    }

    /**
     * @param root
     * @param sum
     * @return int
     * @description 从根节点到某一结点路径和为sum的路径数。
     * @author WuBiao
     * @date 2020/3/5 21:49
     */
    private int pathSumWithRoot(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        if (root.val == sum) {
            res++;
        }
        //递归处理左右孩子
        res += pathSumWithRoot(root.left, sum - root.val) + pathSumWithRoot(root.right, sum - root.val);
        return res;
    }
}