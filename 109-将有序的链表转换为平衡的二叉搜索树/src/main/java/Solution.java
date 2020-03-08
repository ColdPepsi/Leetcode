import entity.ListNode;
import entity.TreeNode;

/**
 * @author WuBiao
 * @date 2020/3/8 19:37
 */
public class Solution {
    /**
     * @param head
     * @return entity.TreeNode
     * @description 借鉴108题思想，用链表中间的元素作为根，来构造平衡二叉搜索树
     * @author WuBiao
     * @date 2020/3/8 20:01
     */
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {//只有head一个元素，直接让head作为根并返回
            return new TreeNode(head.val);
        }
        ListNode preMid = preMid(head);
        ListNode mid = preMid.next;//获取链表中间元素
        preMid.next = null;//把head断成2个链表，分别递归左右两个部分。
        TreeNode root = new TreeNode(mid.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(mid.next);
        return root;
    }

    /**
     * @param head
     * @return entity.ListNode
     * @description 返回链表中间元素的前一个指针，用快慢指针法
     * @author WuBiao
     * @date 2020/3/8 19:56
     */
    private ListNode preMid(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode preMid = head;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            preMid = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return preMid;
    }
}