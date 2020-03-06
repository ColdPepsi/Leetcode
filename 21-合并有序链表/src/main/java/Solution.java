import entity.ListNode;

/**
 * @author WuBiao
 * @date 2020/3/4 12:13
 */
public class Solution {
    /**
     * @description 递归，两个链表头部较小的一个与剩下元素的 merge 操作结果合并。
     * @author WuBiao
     * @return
     * @date 2020/3/4 12:24
    */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val<l2.val){
            l1.next=mergeTwoLists(l1.next,l2);
            return l1;
        }else {
            l2.next=mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
