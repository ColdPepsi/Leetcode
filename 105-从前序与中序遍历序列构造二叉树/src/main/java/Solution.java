import entity.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author WuBiao
 * @date 2020/3/31 14:09
 */
public class Solution {

    private Map<Integer, Integer> inPosition = new HashMap<Integer, Integer>();
    private int[] preorder;
    private int[] inorder;

    /**
     * @param preorder 先序遍历序列
     * @param inorder  中序遍历序列
     * @return entity.TreeNode
     * @description 先序遍历的第一个元素是根节点，在中序遍历中找到根节点的坐标，中序遍历中根节点的左边就是左子树，右边就是右子树
     * @author WuBiao
     * @date 2020/3/31 14:22
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        for (int i = 0; i < inorder.length; i++) {
            inPosition.put(inorder[i], i);//存放元素和位置的映射
        }
        return buildTree(0, preorder.length - 1, 0, inorder.length - 1);
    }

    /**
     * @param leftPre  先序遍历左端点
     * @param rightPre 先序遍历右端点
     * @param leftIn   中序遍历左端点
     * @param rightIn  中序遍历右端点
     * @return entity.TreeNode
     * @description 通过左右区间大小控制递归
     * @author WuBiao
     * @date 2020/3/31 14:25
     */
    private TreeNode buildTree(int leftPre, int rightPre, int leftIn, int rightIn) {
        if (leftPre > rightPre || leftIn > rightIn) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[leftPre]);
        int index = inPosition.get(preorder[leftPre]);
        root.left = buildTree(leftPre + 1, leftPre + index - leftIn, leftIn, index - 1);
        root.right = buildTree(leftPre + index - leftIn + 1, rightPre, index + 1, rightIn);
        return root;
    }
}