import entity.ListNode;

/**
 * @author WuBiao
 * @date 2020/3/5 10:01
 */
public class Solution {


    /**
     * @description 原链表存放奇数结点，偶数结点放在一个新的链表，最后拼接。
     * @param head
     * @author WuBiao
     * @return entity.ListNode
     * @date 2020/3/5 10:13
    */
    public ListNode oddEvenList(ListNode head){
        if (head==null||head.next==null) {
            return head;
        }
        //链表前两个结点分别为奇偶链表的头指针和尾指针
        ListNode oddHead=head;
        ListNode odd=head;
        ListNode evenHead=head.next;
        ListNode even=head.next;
        while (even!=null&&even.next!=null){
            odd.next=even.next;
            odd=odd.next;
            even.next=odd.next;
            even=even.next;
        }
        odd.next=evenHead;
        return oddHead;
    }
    
}
