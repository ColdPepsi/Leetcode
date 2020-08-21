/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */


import entity.TreeNode;

/**
 * 类Solution.java的实现描述：当把记录的基础类型的数据当做参数的时候，会有回溯的效果
 *
 * @author wubiao21 2020年08月21日 09:54:58
 */
public class Solution {

    private int res;//保存最终结果

    public int goodNodes(TreeNode root) {
        res = 0;
        count(root, Integer.MIN_VALUE);
        return res;
    }

    /**
     * 先序遍历统计好结点
     *
     * @param root 当前节点
     * @param max  表示当前路径上的最大值，把max当做参数的好处是，当退回上层的时候，max也会退回上层，相当于回溯的恢复现场
     */
    private void count(TreeNode root, int max) {
        if (root == null) {//空直接返回
            return;
        }
        if (root.val >= max) {//当前结点是路径上的最大结点，更新结果
            res++;
            max = root.val;
        }
        count(root.left, max);//递归处理左右孩子
        count(root.right, max);
    }
}