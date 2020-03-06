package entity;

/**
 * @author WuBiao
 * @date 2020/3/5 12:02
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }

    private TreeNode() {
    }
}
