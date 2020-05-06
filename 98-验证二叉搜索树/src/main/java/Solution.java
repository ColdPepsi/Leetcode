import entity.TreeNode;

/**
 * @author WuBiao
 * @date 2020/5/5 21:49
 */
public class Solution {

    TreeNode preNode = null;//指向中序遍历，当前结点的前一个结点

    public boolean isValidBST(TreeNode root) {
        if (root == null) {//空节点为二叉排序树
            return true;
        }
        if (isValidBST(root.left)) {//如果左孩子是二叉排序树的话，进行下面的步骤
            if (preNode != null && preNode.val >= root.val) {
                return false;//不满足条件的话直接返回false
            }
            preNode = root;//满足条件的话，就让preNode指向当前结点
            return isValidBST(root.right);//前面都满足的话，看右孩子是否是二叉搜索树
        }
        return false;//左孩子不是二叉排序树的话直接返回false
    }
}