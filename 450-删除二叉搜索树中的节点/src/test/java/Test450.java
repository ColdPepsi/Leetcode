/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import entity.TreeNode;
import org.junit.Test;

/**
 * 类Test450.java的实现描述：TODO 类实现描述
 *
 * @author wubiao21 2020年09月02日 14:10:52
 */
public class Test450 {
    Solution solution = new Solution();

    @Test
    public void test() {
        TreeNode node3 = new TreeNode(3);
        node3.left = new TreeNode(2);
        node3.right = new TreeNode(4);
        TreeNode node6 = new TreeNode(6);
        node6.right = new TreeNode(7);
        TreeNode node5 = new TreeNode(5);
        node5.left = node3;
        node5.right = node6;
        solution.deleteNode(node5,3);
    }
}

    