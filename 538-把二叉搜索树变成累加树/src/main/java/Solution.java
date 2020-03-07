import entity.TreeNode;

/**
 * @author WuBiao
 * @date 2020/3/7 20:06
 */
public class Solution {

    int sum = 0;//保存累加和

    /**
     * @param root
     * @return entity.TreeNode
     * @description 采用反序中序遍历，因为反序中序遍历的时候，遍历结果是从大到小，sum保存累加和，用来更新结点的值
     * @author WuBiao
     * @date 2020/3/7 20:41
     */
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.right = convertBST(root.right);
        root.val += sum;//更新结点值
        sum = root.val;//更新累加和
        root.left = convertBST(root.left);
        return root;
    }
}