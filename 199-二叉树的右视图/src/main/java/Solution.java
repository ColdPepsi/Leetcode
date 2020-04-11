import entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author WuBiao
 * @date 2020/4/11 20:09
 */
public class Solution {
    /**
     * @param root
     * @return java.util.List<java.lang.Integer>
     * @description 层次遍历
     * @author WuBiao
     * @date 2020/4/11 20:16
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                root = queue.poll();
                if (i == 0) {
                    res.add(root.val);//保存每层第一个节点
                }
                if (root.right != null) {//右孩子先入队
                    queue.offer(root.right);
                }
                if (root.left != null) {
                    queue.offer(root.left);
                }
            }
        }
        return res;
    }
}