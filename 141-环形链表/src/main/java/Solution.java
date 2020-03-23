import entity.ListNode;

/**
 * @author WuBiao
 * @date 2020/3/23 22:42
 */
public class Solution {
    /**
     * @param head
     * @return boolean
     * @description 快慢指針
     * @author WuBiao
     * @date 2020/3/23 22:47
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;//空节点或者只有1个结点，返回false
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != slow) {
            if (fast == null || fast.next == null) {
                return false;//环形链表是不会出现空指针的
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }
}