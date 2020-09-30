/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import entity.TreeNode;

/**
 * 类Solution.java的实现描述：同538题一样，反中序遍历
 *
 * @author wubiao21 2020年09月30日 18:18:37
 */
public class Solution {

    private int sum = 0;

    public TreeNode bstToGst(TreeNode root) {
        if (root != null) {
            bstToGst(root.right);
            root.val += sum;
            sum = root.val;
            bstToGst(root.left);
        }
        return root;
    }
}