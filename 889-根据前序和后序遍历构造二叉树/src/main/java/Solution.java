/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import entity.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 类Solution.java的实现描述：前序遍历和后序遍历不能确定一棵唯一的树
 *
 * @author wubiao21 2020年09月28日 10:55:02
 */
public class Solution {
    private Map<Integer, Integer> pos;

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        pos = new HashMap<>(post.length);
        for (int i = 0; i < post.length; i++) {
            pos.put(post[i], i);
        }
        return build(pre, post, 0, pre.length - 1, 0, post.length - 1);
    }

    private TreeNode build(int[] pre, int[] post, int preLeft, int preRight, int postLeft, int postRight) {
        if (preLeft > preRight || postLeft > postRight) {
            return null;
        }
        if (preLeft == preRight || postLeft == postRight) {
            return new TreeNode(pre[preLeft]);
        }
        TreeNode root = new TreeNode(pre[preLeft]);//pre[preLeft]当成根结点
        int postPos = pos.get(pre[preLeft + 1]);//pre[preLeft+1]当成左子树根结点
        root.left = build(pre, post, preLeft + 1, preLeft + postPos - postLeft + 1, postLeft, postPos);
        root.right = build(pre, post, preLeft + postPos - postLeft + 2, preRight, postPos + 1, postRight);
        return root;
    }
}

    