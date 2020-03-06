import entity.ListNode;

/**
 * 把链表切成两段，翻转后半段链表，然后比较是否相等
 *
 * @author WuBiao
 * @date 2020/3/4 21:33
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode l2 = reverse(slow.next);
        return isEqual(head, l2);
    }

    private ListNode reverse(ListNode head) {
        //翻转链表 206题的答案
        //当前结点的子节点的所有子结点已经翻转好了，只需要翻转自己和子节点即可。
        if (head == null || head.next == null) {
            //为空或者只有一个结点的时候，不需要翻转。
            return head;
        }
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    private boolean isEqual(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            if (l1.val != l2.val) {
                return false;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return true;
    }
}
