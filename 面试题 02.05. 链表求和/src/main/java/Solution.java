import entity.ListNode;

/**
 * @author WuBiao
 * @date 2020/4/16 19:43
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        int carry = 0;
        ListNode dummyHead = new ListNode(-1);
        ListNode rear = dummyHead;
        while (carry != 0 || l1 != null || l2 != null) {
            int val1 = (l1 == null ? 0 : l1.val);
            int val2 = (l2 == null ? 0 : l2.val);
            carry += val1 + val2;
            ListNode temp = new ListNode(carry % 10);
            rear.next = temp;
            rear = temp;
            carry /= 10;
            l1 = (l1 == null ? null : l1.next);
            l2 = (l2 == null ? null : l2.next);
        }
        return dummyHead.next;
    }
}