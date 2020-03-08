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
        ListNode newHead = reverseList(head.next);//head.next为首的链表已经翻转完毕，现在head.next是链表的最后一个元素。
        head.next.next = head;//head.next下一个元素指向head
        head.next = null;//head.next设为空，head是链表的最后一个结点。
        return newHead;
    }
}
