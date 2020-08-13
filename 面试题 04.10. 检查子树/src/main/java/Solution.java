/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */


import entity.TreeNode;

/**
 * @author wubiao21 2020年08月07日 14:01:34
 */
public class Solution {
    /**
     * 检查t2是否是t1的子树
     *
     * @param t1
     * @param t2
     * @return
     */
    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        if (t2 == null) {
            return true;
        }
        if (t1 == null) {
            return false;
        }
        return checkSubTree(t1.left, t2) || checkSubTree(t1.right, t2) || sameTree(t1, t2);
    }

    /**
     * 判断两棵树是否是同一棵树
     *
     * @param p
     * @param q
     * @return 是同一棵树返回true
     */
    public boolean sameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (q == null || p == null) {
            return false;
        }
        return p.val == q.val && sameTree(p.left, q.left) && sameTree(p.right, q.right);
    }
}