/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */


import entity.TreeNode;

/**
 * 类Solution.java的实现描述：直接后序遍历处理
 *
 * @author wubiao21 2020年09月28日 10:05:53
 */
public class Solution {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        //先处理左右子树
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        //如果左右子树都为空，并且当前结点值为0，说明以当前结点为根的子树全是0，直接返回空指针
        if (root.left == null && root.right == null && root.val == 0) {
            return null;
        }
        return root;//否则说明当前子树中含有1，直接返回root
    }
}

    