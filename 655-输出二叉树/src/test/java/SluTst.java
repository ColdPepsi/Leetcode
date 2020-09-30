/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import entity.TreeNode;
import org.junit.Test;

import java.util.List;

/**
 * @author wubiao21 2020年09月27日 15:07:52
 */
public class SluTst {
    Solution solution = new Solution();

    @Test
    public void test() {
        int[] preOrder = {1, 2, 4, 7, 5, 8, 3, 6};
        int[] inOrder = {4, 7, 2, 5, 8, 1, 3, 6};
        TreeUtils utils = new TreeUtils();
        TreeNode root = utils.buildTree(preOrder, inOrder);
        List<List<String>> lists = solution.printTree(root);
        StringBuilder temp = new StringBuilder();
        for (List<String> list : lists) {
            for (String s : list) {
                temp.append(s.equals("") ? " " : s);
            }
            temp.append("\r\n");
        }
        System.out.println(temp);
    }
}