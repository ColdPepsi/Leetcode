/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯解法
 *
 * @author wubiao21 2020年07月17日 11:14:56
 */
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        backTracking(root, sum, new ArrayList<Integer>(), res);
        return res;
    }

    private void backTracking(TreeNode root, int sum, ArrayList<Integer> prefix, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        prefix.add(root.val);
        if (sum == root.val && isLeaf(root)) {
            res.add(new ArrayList<>(prefix));//保存结果
        }
        int leftSum = sum - root.val;//剩下的和
        backTracking(root.left, leftSum, prefix, res);
        backTracking(root.right, leftSum, prefix, res);
        prefix.remove(prefix.size() - 1);//恢复现场，删掉最后一个元素
    }

    /**
     * 判断node是否是叶子结点
     *
     * @param node 要判断的结点
     * @return 叶子结点返回true
     */
    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}