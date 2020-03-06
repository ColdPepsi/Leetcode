import entity.TreeNode;

/**
 * @author WuBiao
 * @date 2020/3/5 12:58
 */
public class Solution {

    //保存答案
    private int ans=0;

    /**
     * @description 一条路径，可以看成以某个结点为中心，分别向左向右走
     * @param root
     * @author WuBiao
     * @return int
     * @date 2020/3/5 13:27
    */
    public int diameterOfBinaryTree(TreeNode root){
        getDepth(root);
        return ans;
    }

    /**
     * @description 获取树高
     * @param root
     * @author WuBiao
     * @return int
     * @date 2020/3/5 13:26
    */
    private int getDepth(TreeNode root){
        if (root==null){
            return 0;
        }
        int left=getDepth(root.left);
        int right=getDepth(root.right);
        ans=Math.max(ans,left+right);
        return Math.max(left,right)+1;
    }
}
