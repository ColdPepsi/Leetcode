/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import java.util.ArrayList;

/**
 * 类Solution.java的实现描述：dfs实现bfs
 *
 * @author wubiao21 2020年09月28日 09:02:49
 */
public class Solution {
    public Node connect(Node root) {
        dfs(root, 0, new ArrayList<>());
        return root;
    }

    private void dfs(Node root, int level, ArrayList<Node> rear) {
        if (root == null) {
            return;
        }
        if (rear.size() <= level) {
            rear.add(root);
        } else {
            rear.get(level).next = root;
            rear.set(level, root);
        }
        dfs(root.left, level + 1, rear);
        dfs(root.right, level + 1, rear);
    }
}