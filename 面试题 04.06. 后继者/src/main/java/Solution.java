/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */


import entity.TreeNode;

/**
 * @author wubiao21 2020年07月29日 18:46:51
 */
public class Solution {

    private TreeNode pre = null;//记录当前遍历结点的前一个结点

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        inOrder(root, p);
        return pre == p ? null : pre;//如果pre==p,说明p是最后一个结点，此时返回null
    }

    /**
     * 在以root为根节点的树中寻找p的后序结点
     *
     * @param root
     * @param p
     * @return 找到返回true
     */
    private boolean inOrder(TreeNode root, TreeNode p) {
        if (root == null) {
            return false;
        }
        if (inOrder(root.left, p)) {//如果在左孩子中找到p，就提前返回
            return true;
        }
        if (pre == p) {//如果pre==p，说明root就是我们想找的值，更新pre，返回true
            pre = root;
            return true;
        }
        pre = root;//没有找到结果的话，pre指向向前结点，然后遍历右孩子
        return inOrder(root.right, p);
    }
}