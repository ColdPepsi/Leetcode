/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 类Solution2.java的实现描述：DFS实现BFS
 *
 * @author wubiao21 2020年07月16日 11:59:05
 */
public class Solution2 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        dfs(root,0,res);
        return res;
    }

    private void dfs(TreeNode root, int level, List<Integer> res) {
        if (root == null) {
            return;
        }
        if (res.size() <= level) {
            res.add(root.val);
        }
        dfs(root.right, level + 1, res);
        dfs(root.left, level + 1, res);
    }
}