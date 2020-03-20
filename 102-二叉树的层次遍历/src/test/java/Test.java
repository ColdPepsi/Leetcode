import entity.TreeNode;

/**
 * @author WuBiao
 * @date 2020/3/20 21:54
 */
public class Test {
    Solution solution=new Solution();

    public TreeNode buildTree(){
        TreeNode root=new TreeNode(3);
        root.left=new TreeNode(9);
        root.right=new TreeNode(20);
        root.right.left=new TreeNode(15);
        root.right.right=new TreeNode(7);
        return root;
    }
    @org.junit.Test
    public void testOrder(){
        TreeNode root=buildTree();
        solution.levelOrder(root);
    }
    
}
