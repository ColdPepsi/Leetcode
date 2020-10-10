/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import entity.ListNode;

/**
 * 类Solution.java的实现描述：快慢指针
 *
 * @author wubiao21 2020年10月10日 09:35:47
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        /*
         * 寻找环的入口时候，fast和slow指针初始化要注意，要不就都等于head，要不就slow==head.next,fast=head.next.next。
         * 因为寻找环入口时候依据的推导公式是fast走的路程是slow的两倍。
         * 当判断是否存在环的时候，初始值相对自由，最终会相遇。
         */
        ListNode fast = head;
        ListNode slow = head;
        do {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        } while (fast != slow);
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}

    