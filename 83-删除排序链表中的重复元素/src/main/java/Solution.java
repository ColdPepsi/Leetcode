import entity.ListNode;

/**
 * @author WuBiao
 * @date 2020/3/4 12:30
 */
public class Solution {
    /**
     * @description 链表分成两部分，前面是未处理好的，后面是整理好的结点
     * @param head
     * @author WuBiao
     * @return entity.ListNode 返回去重链表的头结点
     * @date 2020/3/4 12:44
    */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null||head.next==null) {
            return head;
        }
        head.next=deleteDuplicates(head.next);//head.next连接已经处理好的后面的结点
        return (head.val==head.next.val)?head.next:head;//如果head.val==head.next.val，则不需要head，返回head.next。如果不相等，则说明需要head。
    }
}