import entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author WuBiao
 * @date 2020/3/6 20:09
 */
public class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<Double>();//存放结果
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();//BFS存放结点的队列
        queue.offer(root);//根节点入队
        int count = 0;//记录每层的结点数
        while (!queue.isEmpty()) {//队列非空时候进行循环
            count = queue.size();//每层每层的循环，每次循环前，当前queue的大小就是当前层有多少个元素
            double sum = 0;
            for (int i = 0; i < count; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) {//左孩子存在，左孩子入队
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(sum / count);//保存平均值
        }
        return res;
    }
}