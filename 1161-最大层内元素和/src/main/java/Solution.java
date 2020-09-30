/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import entity.TreeNode;

/**
 * 类Solution.java的实现描述：还是dfs实现bfs
 *
 * @author wubiao21 2020年09月30日 15:41:59
 */
public class Solution {
    public int maxLevelSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = getDepth(root);//求深度会遍历一遍，如果不想求深度，可以直接生成一个大数组
        int[] sum = new int[depth];
        dfs(root, sum, 0);
        int index = 0;
        for (int i = 1; i < depth; i++) {
            if (sum[i] > sum[index]) {
                index = i;
            }
        }
        return index + 1;
    }

    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }

    private void dfs(TreeNode root, int[] sum, int level) {
        if (root == null) {
            return;
        }
        sum[level] += root.val;
        dfs(root.left, sum, level + 1);
        dfs(root.right, sum, level + 1);
    }
}