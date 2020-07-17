/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import entity.TreeNode;
import org.junit.Test;


/**
 * @author wubiao21 2020年07月17日 11:40:18
 */
public class SluTst {

    Solution solution = new Solution();
    TreeUtils treeUtils=new TreeUtils();

    @Test
    public void test() {
        int[] pre = {4,8,3,2,10};
        int[] in = {3,8,2,4,10};
        TreeNode root = treeUtils.buildTree(pre,in);
        printTreePreOrder(root);
        solution.pathSum(root,14);
    }
    private void printTreePreOrder(TreeNode root){
        if (root != null) {
            System.out.println(root.val);
            printTreePreOrder(root.left);
            printTreePreOrder(root.right);
        }
    }
}

    