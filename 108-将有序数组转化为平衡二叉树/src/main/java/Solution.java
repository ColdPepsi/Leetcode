import entity.TreeNode;

/**
 * @author WuBiao
 * @date 2020/3/8 14:26
 */
public class Solution {
    /**
     * @param nums
     * @return entity.TreeNode
     * @description 因为要求构造平衡二叉树，根节点取数组中央元素，尽可能平分数组，来保持平衡。
     * @author WuBiao
     * @date 2020/3/8 14:35
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    /**
     * @param nums  输入的有序数组
     * @param begin nums数组的左下标
     * @param end   nums数组的右下标
     * @return entity.TreeNode
     * @description 通过左右下标的变换来控制递归
     * @author WuBiao
     * @date 2020/3/8 14:33
     */
    private TreeNode sortedArrayToBST(int[] nums, int begin, int end) {
        if (begin > end) {
            return null;
        }
        int mid = (begin + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);//构造根节点
        root.left = sortedArrayToBST(nums, begin, mid - 1);//递归处理左右区间
        root.right = sortedArrayToBST(nums, mid + 1, end);
        return root;//返回结果
    }
}