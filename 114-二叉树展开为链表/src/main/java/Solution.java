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
        root.right = preNode;//当前结点的右孩子指向pre
        root.left = null;//把左孩子置空
        preNode = root;//pre指向root
    }
}
//题目要求先序遍历，根->左->右
//先序遍历和后序遍历有一个对应关系，先序遍历如果左右孩子遍历顺序颠倒一下，遍历顺序变成根->右->左，然后遍历序列在逆序就是后序遍历序列，
//此时变成左->右->根
/*----------------------------------------------------*/
//同理，我们可以通过后序遍历颠倒一下左右孩子的顺序，先序遍历的逆序
//pre指向前一个结点，遍历到root时候，把root的右孩子变成pre，左孩子置空，因为左右孩子已经处理过，不用担心会覆盖左右孩子