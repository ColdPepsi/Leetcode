/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import entity.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * 类Solution.java的实现描述：自己封装一个结点遍历树
 *
 * @author wubiao21 2020年09月08日 13:58:09
 */
public class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Node node = packageTree(root, 0);
        TreeMap<Integer, TreeSet<Node>> ret = new TreeMap<>();
        dfs(node, ret, 0);
        //下面是拼装答案
        List<List<Integer>> res = new ArrayList<>(ret.size());
        for (Map.Entry<Integer, TreeSet<Node>> entry : ret.entrySet()) {
            List<Integer> list = new ArrayList<>(entry.getValue().size());
            for (Node temp : entry.getValue()) {
                list.add(temp.val);
            }
            res.add(list);
        }
        return res;
    }

    private void dfs(Node node, TreeMap<Integer, TreeSet<Node>> ret, int x) {
        if (node == null) {
            return;
        }
        ret.computeIfAbsent(x, set -> new TreeSet<>((a, b) -> a.level != b.level ? a.level - b.level : a.val - b.val)).add(node);
        dfs(node.left, ret, x - 1);
        dfs(node.right, ret, x + 1);
    }

    /**
     * 包装的结点，结点信息中加入层号
     *
     * @param root
     * @param level
     * @return 返回包装好的结点
     */
    private Node packageTree(TreeNode root, int level) {
        if (root == null) {
            return null;
        }
        return new Node(root.val, level, packageTree(root.left, level + 1), packageTree(root.right, level + 1));
    }
}

class Node {

    int val;
    int level;//层号
    Node left;
    Node right;

    public Node(int val, int level, Node left, Node right) {
        this.val = val;
        this.level = level;
        this.left = left;
        this.right = right;
    }
}