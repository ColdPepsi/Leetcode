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
 * @author wubiao21 2020年t07月20日 11:09:49
 */
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder prefix = new StringBuilder();
        preOrder(root, prefix);
        return prefix.substring(0, prefix.length() - 1);//去掉最后一个逗号
    }

    /**
     * 先序遍历树，用来序列化
     *
     * @param root   当前访问的结点
     * @param prefix 前缀
     */
    private void preOrder(TreeNode root, StringBuilder prefix) {
        if (root == null) {
            prefix.append("#,");//空指针用“#”表示
            return;
        }
        prefix.append(root.val).append(',');
        preOrder(root.left, prefix);
        preOrder(root.right, prefix);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        List<String> list = new LinkedList<>(Arrays.asList(nodes));//把结点加到list中，因为会涉及删除结点，所以用链表
        return buildTree(list);
    }

    private TreeNode buildTree(List<String> list) {
        if (list.get(0).equals("#")) {//说明该结点为空
            list.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(list.get(0)));
        list.remove(0);
        root.left = buildTree(list);//递归处理左右孩子
        root.right = buildTree(list);
        return root;
    }
}