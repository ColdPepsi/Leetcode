import entity.ListNode;

/**
 * @author WuBiao
 * @date 2020/5/16 13:41
 */
public class Solution {

    private ListNode successor = null;

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k < 1) {
            return head;
        }
        int count = countNode(head);
        int end = k;
        while (end <= count) {
            int start = end - k + 1;
            head = reverseBetweenMandN(head, start, end);
            end += k;
        }
        return head;
    }

    /**
     * @param head 头结点
     * @param n    参数n
     * @return entity.ListNode
     * @description 翻转链表前n个结点，索引从1开始
     * @author WuBiao
     * @date 2020/5/16 13:45
     */
    private ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }
        ListNode newHead = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return newHead;
    }

    /**
     * @param head 头结点
     * @param m    参数m
     * @param n    参数n
     * @return entity.ListNode
     * @description 翻转链表从m到n，索引从1开始
     * @author WuBiao
     * @date 2020/5/16 13:48
     */
    private ListNode reverseBetweenMandN(ListNode head, int m, int n) {
        if (m == 1) {//m==1相当于翻转前n个结点
            return reverseN(head, n);
        }
        head.next = reverseBetweenMandN(head.next, m - 1, n - 1);
        return head;
    }

    /**
     * @param head 头结点
     * @return int
     * @description 统计链表有多少个结点
     * @author WuBiao
     * @date 2020/5/16 13:53
     */
    private int countNode(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
}