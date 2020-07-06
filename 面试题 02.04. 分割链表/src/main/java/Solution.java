/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import entity.ListNode;

/**
 * @author wubiao21 2020年07月06日 14:59:48
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode head1 = new ListNode(-1);
        ListNode head2 = new ListNode(-2);
        ListNode tail1 = head1;//head1的头指针
        ListNode tail2 = head2;//head2的尾指针
        ListNode p = head;
        while (p != null) {
            ListNode next = p.next;//保存p的下一个结点
            if (p.val < x) {
                //尾插法插入到head1中
                tail1.next = p;
                tail1 = p;
            } else {
                //尾插法插入到head2中
                tail2.next = p;
                tail2 = p;
            }
            p = next;//开始下一个结点
        }
        //下面开始拼接
        tail1.next = head2.next;//跳过生成的头结点
        tail2.next = null;//tail2末尾要置空，不然链表会产生环
        return head1.next;
    }
}