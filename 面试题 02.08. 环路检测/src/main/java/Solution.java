import entity.ListNode;

/**
 * @author WuBiao
 * @date 2020/5/26 10:34
 */
public class Solution {
    /**
     * @param head
     * @return entity.ListNode
     * @description 快慢指针做
     * @author WuBiao
     * @date 2020/5/26 11:09
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {//环形链表不会出现空指针，出现空指针说明没有环
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {//出现环
                fast = head;//让一个指针从头开始
                while (fast != slow) {//同时走，两指针相遇，即找到环入口
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}