import entity.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author WuBiao
 * @date 2020/3/7 12:41
 */
public class Solution {
    /**
     * @param root
     * @return java.util.List<java.lang.Integer>
     * @description 在先序遍历的基础上修改一下
     * @author WuBiao
     * @date 2020/3/7 12:49
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> nodes = new Stack<TreeNode>();
        nodes.push(root);
        while (!nodes.isEmpty()) {
            root = nodes.pop();
            res.add(root.val);
            if (root.left != null) {
                nodes.push(root.left);//左孩子先入栈
            }
            if (root.right != null) {
                nodes.push(root.right);
            }
        }
        Collections.reverse(res);
        return res;
    }
}