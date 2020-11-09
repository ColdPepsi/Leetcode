import entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author WuBiao
 * @date 2020/3/6 23:15
 */
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();//保存结果
        if (root == null) {
            return res;
        }
        Stack<TreeNode> nodes = new Stack<TreeNode>();//保存结点
        nodes.push(root);
        while (!nodes.isEmpty()) {
            root = nodes.pop();
            if (root == null) {
                continue;//出栈结点为空，则跳过
            }
            res.add(root.val);
            if (root.right != null) {
                nodes.push(root.right);//右孩子先入栈
            }
            if (root.left != null) {
                nodes.push(root.left);
            }
        }
        return res;
    }

    /**
     * 此方法左孩子不需要入栈，只有右孩子入栈
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.offerLast(root);//根节点入栈
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pollLast();//获取栈顶结点
            while (curr != null) {
                ret.add(curr.val);//保存结果
                if (curr.right != null) {//右孩子入栈
                    stack.offerLast(curr.right);
                }
                curr = curr.left;//处理左孩子
            }
        }
        return ret;
    }
}
