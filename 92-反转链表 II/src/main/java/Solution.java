import entity.ListNode;

/**
 * @author WuBiao
 * @date 2020/4/22 21:23
 */
public class Solution {

    //保存当前访问元素的后继元素
    private ListNode currNext = null;

    /**
     * @param head 头结点
     * @param m    区间左端点
     * @param n    区间右端点
     * @return entity.ListNode
     * @description 翻转链表m到n个结点，索引从1开始
     * @author WuBiao
     * @date 2020/4/22 21:35
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == 1) {//baseCase，当m==1时候，相当于翻转链表前n个结点
            return reverseN(head, n);
        }
        //如果以head.next为起点相当于翻转m-1到n-1;
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;//返回头结点
    }

    /**
     * @param head 头结点
     * @param n    索引从1开始
     * @return entity.ListNode
     * @description 翻转链表前N个结点
     * @author WuBiao
     * @date 2020/4/22 21:30
     */
    private ListNode reverseN(ListNode head, int n) {
        if (n == 1) {//baseCase 如果n==1，不用翻转，直接返回头结点
            currNext = head.next;
            return head;
        }
        ListNode newHead = reverseN(head.next, n - 1);//翻转后面n-1个
        head.next.next = head;
        head.next = currNext;
        return newHead;
    }
}