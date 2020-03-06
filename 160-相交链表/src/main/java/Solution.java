import entity.ListNode;

/**
 * @author WuBiao
 * @date 2020/3/3 16:03
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode p = headA;
        ListNode q = headB;
        while (p != q) {
            p = ((p == null) ? headB : p.next);
            q = ((q == null) ? headA : q.next);
        }
        return p;
    }
}
