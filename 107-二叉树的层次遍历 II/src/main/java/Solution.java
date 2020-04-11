import entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @author WuBiao
 * @date 2020/4/11 19:45
 */
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> level = new ArrayList<>();
        Stack<List<Integer>> stack = new Stack<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            level.clear();
            for (int i = 0; i < size; i++) {//一层一层的遍历
                root = queue.poll();
                level.add(root.val);
                if (root.left != null) {
                    queue.offer(root.left);
                }
                if (root.right != null) {
                    queue.offer(root.right);
                }
            }
            stack.push(new ArrayList<>(level));
        }
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
        return res;
    }
}