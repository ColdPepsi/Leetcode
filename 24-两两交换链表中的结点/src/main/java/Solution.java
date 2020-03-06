import entity.ListNode;

/**
 * @author WuBiao
 * @date 2020/3/4 18:21
 */
public class Solution {

    public static void main(String[] args) {
        int[] vals = {1, 2, 3};
        Solution solution = new Solution();
        ListNode head = SingleLinkedList.generateAList(vals);
        head = solution.swapPairs(head.next);
        SingleLinkedList.traversal(head);
    }


    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        //front和rear分别指向要交换结点的前驱结点
        ListNode front = dummy;
        ListNode rear = head;
        //当结点数为单数时，最后rear会指向最后一个结点，但是此时已经不用交换
        while (rear != null && rear.next != null) {
            front.next = rear.next;
            rear.next = rear.next.next;
            front.next.next = rear;
            front = rear;
            rear = rear.next;
        }
        return dummy.next;
    }
}
