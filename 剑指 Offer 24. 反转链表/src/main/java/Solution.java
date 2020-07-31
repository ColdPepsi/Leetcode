/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import entity.ListNode;

/**
 * 类Solution.java的实现描述：复习题
 *
 * @author wubiao21 2020年07月31日 11:07:10
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {//链表为空，或者只有一个结点，无须反转，直接返回
            return head;
        }
        ListNode newHead = reverseList(head.next);//反转head后面的链表，执行完后，head后面是已经反转的链表，head还没反转
        head.next.next = head;//head后面的结点的next指针指向head；
        head.next = null;//head的next置空
        return newHead;
    }
}