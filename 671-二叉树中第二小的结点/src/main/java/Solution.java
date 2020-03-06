import entity.TreeNode;

/**
 * @author WuBiao
 * @date 2020/3/6 19:03
 */
public class Solution {

    /**
     * @param root
     * @return int
     * @description 输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
     * @author WuBiao
     * @date 2020/3/6 19:13
     */
    public int findSecondMinimumValue(TreeNode root) {
        //root为空或者左右孩子为空时 返回-1；
        if (root == null || root.left == null && root.right == null) {
            return -1;
        }
        int leftVal = root.left.val;
        int rightVal = root.right.val;
        if (root.val == leftVal) {
            //如果root和左孩子值相等，去左孩子中找第二小的
            leftVal = findSecondMinimumValue(root.left);
        }
        if (root.val == rightVal) {
            //如果root和右孩子值相等，递归处理右孩子
            rightVal = findSecondMinimumValue(root.right);
        }
        //leftVal和rightVal初始值都是正数，如果出现等于-1的情况说明进行了递归，更新了值
        if (leftVal != -1 && rightVal != -1) {
            //左右孩子中找到，則返回較小值
            return Math.min(leftVal, rightVal);
        }
        //如果上面的if沒滿足，則 leftVal或rightVal最少有1個等於-1
        if (leftVal != -1) {
            // 如果leftVal不等於-1 返回leftVal
            return leftVal;
        }
        //如果leftVal== -1，則返回rightVal
        return rightVal;
    }
}
