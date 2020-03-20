import entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author WuBiao
 * @date 2020/3/20 21:27
 */
public class Solution {
    /**
     * @param root
     * @return java.util.List<java.util.List < java.lang.Integer>>
     * @description 层次遍历
     * @author WuBiao
     * @date 2020/3/20 21:42
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();//每次进入循环前队列的尺寸，就是本层有几个结点
            List<Integer> temp = new ArrayList<>();//每层建立一个新数组
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                temp.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(temp);
        }
        return res;
    }
}