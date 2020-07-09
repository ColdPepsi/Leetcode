/**
 * @author wubiao21 2020年07月09日 18:35:02
 */
public class Solution2 {
    /**
     * 利用已经处理好的next结点
     *
     * @param root 当前处理的结点
     * @return 处理好的结点
     */
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        if (root.left != null) {
            root.left.next = root.right;//左孩子存在的话，直接让左孩子的next指向自己的右孩子
        }
        if (root.right != null) {
            root.right.next = (root.next == null ? null : root.next.left);//右孩子存在的话，如果自己的next存在，就指向自己next的左孩子
        }
        connect(root.left);
        connect(root.right);
        return root;
    }
}