/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import entity.ListNode;
import entity.TreeNode;

/**
 * 类Solution.java的实现描述：双dfs递归即可
 *
 * @author wubiao21 2020年10月10日 18:50:10
 */
public class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) {
            return head == null;
        }
        return dfs(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private boolean dfs(ListNode head, TreeNode root) {
        if (head == null) {
            return true;
        }
        if (root == null || root.val != head.val) {
            return false;
        }
        return dfs(head.next, root.left) || dfs(head.next, root.right);
    }
}