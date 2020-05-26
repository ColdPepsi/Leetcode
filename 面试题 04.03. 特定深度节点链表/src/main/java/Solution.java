import entity.ListNode;
import entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WuBiao
 * @date 2020/5/23 20:13
 */
public class Solution {
    /**
     * @param tree
     * @return entity.ListNode[]
     * @description 深度优先遍历实现层次遍历
     * @author WuBiao
     * @date 2020/5/23 20:47
     */
    public ListNode[] listOfDepth(TreeNode tree) {
        List<ListNode> res = new ArrayList<>();//保存结果集
        listOfDepth(res, tree, 0, new ArrayList<>());//从树根作为第0层开始
        return res.toArray(new ListNode[0]);//把结果转化成数组
    }

    /**
     * @param res   结果集
     * @param tree  树根结点
     * @param depth 当前深度
     * @param rear  保存深度为depth的链表的尾指针
     * @return void
     * @description 深度优先遍历实现层次遍历
     * @author WuBiao
     * @date 2020/5/23 20:43
     */
    private void listOfDepth(List<ListNode> res, TreeNode tree, int depth, List<ListNode> rear) {
        if (tree == null) {
            return;//树为空直接返回
        }
        ListNode temp = new ListNode(tree.val);//生成链表结点
        if (res.size() == depth) {//如果第一次到达该层
            res.add(temp);//把结点加入到结果集
            rear.add(temp);//更新尾指针
        } else {
            rear.get(depth).next = temp;//把结点接在相应层链表的末尾
            rear.set(depth, temp);//更新该链表的尾指针
        }
        listOfDepth(res, tree.left, depth + 1, rear);//递归处理左子树
        listOfDepth(res, tree.right, depth + 1, rear);//递归处理右子树
    }
}