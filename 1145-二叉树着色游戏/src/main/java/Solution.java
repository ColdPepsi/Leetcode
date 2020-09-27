/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */


import entity.TreeNode;

/**
 * 类Solution.java的实现描述：2020微软暑期实习面试题
 *
 * @author wubiao21 2020年09月17日 10:18:57
 */
public class Solution {

    private int leftCount = 0;//保存x结点左子树有多少个结点
    private int rightCount = 0;//保存x结点右子树有多少个结点

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        int half = n / 2;//一半的结点
        getCount(root, x);
        //思想就是切断x的联系，如果选x的左孩子，那么左孩子都是我的，选右孩子那么右孩子都是我的，选父结点，那么除了以x为根的子树，剩下的结点都是我的。
        //看看这3种选择能不能超过一半，超过一半则说明获胜
        return leftCount > half || rightCount > half || (n - leftCount - rightCount - 1) > half;
    }

    /**
     * 返回root有多个结点（包含root） 后序遍历即可
     *
     * @param root
     * @param x
     * @return
     */
    private int getCount(TreeNode root, int x) {
        if (root == null) {
            return 0;
        }
        int left = getCount(root.left, x);
        int right = getCount(root.right, x);
        if (root.val == x) {//如果当前结点是x保存结果
            leftCount = left;
            rightCount = right;
        }
        return left + right + 1;
    }
}