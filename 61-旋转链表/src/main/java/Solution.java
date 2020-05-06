import entity.ListNode;

/**
 * @author WuBiao
 * @date 2020/4/28 19:03
 */
public class Solution {
    /**
     * @param head
     * @param k
     * @return entity.ListNode
     * @description 把链表围成一个环，找合适位置断开
     * @author WuBiao
     * @date 2020/4/28 19:37
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tail = head;
        int count = 1;//统计有多少个结点，因为开始时候指向头结点了，所以从1开始计数
        while (tail.next != null) {
            tail = tail.next;
            count++;
        }
        tail.next = head;//连成一个环；
        k %= count;//k取模
        for (int i = 1; i < count - k; i++) {//新链表的尾元素在编号count-k处，编号从1开始
            head = head.next;
        }
        ListNode newHead = head.next;//取新结点
        head.next = null;//断开环
        return newHead;
    }
}