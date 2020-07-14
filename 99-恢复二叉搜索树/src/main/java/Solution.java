/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import entity.TreeNode;

/**
 * @author wubiao21 2020年07月14日 10:11:11
 */
public class Solution {

    private TreeNode pre = null;//保存当前遍历结点的前一个结点
    private TreeNode first = null;//第一个交换的结点
    private TreeNode second = null;//第二个交换的结点

    public void recoverTree(TreeNode root) {
        findTowSwapped(root);
        swap(first, second);
    }

    /**
     * 交换两个结点的值
     *
     * @param node1 结点1
     * @param node2 结点2
     */
    private void swap(TreeNode node1, TreeNode node2) {
        node1.val += node2.val;
        node2.val = node1.val - node2.val;
        node1.val -= node2.val;
    }

    /**
     * 中序遍历求交换的结点
     *
     * @param root 当前遍历的结点
     */
    private void findTowSwapped(TreeNode root) {
        if (root == null) {
            return;
        }
        findTowSwapped(root.left);
        if (pre != null && root.val < pre.val) {//发现不是递增的值
            second = root;//这里的赋值很巧妙
            if (first == null) {
                first = pre;
            } else {
                return;
            }
        }
        pre = root;//pre指向当前结点
        findTowSwapped(root.right);
    }
}