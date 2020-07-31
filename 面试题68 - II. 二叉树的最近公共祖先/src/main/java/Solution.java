/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import entity.TreeNode;

/**
 * @author wubiao21 2020年07月27日 09:54:16
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {//root等于其中1个，返回root
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);//低估处理左右区间
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {//如果左右两边都存在祖先 就返回root
            return root;
        }
        if (left != null) {//左边找到祖先 返回左边
            return left;
        }
        return right;//左边没找到 直接返回右边
    }
}