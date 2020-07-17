/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import entity.Node;

/**
 * BST先想中序遍历
 *
 * @author wubiao21 2020年07月17日 10:51:44
 */
public class Solution {

    private Node pre;//保存前一个结点
    private Node head;//保存头结点

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        pre = null;
        head = null;
        inOrder(root);
        pre.right = head;//衔接头尾
        head.left = pre;
        return head;
    }

    private void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        if (pre == null) {//说明root是第一个结点，更新头结点
            head = root;
        } else {//pre不空，则接到pre后面，尾插法
            pre.right = root;
            root.left = pre;
        }
        pre = root;
        inOrder(root.right);
    }
}