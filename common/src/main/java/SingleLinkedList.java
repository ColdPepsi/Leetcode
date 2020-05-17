import entity.ListNode;

/**
 * @author WuBiao
 * @date 2020/3/4 19:15
 */
public class SingleLinkedList {
    /**
     * @param head
     * @return void
     * @description 遍历输出单链表
     * @author WuBiao
     * @date 2020/3/4 19:17
     */
    public static void traversal(ListNode head) {
        if (head == null) {
            System.out.println("单链表为空");
            return;
        }
        StringBuilder res = new StringBuilder();
        for (ListNode p = head; p != null; p = p.next) {
            res.append(p.val);
            if (p.next != null) {
                res.append("->");
            }
        }
        System.out.println(res);
    }

    /**
     * @param vals 数组
     * @return entity.ListNode
     * @description 把数组转化成单链表，返回头结点
     * @author WuBiao
     * @date 2020/5/16 14:09
     */
    public static ListNode generateAList(int[] vals) {
        ListNode dummyHead = new ListNode(-1);
        ListNode rear = dummyHead;
        for (int val : vals) {
            rear.next = new ListNode(val);
            rear = rear.next;
        }
        ListNode head = dummyHead.next;
        dummyHead.next = null;
        return head;
    }
}
