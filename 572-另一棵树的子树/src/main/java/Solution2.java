/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import entity.TreeNode;

/**
 * 类Solution2.java的实现描述：上一个解法调用 sameTree会进行重复的if判断
 *
 * @author wubiao21 2020年08月07日 14:30:37
 */
public class Solution2 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (t == null) {
            return true;
        }
        if (s == null) {
            return false;
        }
        if (s.val == t.val) {
            return isSubtree(s.left, t.left) && isSubtree(s.right, t.right);
        } else {
            return isSubtree(s.left, t) || isSubtree(s.right, t);
        }
    }
}

    