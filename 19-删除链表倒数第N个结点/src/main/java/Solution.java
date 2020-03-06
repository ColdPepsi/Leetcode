import entity.ListNode;

/**
 * @author WuBiao
 * @date 2020/3/4 13:10
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //生成一个哑结点当头结点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        int k = 0;
        while (fast.next != null) {
            fast = fast.next;
            k++;
            if (k > n) {
                slow = slow.next;
            }
        }
        //遍历结束后slow指向要删除结点的前一个结点
        slow.next = slow.next.next;
        return dummy.next;
    }
}
