import entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author WuBiao
 * @date 2020/6/19 23:06
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        DFS(root, 0, res);
        return res;
    }

    /**
     * @param root  当前遍历的结点
     * @param level 层坐标
     * @param res   结果集
     * @return void
     * @description DFS实现BFS
     * @author WuBiao
     * @date 2020/6/19 23:08
     */
    private void DFS(TreeNode root, int level, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        if (res.size() <= level) {
            res.add(new LinkedList<>());//用链表，头部插入效率高
        }
        if (level % 2 == 0) {//如果是偶数层，采用尾插法
            res.get(level).add(root.val);
        } else {//奇数层，采用头插法
            res.get(level).add(0, root.val);
        }
        DFS(root.left, level + 1, res);//递归处理左孩子
        DFS(root.right, level + 1, res);//递归处理右孩子
    }
}
