/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */


import entity.TreeNode;

/**
 * 类Solution.java的实现描述：TODO 类实现描述
 *
 * @author wubiao21 2020年10月16日 10:29:32
 */
public class Solution {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {//特殊处理d==1的情况
            TreeNode node = new TreeNode(v);
            node.left = root;
            return node;
        }
        return addOneRow(root, 1, v, d);
    }

    /**
     * 递归处理
     * @param root 当前处理的结点
     * @param level 当前结点的层号
     * @param v 新建结点的值
     * @param d 要插入的层号
     * @return
     */
    private TreeNode addOneRow(TreeNode root, int level, int v, int d) {
        if (root == null) {
            return null;
        }
        if (level == d - 1) {//如果在当前层的下一层插入结点
            TreeNode node1 = new TreeNode(v);//按照规则新建结点
            node1.left = root.left;
            TreeNode node2 = new TreeNode(v);
            node2.right = root.right;
            root.left = node1;
            root.right = node2;
            /* 不用递归左右孩子 可以直接返回
            addOneRow(node1.left, level + 1, v, d);//递归处理左孩子
            addOneRow(node2.right, level + 1, v, d);//递归处理右孩子
            */
        } else {//如果不在当前层的下一层插入结点直接递归处理左右孩子
            addOneRow(root.left, level + 1, v, d);
            addOneRow(root.right, level + 1, v, d);
        }
        return root;
    }
}