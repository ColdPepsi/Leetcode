import entity.ListNode;

import java.util.Stack;

/**
 * @author WuBiao
 * @date 2020/3/4 21:10
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = stackBuilder(l1);
        Stack<Integer> stack2 = stackBuilder(l2);
        ListNode dummy=new ListNode(-1);
        int carry=0;//初始化进位为0
        while (!stack1.empty() || !stack2.empty() || carry != 0) {
            int val1=stack1.empty()?0:stack1.pop();
            int val2=stack2.empty()?0:stack2.pop();
            int sum=val1+val2+carry;
            carry=sum/10;
            //头插法插入链表
            ListNode node=new ListNode(sum%10);
            node.next=dummy.next;
            dummy.next=node;
        }
        return dummy.next;
    }

    /**
     * @param head
     * @return java.util.Stack<java.lang.Integer>
     * @description 把链表的值依次压入栈中，方便到时候从最低位开始相加
     * @author WuBiao
     * @date 2020/3/4 21:16
     */
    private Stack<Integer> stackBuilder(ListNode head) {
        Stack<Integer> stack = new Stack<Integer>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        return stack;
    }
}
