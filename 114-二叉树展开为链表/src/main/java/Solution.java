import entity.TreeNode;

/**
 * @author WuBiao
 * @date 2020/4/14 22:35
 */
public class Solution {

    TreeNode preNode = null;

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.right);//先处理右孩子
        flatten(root.left);
        root.right = preNode;
        root.left = null;
        preNode = root;
    }
}
//题目要求先序遍历，根->左->右
//根据，右孩子->左孩子->根的顺序访问，pre指向前一个结点，把root的右孩子变成pre，左孩子置空