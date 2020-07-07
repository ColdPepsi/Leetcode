import entity.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 类Solution.java的实现描述：先序中序序列恢复二叉树
 *
 * @author wubiao21 2020年07月07日 09:04:59
 */
public class Solution {

    private Map<Integer, Integer> inMap;//存放中序遍历的元素与位置的对应信息

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || inorder.length == 0 || preorder.length != inorder.length) {
            return null;
        }
        inMap = new HashMap<>(inorder.length);
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int preLeft, int preRight,
                               int[] inorder, int inLeft, int inRight) {
        if (preLeft > preRight) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preLeft]);
        int inorderPos = inMap.get(preorder[preLeft]);//获取在中序遍历的位置
        root.left = buildTree(preorder, preLeft + 1, preLeft + inorderPos - inLeft, inorder,
                inLeft, inorderPos - 1);
        root.right = buildTree(preorder, preLeft + inorderPos - inLeft + 1, preRight,
                inorder, inorderPos + 1, inRight);
        return root;
    }
}