import entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WuBiao
 * @date 2020/3/22 18:45
 */
public class Solution {
    /**
     * @param root
     * @return java.util.List<java.lang.String>
     * @description 回溯
     * @author WuBiao
     * @date 2020/3/22 19:18
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        backTracking(root, res, new ArrayList<>());
        return res;
    }

    /**
     * @param node
     * @return boolean
     * @description 判断结点是否是叶子结点
     * @author WuBiao
     * @date 2020/3/22 18:49
     */
    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    /**
     * @param values
     * @return java.lang.String
     * @description 把values里面存储的路径值转化成结果样式
     * @author WuBiao
     * @date 2020/3/22 18:56
     */
    private String buildPath(List<Integer> values) {
        StringBuilder path = new StringBuilder();
        for (Integer value : values) {
            if (path.length() > 0) {
                path.append("->");
            }
            path.append(value);
        }
        return path.toString();
    }

    /**
     * @param node
     * @param res
     * @param values
     * @return void
     * @description 回溯
     * @author WuBiao
     * @date 2020/3/22 19:14
     */
    private void backTracking(TreeNode node, List<String> res, List<Integer> values) {
        if (node == null) {
            return;
        }
        values.add(node.val);
        if (isLeaf(node)) {//如果node是叶子结点，构造路径，并装入结果集
            res.add(buildPath(values));
        } else {
            backTracking(node.left, res, values);
            backTracking(node.right, res, values);
        }
        values.remove(values.size() - 1);//处理完当前元素，把当前去掉，恢复现场,本层只恢复本层的现象
    }
}