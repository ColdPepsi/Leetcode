import entity.ListNode;

/**
 * @author WuBiao
 * @date 2020/3/3 22:55
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        //假设自己的子节点后面的结点已经反转好，只需反转自己和自己的子节点即可
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
