/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import entity.TreeNode;

import java.util.TreeSet;

/**
 * 类Solution.java的实现描述：TODO 类实现描述
 *
 * @author wubiao21 2020年09月08日 16:03:16
 */
public class Solution {
    public String smallestFromLeaf(TreeNode root) {
        TreeSet<String> set = new TreeSet<>();
        dfs(root, new StringBuilder(), set);
        return set.first();
    }

    private void dfs(TreeNode root, StringBuilder prefix, TreeSet<String> set) {
        if (root == null) {
            return;
        }
        prefix.append((char) ('a' + root.val));
        if (isLeaf(root)) {
            set.add(new String(prefix.reverse()));
            prefix.reverse();
        }
        dfs(root.left, prefix, set);
        dfs(root.right, prefix, set);
        prefix.deleteCharAt(prefix.length() - 1);
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}