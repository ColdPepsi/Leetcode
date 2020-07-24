/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */


import entity.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 类Codec.java的实现描述：
 *
 * @author wubiao21 2020年07月23日 15:14:05
 */
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder stringBuilder = new StringBuilder();
        preOrderSerialize(root, stringBuilder);
        return stringBuilder.substring(0, stringBuilder.length() - 1);
    }

    private void preOrderSerialize(TreeNode root, StringBuilder stringBuilder) {
        if (root == null) {
            stringBuilder.append('#').append(',');
            return;
        }
        stringBuilder.append(root.val).append(',');
        preOrderSerialize(root.left, stringBuilder);
        preOrderSerialize(root.right, stringBuilder);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        List<String> list = new LinkedList<>(Arrays.asList(nodes));
        return preOrderDeserialize(list);
    }

    private TreeNode preOrderDeserialize(List<String> list) {
        if (list.get(0).equals("#")) {
            list.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(list.get(0)));
        list.remove(0);
        root.left = preOrderDeserialize(list);
        root.right = preOrderDeserialize(list);
        return root;
    }
}