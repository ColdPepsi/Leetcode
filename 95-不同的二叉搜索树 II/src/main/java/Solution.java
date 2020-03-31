import entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WuBiao
 * @date 2020/3/31 16:36
 */
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {//n为0时候返回空结果
            return new ArrayList<TreeNode>();
        }
        return generateTrees(1, n);
    }

    /**
     * @param left  区间左端点
     * @param right 区间右端点
     * @return java.util.List<entity.TreeNode>
     * @description 从[1, n]中每个数都做一回根节点，i为根，则[1,i-1]为左子树,[i+1,n]为右子树。
     * @author WuBiao
     * @date 2020/3/31 17:01
     */
    private List<TreeNode> generateTrees(int left, int right) {
        List<TreeNode> res = new ArrayList<TreeNode>();//用于保存返回的结果集
        if (left > right) {
            res.add(null);
            return res;
        }
        for (int i = left; i <= right; i++) {//尝试区间里每个点作为根
            List<TreeNode> leftChildren = generateTrees(left, i - 1);//得到左子树的所有组合
            List<TreeNode> rightChildren = generateTrees(i + 1, right);//得到右子树的所有组合
            for (TreeNode leftChild : leftChildren) {//组合左右孩子的每种组合
                for (TreeNode rightChild : rightChildren) {
                    TreeNode root = new TreeNode(i);//这句不能写在双循环的外面，不能共用结果，每种组合作为一个结果
                    root.left = leftChild;
                    root.right = rightChild;
                    res.add(root);
                }
            }
        }
        return res;
    }
}