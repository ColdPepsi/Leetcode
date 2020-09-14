/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */


import entity.TreeNode;

/**
 * 类Solution.java的实现描述：数组第一个值就是根，找到数组中第一个大于根的值，左边就是左子树，右边就是右子树
 *
 * @author wubiao21 2020年09月10日 17:42:20
 */
public class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder, 0, preorder.length - 1);
    }

    private TreeNode bstFromPreorder(int[] preorder, int left, int right) {
        if (left > right) {
            return null;
        }
        int index = left;
        while (index <= right) {
            if (preorder[index] <= preorder[left]) {
                index++;
            } else {
                break;
            }
        }
        TreeNode root = new TreeNode(preorder[left]);
        root.left = bstFromPreorder(preorder, left + 1, index - 1);
        root.right = bstFromPreorder(preorder, index, right);
        return root;
    }
}