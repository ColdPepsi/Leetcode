/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 类Solution.java的实现描述：先计算宽度和高度，然后生成相应大小的数组，然后遍历二叉树
 *
 * @author wubiao21 2020年09月27日 14:14:21
 */
public class Solution {
    public List<List<String>> printTree(TreeNode root) {
        int height = getHeight(root);
        int width = getWidth(height);
        String[][] ret = new String[height][width];
        preOrder(root, ret, 0, 0, width - 1);
        return copy(ret, height, width);
    }

    /**
     * 把ret数组转换成list并返回
     *
     * @param ret
     * @param height
     * @param width
     * @return
     */
    private List<List<String>> copy(String[][] ret, int height, int width) {
        List<List<String>> res = new ArrayList<>(height);
        for (String[] strings : ret) {
            List<String> line = new ArrayList<>(width);
            for (String string : strings) {
                line.add(string == null ? "" : string);
            }
            res.add(line);
        }
        return res;
    }

    /**
     * 线序遍历二叉树，把结果填写到ret数组中
     *
     * @param root  根节点
     * @param ret   数组
     * @param level 层号
     * @param left  本层区间左端点
     * @param right 本层区间右端点
     */
    private void preOrder(TreeNode root, String[][] ret, int level, int left, int right) {
        if (root == null) {
            return;
        }
        int mid = (left + right) / 2;
        ret[level][mid] = String.valueOf(root.val);
        preOrder(root.left, ret, level + 1, left, mid - 1);
        preOrder(root.right, ret, level + 1, mid + 1, right);
    }

    /**
     * 计算数组的宽度，1层宽度为1，2层宽度为3，3层宽度为7，4层宽度为15
     * 可以得到公式 f(n)=f(n-1)+(2^(n-1)),递归即可
     *
     * @param height
     * @return
     */
    private int getWidth(int height) {
        return height == 1 ? 1 : getWidth(height - 1) + (int) Math.pow(2, height - 1);
    }

    /**
     * 计算二叉树高度，左右子树的最大最大高度+1，后序遍历即可
     *
     * @param root
     * @return
     */
    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
}