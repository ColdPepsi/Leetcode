import entity.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author WuBiao
 * @date 2020/3/31 13:40
 */
public class Solution {
    /**
     * @param inorder
     * @param postorder
     * @return entity.TreeNode
     * @description 后序遍历的最后一个结点是跟结点，在中序遍历中找到根节点的位置，中序遍历中跟结点的左边是左子树，右边是右子树
     * @author WuBiao
     * @date 2020/3/31 14:04
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0 || postorder == null || postorder.length == 0) {
            return null;
        }
        Map<Integer, Integer> inPosition = new HashMap<Integer, Integer>();//存放中序遍历中，元素和位置的映射
        for (int i = 0; i < inorder.length; i++) {
            inPosition.put(inorder[i], i);
        }
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, inPosition);
    }

    private TreeNode buildTree(int[] inorder, int leftIn, int rightIn,
                               int[] postorder, int leftPo, int rightPo, Map<Integer, Integer> inPosition) {
        if (leftIn > rightIn || leftPo > rightPo) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[rightPo]);
        int index = inPosition.get(postorder[rightPo]);
        root.left = buildTree(inorder, leftIn, index - 1, postorder, leftPo, leftPo + index - leftIn - 1, inPosition);
        root.right = buildTree(inorder, index + 1, rightIn, postorder, leftPo + index - leftIn, rightPo - 1, inPosition);
        return root;
    }
}