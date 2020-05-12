import entity.ListNode;

/**
 * @author WuBiao
 * @date 2020/5/7 10:43
 */
public class Solution {
    /**
     * @param head
     * @return void
     * @description 把链表分成两部分，翻转后面部分，然后合并成一个链表
     * @author WuBiao
     * @date 2020/5/7 11:13
     */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode mid = getMid(head);
        ListNode head2 = mid.next;
        mid.next = null;//断开成两个链表
        head2 = reverseList(head2);//翻转链表
        ListNode rear = head;//head指向重排后的链表头
        while (head2 != null) {//开始拼接
            ListNode temp = head2.next;
            head2.next = rear.next;
            rear.next = head2;
            rear = head2.next;
            head2 = temp;
        }
    }

    /**
     * @param head
     * @return entity.ListNode
     * @description 翻转链表
     * @author WuBiao
     * @date 2020/5/7 10:46
     */
    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    /**
     * @param head
     * @return entity.ListNode
     * @description 快慢指针法返回中间端点，如果偶数个端点，返回中点左端点。
     * @author WuBiao
     * @date 2020/5/7 11:03
     */
    private ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            //如果循环条件用while(fast != null && fast.next != null) ，则slow指向的是中间端点的右端点
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}