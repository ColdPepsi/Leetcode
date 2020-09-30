/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import entity.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 类Solution.java的实现描述：前缀和的思想，如果两个前缀和相等，说明中间元素的区间和为0；
 *
 * @author wubiao21 2020年09月30日 16:42:09
 */
public class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        Map<Integer, ListNode> preSum = new HashMap<>();//preSum中 key保存的是前缀和，value是最晚出现该前缀和的结点
        int sum = 0;
        for (ListNode current = dummyHead; current != null; current = current.next) {
            sum += current.val;
            preSum.put(sum, current);
        }
        sum = 0;
        for (ListNode current = dummyHead; current != null; current = current.next) {
            sum += current.val;//当前的前缀和
            current.next = preSum.get(sum).next;//preSum里保存了出现当前前缀和最晚的结点，直接删除中间的结点
        }
        return dummyHead.next;
    }
}