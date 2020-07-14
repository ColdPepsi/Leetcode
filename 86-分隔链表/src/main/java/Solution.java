/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import entity.ListNode;

/**
 * @author wubiao21 2020年07月14日 11:00:32
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {//链表为空或者只有1个结点时候，直接返回
            return head;
        }
        ListNode head1 = new ListNode(-1);//生成两个头两个尾
        ListNode head2 = new ListNode(-1);
        ListNode rear1 = head1;
        ListNode rear2 = head2;
        for (ListNode current = head; current != null; current = current.next) {//尾插法插入相应链表
            if (current.val < x) {
                rear1.next = current;
                rear1 = current;
            } else {
                rear2.next = current;
                rear2 = current;
            }
        }
        rear1.next = head2.next;//合并链表
        rear2.next = null;
        return head1.next;
    }
}