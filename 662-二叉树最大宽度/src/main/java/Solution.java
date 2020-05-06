import entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author WuBiao
 * @date 2020/4/27 21:32
 */
public class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return BFS(root);
    }

    /**
     * @param root
     * @return int
     * @description 层次遍历, 同时给每个结点坐标编号，根结点1号，左孩子是2*root，右孩子是2*root+1；
     * @author WuBiao
     * @date 2020/4/27 22:08
     */
    private int BFS(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        LinkedList<Integer> ids = new LinkedList<Integer>();
        queue.offer(root);
        ids.offer(1);
        int res = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            //计算每层的宽度，最大编号减去最小编号+1；
            res = Math.max(res, ids.getLast() - ids.getFirst() + 1);
            for (int i = 0; i < size; i++) {
                root = queue.poll();
                int temp = ids.removeFirst();//队首元素出列
                if (root.left != null) {
                    queue.offer(root.left);
                    ids.offer(temp * 2);
                }
                if (root.right != null) {
                    queue.offer(root.right);
                    ids.offer(temp * 2 + 1);
                }
            }
        }
        return res;
    }
}