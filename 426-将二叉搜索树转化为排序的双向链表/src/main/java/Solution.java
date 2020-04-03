import entity.Node;

/**
 * @author WuBiao
 * @date 2020/4/3 16:39
 */
public class Solution {

    private Node first = null;//指向第一个结点
    private Node last = null;//指向当前结点，遍历完后，指向最后一个结点

    /**
     * @param root
     * @return entity.Node
     * @description 二叉搜索树优先想中序遍历
     * @author WuBiao
     * @date 2020/4/3 17:13
     */
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        inOrder(root);
        //然后进行收尾相连，形成循环链表
        first.left = last;
        last.right = first;
        return first;
    }

    /**
     * @param root
     * @return void
     * @description 中序遍历
     * @author WuBiao
     * @date 2020/4/3 17:11
     */
    private void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);//先处理左子树

        if (first == null) {
            first = root;
        }
        if (last == null) {
            last = root;
        } else {//如果last不为空，则进行连接
            last.right = root;
            root.left = last;
            last = root;
        }

        inOrder(root.right);//处理右子树
    }
}