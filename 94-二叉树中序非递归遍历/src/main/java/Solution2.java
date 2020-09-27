/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 类Solution2.java的实现描述：用linkedlist来代替stack，速度会快很多
 *
 * @author wubiao21 2020年09月14日 09:44:23
 */
public class Solution2 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        TreeNode currentNode = root;
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (currentNode != null || !stack.isEmpty()) {
            while (currentNode != null) {
                stack.offerLast(currentNode);
                currentNode = currentNode.left;
            }
            currentNode = stack.pollLast();
            res.add(currentNode.val);
            currentNode = currentNode.right;
        }
        return res;
    }
}