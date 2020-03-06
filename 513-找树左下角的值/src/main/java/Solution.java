import entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author WuBiao
 * @date 2020/3/6 20:45
 */
public class Solution {

    /**
     * @param root 已知root非空
     * @return int 给定一个二叉树，在树的最后一行找到最左边的值。
     * @description 二叉树BFS通常是每层从左往右遍历，如果改成从右往左遍历，则最后一个访问的元素就是最左边的元素
     * @author WuBiao
     * @date 2020/3/6 20:50
     */
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            root = queue.poll();//用root变量承接出队结点即可
            if (root.right != null) {
                queue.add(root.right);//右孩子先入队
            }
            if (root.left != null) {
                queue.add(root.left);
            }
        }
        return root.val;
    }
}
