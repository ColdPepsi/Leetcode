/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import entity.TreeNode;

/**
 * 类Solution.java的实现描述:直接遍历也行,下面这个解法利用完全二叉树的性质
 *
 * @author wubiao21 2020年11月12日 10:44:40
 */
public class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        if (leftDepth == rightDepth) {//左子树是满，递归计算右子树
            return (int) Math.pow(2, leftDepth) + countNodes(root.right);
        } else {//右子树是满的，比左子树少一层，递归计算左子树
            return (int) Math.pow(2, rightDepth) + countNodes(root.left);
        }
    }

    /**
     * 完全二叉树的高度可以直接通过不断地访问左子树就可以获取
     * @param root
     * @return
     */
    private int getDepth(TreeNode root) {
        int depth = 0;
        while (root != null) {
            depth++;
            root = root.left;
        }
        return depth;
    }
}