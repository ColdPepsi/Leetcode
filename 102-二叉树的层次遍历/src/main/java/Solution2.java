import entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WuBiao
 * @date 2020/5/13 11:22
 */
public class Solution2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        DFS(root, 0, res);
        return res;
    }

    /**
     * @param root
     * @param level
     * @param res
     * @return void
     * @description 用深度优先完成层次遍历
     * @author WuBiao
     * @date 2020/5/13 11:28
     */
    private void DFS(TreeNode root, int level, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        if (res.size() == level) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);//把结点放入相应的层中
        DFS(root.left, level + 1, res);//处理左孩子，层数加1
        DFS(root.right, level + 1, res);//处理右孩子，层数加1
    }
}