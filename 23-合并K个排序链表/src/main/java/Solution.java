import entity.ListNode;

/**
 * @author WuBiao
 * @date 2020/4/2 19:32
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return mergeKLists(lists, 0, lists.length - 1);
    }

    /**
     * @param head1
     * @param head2
     * @return entity.ListNode
     * @description 合并两个链表
     * @author WuBiao
     * @date 2020/4/2 19:45
     */
    private ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        if (head1.val < head2.val) {
            head1.next = mergeTwoLists(head1.next, head2);
            return head1;
        } else {
            head2.next = mergeTwoLists(head1, head2.next);
            return head2;
        }
    }

    /**
     * @param lists
     * @param left
     * @param right
     * @return entity.ListNode
     * @description 合并K个链表，分治思想
     * @author WuBiao
     * @date 2020/4/2 19:45
     */
    private ListNode mergeKLists(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[right];
        }
        int mid = left + (right - left) / 2;
        ListNode head1 = mergeKLists(lists, left, mid);//递归处理左右两个区间
        ListNode head2 = mergeKLists(lists, mid + 1, right);
        return mergeTwoLists(head1, head2);//合并两个区间
    }
}