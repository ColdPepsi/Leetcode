import entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WuBiao
 * @date 2020/3/8 21:35
 */
public class Solution {

    private int curCount = 1;//存储当前元素出现的次数
    private int maxCount = -1;//出现的最大的次数
    private TreeNode preNode = null;//存储当前结点的前一个结点

    /**
     * @param root
     * @return int[]
     * @description 利用中序遍历来统计
     * @author WuBiao
     * @date 2020/3/8 22:48
     */
    public int[] findMode(TreeNode root) {
        List<Integer> nodes = new ArrayList<Integer>();
        inOrder(root, nodes);
        int[] res = new int[nodes.size()];
        int i = 0;
        for (Integer node : nodes) {//把nodes转为int数组
            res[i++] = node;
        }
        return res;
    }

    /**
     * @param root
     * @param nodes
     * @return void
     * @description 通过中序遍历更新
     * @author WuBiao
     * @date 2020/3/8 22:27
     */
    private void inOrder(TreeNode root, List<Integer> nodes) {
        if (root == null) {
            return;
        }
        inOrder(root.left, nodes);
        if (preNode != null) {
            if (preNode.val == root.val) {
                curCount++;//当前结点和前一个结点值相同，更新curCount
            } else {
                curCount = 1;//否则重置
            }
        }
        if (curCount > maxCount) {
            nodes.clear();
            nodes.add(root.val);
            maxCount = curCount;
        } else if (curCount == maxCount) {
            nodes.add(root.val);
        }
        preNode = root;//更新root
        inOrder(root.right, nodes);
    }
}