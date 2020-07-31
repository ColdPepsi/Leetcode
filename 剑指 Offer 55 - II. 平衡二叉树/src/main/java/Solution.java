/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import entity.TreeNode;

/**
 * @author wubiao21 2020年07月27日 16:30:32
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isBalanced(root.left) || !isBalanced(root.right)) {//左右孩子有个一不是平衡二叉树 就返回false
            return false;
        }
        //在左右孩子都是平衡二叉树的情况下判断左右树高
        return Math.abs(getDepth(root.left) - getDepth(root.right)) <= 1;
    }

    /**
     * 返回树高
     *
     * @param root 根节点
     * @return
     */
    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }
}

    