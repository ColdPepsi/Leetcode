import entity.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author WuBiao
 * @date 2020/3/7 12:52
 */
public class Solution {
    /**
     * @param root
     * @return java.util.List<java.lang.Integer>
     * @description 中序遍历非递归，每到一个节点 A，因为根的访问在中间，将 A 入栈。然后遍历左子树，接着访问 A，最后遍历右子树。
     * 在访问完 A 后，A 就可以出栈了。因为 A 和其左子树都已经访问完成。
     * @author WuBiao
     * @date 2020/3/7 13:12
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> nodes = new Stack<TreeNode>();
        TreeNode current = root;//指向当前结点
        while (current != null || !nodes.isEmpty()) {
            while (current != null) {
                nodes.push(current);
                current = current.left;//左孩子持续入栈
            }
            //左孩子入栈完后，开始访问
            root = nodes.pop();//访问完就可以出栈了，因为中序遍历他和她的左孩子已经访问完了，该访问右孩子了
            res.add(root.val);
            current = root.right;
        }
        return res;
    }
}