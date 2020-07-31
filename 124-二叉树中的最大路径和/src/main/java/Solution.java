/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import entity.TreeNode;

/**
 * @author wubiao21 2020年07月27日 10:35:36
 */
public class Solution {

    private int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return res;
    }

    /**
     * 返回以root为根节点的最大单边和，即math.max(root,root+left,root+right)
     *
     * @param root
     * @return
     */
    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(0, dfs(root.left));//计算左孩子最大单边和，负数舍弃
        int right = Math.max(0, dfs(root.right));
        res = Math.max(res, left + root.val + right);//更新最大值
        return root.val + Math.max(left, right);//返回最大单边和
    }
}